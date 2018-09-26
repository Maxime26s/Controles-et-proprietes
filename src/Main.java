import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Scene scene = accueil();
    }

    public Scene accueil(){
        Group group = new Group();
        Scene scene = new Scene(group);

        Button bouttonConnect = new Button();
        bouttonConnect.setText("Se connecter");
        group.getChildren().add(bouttonConnect);

        Label labelUtilisateur = new Label();
        labelUtilisateur.setText("Nom d'utilisateur");
        group.getChildren().add(labelUtilisateur);

        TextField fieldUtilisateur = new TextField();
        fieldUtilisateur.setPromptText("Nom d'utilisateur");
        group.getChildren().add(fieldUtilisateur);

        Label labelPassword = new Label();
        labelPassword.setText("Mot de passe");
        group.getChildren().add(labelPassword);

        TextField fieldPassword = new TextField();
        fieldPassword.setPromptText("Mot de passe");
        group.getChildren().add(fieldPassword);

        bouttonConnect.setOnAction(event->{
            System.out.println("Nom complet: " + fieldUtilisateur.getText() + " " + fieldPassword.getText());
        });
        fieldPassword.setOnAction(event->{
            bouttonConnect.fire();
        });
        return scene;
    }
}
