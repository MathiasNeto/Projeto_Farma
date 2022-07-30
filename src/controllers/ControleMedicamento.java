package controllers;

import javafx.scene.control.Button;
import objects.Medicamentos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import main.Main;
import javax.swing.*;
import java.io.IOException;

public class ControleMedicamento {
    @FXML private Button SalvarM;
    @FXML public Button btnfinalizar;
    @FXML
    private TextField Nomemedicam;
    @FXML
    private TextField Precomedicam;

    public void salavarMedicamentos() {
        //Devo criar algo que verifica se os campos estão preenchidos, e se tiverem preenchidos o botao é habilitado
        //devo criar algo que limpe os campos após o botao salvar for clicado

        JOptionPane.showMessageDialog(null, "Medicamento Cadastrado com Sucesso");
        Medicamentos medicamentos = new Medicamentos();
        medicamentos.setNome(Nomemedicam.getText());
        medicamentos.setPreco(Double.parseDouble(Precomedicam.getText()));
        Main.listaMedic.add(medicamentos);
        Nomemedicam.setText("");
        Precomedicam.setText("");
        SalvarM.setDisable(true);
    }

    public void Voltarhome() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Home.fxml"));
        Main.stage.setScene(new Scene(parent));
    }

    public void finalizar() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Home.fxml"));
        Main.stage.setScene(new Scene(parent));
    }
    public void onkeyRelesead(){
        boolean entrar;
        entrar = Nomemedicam.getText().isEmpty() || Precomedicam.getText().isEmpty();
        SalvarM.setDisable(entrar);

    }
}
