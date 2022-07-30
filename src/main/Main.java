package main;

import objects.Conta;
import objects.Medicamentos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static Conta contacadastro;

    public static Stage stage;
    public static List<Medicamentos> listaMedic = new ArrayList<>();
    public static List<Conta> listacont = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }



    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        stage.setTitle("Drogaria RM");
        URL resource = Main.class.getResource("/telas/Login.fxml");
        Parent node = FXMLLoader.load(resource);

        Scene scene = new Scene(node);

        stage.setScene(scene);

        stage.show();

    }
}