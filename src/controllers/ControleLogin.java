package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import objects.Conta;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControleLogin {
    @FXML
    private TextField Usuario;
    @FXML
    private Button btnentrar;
    @FXML
    private PasswordField Senha;
    @FXML
    private Button esqueci;


    public void Login() throws IOException {

        for (Conta conta : Main.listacont) {
            if (conta.getCpf().equals(Usuario.getText()) && conta.getSenha().equals(Senha.getText())) {
                Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Home.fxml"));
                Main.stage.setScene(new Scene(parent));
            } else {
                Usuario.setText("");
                Senha.setText("");
            }
        }
        if (Main.listacont.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ninguém Cadastrado", "Aviso", 1);
        }
    }

    public void onkeyRelesead() throws IOException {
        btnentrar.setDisable(Usuario.getText().isEmpty() || Senha.getText().isEmpty());
        esqueci.setDisable(Usuario.getText().isEmpty());
    }

    @FXML
    void openLink() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://api.whatsapp.com/send?phone=5583996998014&text=Ol%C3%A1!%20Tudo%20Bem%3F%2C%20Eu%20queria%20saber%20o%20usu%C3%A1rio%20e%20a%20senha%20padr%C3%A3o%20da%20plataforma%20Drogaria%20RM%3F"));
    }

    public void Cadastrarse() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/Telas/Cadastro.fxml"));
        Main.stage.setScene(new Scene(parent));
    }

    public void esquecisenha() throws IOException {
        if (Main.listacont.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Desculpe, mas primeiro você deve cadastrar-se!");

        } else {
            Parent parent = FXMLLoader.load(Main.class.getResource("/Telas/Rec_Senha.fxml"));

            Main.stage.setScene(new Scene(parent));
        }
    }
}
