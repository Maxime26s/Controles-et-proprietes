import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.security.MessageDigest;
import java.util.HashMap;

public class Main extends Application {
    private Stage stage;
    private Scene sceneAccueil;
    private Scene sceneSignUp;
    private Scene sceneLoading;
    private HashMap<String,User> hashMapUser;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setWidth(400);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Laboratoire 5");
        primaryStage.setResizable(false);

        sceneAccueil = accueil();
        sceneSignUp = signUp();
        sceneLoading = loading();

        primaryStage.setScene(sceneAccueil);
        primaryStage.show();
    }

    public Scene accueil() {
        hashMapUser = new HashMap<>();
        load();

        Group group = new Group();
        Scene scene = new Scene(group);

        Button boutonConnect = new Button();
        boutonConnect.setText("Se connecter");
        boutonConnect.setTranslateY(120);
        group.getChildren().add(boutonConnect);

        Button boutonInscrire = new Button();
        boutonInscrire.setText("S'inscrire");
        boutonInscrire.setTranslateY(120);
        boutonInscrire.setTranslateX(85);
        group.getChildren().add(boutonInscrire);

        Label labelUtilisateur = new Label();
        labelUtilisateur.setText("Nom d'utilisateur");
        group.getChildren().add(labelUtilisateur);

        TextField fieldUtilisateur = new TextField();
        fieldUtilisateur.setPromptText("Nom d'utilisateur");
        fieldUtilisateur.setTranslateY(25);
        group.getChildren().add(fieldUtilisateur);

        Label labelPassword = new Label();
        labelPassword.setText("Mot de passe");
        labelPassword.setTranslateY(60);
        group.getChildren().add(labelPassword);

        TextField fieldPassword = new TextField();
        fieldPassword.setPromptText("Mot de passe");
        fieldPassword.setTranslateY(85);
        group.getChildren().add(fieldPassword);

        Label labelErreur = new Label();
        labelErreur.setTextFill(Color.RED);
        labelErreur.setTranslateY(155);
        group.getChildren().add(labelErreur);

        boutonConnect.setOnAction(event -> {
            TextField[] listeTextField = {fieldUtilisateur,fieldPassword};
            if(connect(listeTextField,labelErreur))
                changeScene(sceneLoading);
        });

        boutonInscrire.setOnAction(event -> {
            changeScene(sceneSignUp);
        });

        fieldPassword.setOnAction(event -> {
            boutonConnect.fire();
        });

        group.setTranslateX(125);
        group.setTranslateY(150);

        return scene;
    }

    public Scene signUp() {
        Group group = new Group();
        Scene scene = new Scene(group);

        Button boutonInscrire = new Button();
        boutonInscrire.setText("S'inscrire");
        boutonInscrire.setTranslateY(455);
        group.getChildren().add(boutonInscrire);

        Button boutonEffacer = new Button();
        boutonEffacer.setText("Effacer");
        boutonEffacer.setTranslateY(455);
        boutonEffacer.setTranslateX(75);
        group.getChildren().add(boutonEffacer);

        Button boutonRetour = new Button();
        boutonRetour.setText("Retour");
        boutonRetour.setTranslateY(455);
        boutonRetour.setTranslateX(150);
        group.getChildren().add(boutonRetour);

        Label labelPrenom = new Label();
        labelPrenom.setText("Prénom");
        group.getChildren().add(labelPrenom);

        TextField fieldPrenom = new TextField();
        fieldPrenom.setPromptText("Prénom");
        fieldPrenom.setTranslateY(25);
        group.getChildren().add(fieldPrenom);

        Label labelNom = new Label();
        labelNom.setText("Nom");
        labelNom.setTranslateY(60);
        group.getChildren().add(labelNom);

        TextField fieldNom = new TextField();
        fieldNom.setPromptText("Nom");
        fieldNom.setTranslateY(85);
        group.getChildren().add(fieldNom);

        Label labelUtilisateur = new Label();
        labelUtilisateur.setText("Nom d'utilisateur");
        labelUtilisateur.setTranslateY(120);
        group.getChildren().add(labelUtilisateur);

        TextField fieldUtilisateur = new TextField();
        fieldUtilisateur.setPromptText("Nom d'utilisateur");
        fieldUtilisateur.setTranslateY(145);
        group.getChildren().add(fieldUtilisateur);

        Label labelPassword = new Label();
        labelPassword.setText("Mot de passe");
        labelPassword.setTranslateY(180);
        group.getChildren().add(labelPassword);

        PasswordField fieldPassword = new PasswordField();
        fieldPassword.setPromptText("Mot de passe");
        fieldPassword.setTranslateY(205);
        group.getChildren().add(fieldPassword);

        Label labelConfirmPassword = new Label();
        labelConfirmPassword.setText("Mot de passe");
        labelConfirmPassword.setTranslateY(240);
        group.getChildren().add(labelConfirmPassword);

        PasswordField fieldConfirmPassword = new PasswordField();
        fieldConfirmPassword.setPromptText("Confirmer le mot de passe");
        fieldConfirmPassword.setTranslateY(265);
        group.getChildren().add(fieldConfirmPassword);

        Label labelGenre = new Label();
        labelGenre.setText("Genre");
        labelGenre.setTranslateY(300);
        group.getChildren().add(labelGenre);

        RadioButton boutonHomme = new RadioButton("Homme");
        boutonHomme.setTranslateY(325);
        group.getChildren().add(boutonHomme);

        RadioButton boutonFemme = new RadioButton("Femme");
        boutonFemme.setTranslateY(325);
        boutonFemme.setTranslateX(75);
        group.getChildren().add(boutonFemme);

        RadioButton boutonAutre = new RadioButton("Autre");
        boutonAutre.setTranslateY(325);
        boutonAutre.setTranslateX(150);
        group.getChildren().add(boutonAutre);

        ToggleGroup groupBouton = new ToggleGroup();
        boutonHomme.setToggleGroup(groupBouton);
        boutonFemme.setToggleGroup(groupBouton);
        boutonAutre.setToggleGroup(groupBouton);

        Label labelAge = new Label();
        labelAge.setText("Âge");
        labelAge.setTranslateY(360);
        group.getChildren().add(labelAge);

        Spinner spinnerAge = new Spinner(18, 150, 18);
        spinnerAge.setTranslateY(385);
        group.getChildren().add(spinnerAge);

        CheckBox checkCondition = new CheckBox("J'accepte les conditions d'utilisation");
        checkCondition.setTranslateY(420);
        group.getChildren().add(checkCondition);

        Label labelErreur = new Label();
        labelErreur.setTextFill(Color.RED);
        labelErreur.setTranslateX(-50);
        labelErreur.setTranslateY(490);
        group.getChildren().add(labelErreur);

        boutonInscrire.setOnAction(event -> {
            TextField[] fieldArray = {fieldPrenom, fieldNom, fieldUtilisateur, fieldPassword, fieldConfirmPassword};
            if (verification(fieldArray, groupBouton, checkCondition, labelErreur)) {
                String[] stringArray = {fieldPrenom.getText(), fieldNom.getText(), fieldUtilisateur.getText(), fieldPassword.getText(), ""};
                if (boutonHomme.isSelected())
                    stringArray[4] = "Homme";
                else if (boutonHomme.isSelected())
                    stringArray[4] = "Femme";
                else
                    stringArray[4] = "Autre";
                inscription(stringArray, (int) spinnerAge.getValueFactory().getValue());
                changeScene(sceneAccueil);
            }
        });

        boutonRetour.setOnAction(event -> {
            changeScene(sceneAccueil);
        });

        boutonEffacer.setOnAction(event -> {
            fieldPrenom.clear();
            fieldNom.clear();
            fieldUtilisateur.clear();
            fieldPassword.clear();
            fieldConfirmPassword.clear();
            if (groupBouton.getSelectedToggle() != null)
                groupBouton.getSelectedToggle().setSelected(false);
            spinnerAge.getValueFactory().setValue(18);
            checkCondition.setSelected(false);
        });

        group.setTranslateX(115);
        group.setTranslateY(50);

        return scene;
    }

    public Scene loading() {
        Group group = new Group();
        Scene scene = new Scene(group);

        ProgressIndicator progress = new ProgressIndicator();
        group.getChildren().add(progress);

        group.setTranslateX(175);
        group.setTranslateY(225);

        return scene;
    }

    public void changeScene(Scene scene) {
        stage.setScene(scene);
    }

    public boolean verification(TextField[] listeTextField, ToggleGroup groupBouton, CheckBox checkCondition, Label labelErreur) {
        for (int i = 0; i < listeTextField.length; i++) {
            for (int j = 0; j < listeTextField[i].getText().length(); j++)
                if (!(listeTextField[i].getText().charAt(j) <= 90 && listeTextField[i].getText().charAt(j) >= 65 || listeTextField[i].getText().charAt(j) >= 97 && listeTextField[i].getText().charAt(j) <= 122)) {
                    labelErreur.setText("Erreur: Caractère invalide dans le " + listeTextField[i].getPromptText());
                    return false;
                }
            if (listeTextField[i].getText().isEmpty()) {
                labelErreur.setText("Erreur: " + listeTextField[i].getPromptText() + " manquant");
                return false;
            }
        }
        if (listeTextField[3].getText().equals(listeTextField[4].getText())) {
            labelErreur.setText("Erreur: Confirmation de mot de passe échouée");
            return false;
        }
        if (hashMapUser.get(listeTextField[2].getText())!=null) {
            labelErreur.setText("Erreur: Nom d'utilisateur déjà utilié");
            return false;
        }
        if (groupBouton.getSelectedToggle() == null) {
            labelErreur.setText("Erreur: Genre manquant");
            return false;
        }
        if (!checkCondition.isSelected()) {
            labelErreur.setText("Erreur: Veuillez accepter les conditions d'utilisation");
            return false;
        }
        labelErreur.setText("");
        return true;
    }

    public boolean connect(TextField[] listeTextField, Label labelErreur) {
        for (int i = 0; i < listeTextField.length; i++)
            if (listeTextField[i].getText().isEmpty()) {
                labelErreur.setText("Erreur: " + listeTextField[i].getPromptText() + " manquant");
                return false;
            }
            if(hashMapUser.get(listeTextField[0].getText())==null){
                labelErreur.setText("Erreur: Utilisateur non-existant");
                return false;
            }
            if (!hashMapUser.get(listeTextField[0].getText()).getPassword().equals(hash(listeTextField[1].getText()))){
                labelErreur.setText("Erreur: Mauvais mot de passe");
                return false;
            }
        labelErreur.setText("");
        return true;
    }

    public void inscription(String[] listeString, int age) {
        listeString[3] = hash(listeString[3]);
        String textCSV = listeString[0] + "," + listeString[1] + "," + listeString[2] + "," + listeString[3] + "," + listeString[4] + "," + age;
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("users.csv")));
            sortie.writeObject(textCSV);
            sortie.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hashMapUser.put(listeString[2],new User(listeString[0],listeString[1],listeString[2],listeString[3],listeString[4],age));
    }

    public String hash(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(string.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void load() {
        try {
            ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream("users.csv")));
            String string;
            while ((string = (String)entree.readObject()) != null) {
                String[] parts = string.split(",");
                hashMapUser.put(parts[2],new User(parts[0],parts[1],parts[2],parts[3],parts[4],Integer.parseInt(parts[5])));
            }
        }catch (Exception e) {
            System.out.println("Lecture du CSV terminée");
        }
    }
}
