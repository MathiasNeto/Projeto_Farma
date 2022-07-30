package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Main;

import javax.swing.*;
import java.io.IOException;

import java.util.Objects;

public class Dados {
    @FXML private Button btnatualizar;
    @FXML
    private TextField nome;
    @FXML public TextField cpf;
    @FXML public TextField telefone;
    @FXML public TextField email;
    @FXML public TextField senha;
    @FXML public TextField datanasc;
    @FXML public TextField genero;

    public void initialize() {
        nome.setText(Main.contacadastro.getNome());
        cpf.setText(Main.contacadastro.getCpf());
        telefone.setText(Main.contacadastro.getTelefone());
        email.setText(Main.contacadastro.getEmail());
        senha.setText(Main.contacadastro.getSenha());
        datanasc.setText(Main.contacadastro.getNasc());
        genero.setText(Main.contacadastro.getGenero());
    }

    public void btnvoltar() throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/Telas/home.fxml")));
        Main.stage.setScene(new Scene(parent));
    }
    public void btnexcluir() throws IOException {
        for (int i = 0; i < Main.listacont.size(); i++) {
            Main.listacont.remove(i);
        }


        JOptionPane.showMessageDialog(null,"Conta excluida com sucesso","Mensagem",1);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/Telas/login.fxml")));
        Main.stage.setScene(new Scene(parent));
    }
    public void onkeyRelesead(){
        boolean b = (email.getText().equals(Main.contacadastro.getEmail()));
        boolean o = (telefone.getText().equals(Main.contacadastro.getTelefone()));
        boolean l = (senha.getText().equals(Main.contacadastro.getSenha()));
        btnatualizar.setDisable(b && o && l);
    }

    public void atualizar() {
        if(!email.getText().equals(Main.contacadastro.getEmail())){
            Main.contacadastro.setEmail(email.getText());
            JOptionPane.showMessageDialog(null,"Email Atualizado");
        }
        if (!telefone.getText().equals(Main.contacadastro.getTelefone())){
            Main.contacadastro.setTelefone(telefone.getText());
            JOptionPane.showMessageDialog(null,"Telefone Atualizado");
        }
        if (!senha.getText().equals(Main.contacadastro.getSenha())){
            Main.contacadastro.setSenha(senha.getText());
            JOptionPane.showMessageDialog(null,"Senha Atualizada");
        }
    }
}
