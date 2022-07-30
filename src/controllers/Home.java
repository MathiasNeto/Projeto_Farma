package controllers;

import javafx.scene.control.Button;
import objects.Medicamentos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import main.Main;
import java.io.IOException;
import java.util.Objects;

public class Home {
    @FXML private Button listmed;

    @FXML private Button date;

    @FXML
    private ListView<String> listMedic;

    public void initialize() {
        if (listMedic != null) {
            for (int i = 0; i < Main.listaMedic.size(); i++) {
                Medicamentos nome = Main.listaMedic.get(i);
                listMedic.getItems().add(nome.getNome());
                listMedic.getItems().add((nome.getPreco()));
            }
        }
    }


    public void CadastrarM() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/CadastrarM.fxml"));
        Main.stage.setScene(new Scene(parent));
    }

    public void ListarMedic() throws IOException {
        //devo criar algo pra verificar se a lista tem medicamentos cadstrados, se tiver o botao é habilitado, se nao ele fica
        //desabilitado, e informar uma mensagem dizendo para cadastrar pelo menos um produto
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/ListarR.fxml"));
        Main.stage.setScene(new Scene(parent));

    }
    @FXML
    public void btnvoltar() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/home.fxml"));
        Main.stage.setScene(new Scene(parent));
    }
    public  void  btnsair () throws IOException {
        Parent sair = FXMLLoader.load(Main.class.getResource("/telas/Login.fxml"));
        Main.stage.setScene(new Scene(sair));
    }

    public void data() throws IOException {
        Parent parent = FXMLLoader.load(Main.class.getResource("/telas/Mydate.fxml"));
        Main.stage.setScene(new Scene(parent));
    }
}