import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;
    private Scene sceneAccueil;
    private Scene sceneSignUp;
    private Scene sceneLoading;

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

    public Scene accueil(){
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

        boutonConnect.setOnAction(event->{
            changeScene(sceneLoading);
        });

        boutonInscrire.setOnAction(event->{
            changeScene(sceneSignUp);
        });

        fieldPassword.setOnAction(event->{
            boutonConnect.fire();
        });

        group.setTranslateX(125);
        group.setTranslateY(150);

        return scene;
    }

    public Scene signUp(){
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

        Spinner spinnerAge = new Spinner(18,150,18);
        spinnerAge.setTranslateY(385);
        group.getChildren().add(spinnerAge);

        CheckBox checkCondition = new CheckBox("J'accepte les conditions d'utilisation");
        checkCondition.setTranslateY(420);
        group.getChildren().add(checkCondition);

        boutonInscrire.setOnAction(event->{
            if(verification({}))
                changeScene(sceneAccueil);
        });

        boutonRetour.setOnAction(event->{
            changeScene(sceneAccueil);
        });

        boutonEffacer.setOnAction(event->{
            fieldPrenom.clear();
            fieldNom.clear();
            fieldUtilisateur.clear();
            fieldPassword.clear();
            fieldConfirmPassword.clear();
            groupBouton.getSelectedToggle().setSelected(false);
            spinnerAge.getValueFactory().setValue(18);
            checkCondition.setSelected(false);
        });

        group.setTranslateX(115);
        group.setTranslateY(50);

        return scene;
    }

    public Scene loading(){
        Group group = new Group();
        Scene scene = new Scene(group);

        ProgressIndicator progress = new ProgressIndicator();
        group.getChildren().add(progress);

        group.setTranslateX(175);
        group.setTranslateY(225);

        return scene;
    }

    public void changeScene(Scene scene){
        stage.setScene(scene);
    }

    public boolean verification(TextField[] listeTextField, ToggleGroup groupBouton, CheckBox checkCondition){
        for(int i=0;i<listeTextField.length;i++)
            for(int j=0;j<listeTextField[i].getText().length();j++)
                if(!(listeTextField[i].getText().charAt(j)<90&&listeTextField[i].getText().charAt(j)>65||listeTextField[i].getText().charAt(j)>97&&listeTextField[i].getText().charAt(j)<122))
                    return false;

        return true;
    }
}
