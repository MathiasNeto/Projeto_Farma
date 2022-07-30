
package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import main.Main;
import objects.Conta;
import javax.swing.*;
import java.io.IOException;


public class ControleCadastro {


    @FXML
    public TextField nomeField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField telefoneField;
    @FXML
    public TextField cPFField;
    @FXML
    public TextField senhaField0;
    @FXML
    public TextField senhaField1;
    @FXML
    public TextField nasc;

    @FXML
    private RadioButton masculino;
    @FXML
    private RadioButton feminino;
    @FXML
    private RadioButton r3;
    @FXML
    private Button cadastraru;


    public void Cadastrar() throws IOException {

        Conta conta = new Conta();
        conta.setNome(nomeField.getText());
        conta.setCpf(cPFField.getText());
        conta.setEmail(emailField.getText());
        conta.setTelefone(telefoneField.getText());
        conta.setSenha(senhaField0.getText());
        conta.setNasc(nasc.getText());
        Main.listacont.add(conta);

        if (masculino.isSelected()) {
            conta.setGenero("Masculino");
        } else if (feminino.isSelected()) {
            conta.setGenero("Feminino");

        }
        if(nomeField.getText().isEmpty() || cPFField.getText().isEmpty() || telefoneField.getText().isEmpty() || emailField.getText().isEmpty() || senhaField0.getText().isEmpty() || nasc.getText().isEmpty()){
            cadastraru.setDisable(true);
        }
        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Home.fxml"));
        Main.stage.setScene(new Scene(parent));
        //Parent é usado pq ele é o pai de todos
        //os estilos : vbox, hbox e outros containers

        Main.contacadastro = conta;
    }

    public void voltarLogin() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Login.fxml"));
        Main.stage.setScene(new Scene(parent));
    }

    public void setCadastraru() {
        cadastraru.setDisable(r3.isSelected());
    }
}


