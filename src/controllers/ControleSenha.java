package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import objects.Conta;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ControleSenha {
    //Aqui tenho que criar um metodo que seleciona sua conta para fazer a atualização de senha na conta correta

    @FXML
    private TextField nome;
    @FXML
    private TextField senha;
    @FXML private Label lblsenha;

    public void voltar() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Login.fxml"));
        Main.stage.setScene(new Scene(parent));
    }
    public void buscar(){
        for (Conta conta : Main.listacont) {
            if(nome.getText().equals(conta.getNome())){
                lblsenha.setVisible(true);
                senha.setVisible(true);
                senha.setText(conta.getSenha());
            }
            else {
                JOptionPane.showMessageDialog(null,"Ninguém com esse Nome");
            }
        }


        //Falta atualizar a senha da conta e exibir uma mensagem dizendo que a senha foi atualizada com sucesso
        // só devo habilitar o botao salvar  a senha se os campos de texto tiverem tudo preenchido

    }
}
