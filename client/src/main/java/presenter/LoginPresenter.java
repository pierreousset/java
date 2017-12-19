package presenter;

import com.google.gson.Gson;
import utils.SocketClient;
import model.UserSimple;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static utils.Constants.IPADDRESS;
import static utils.Constants.LOGINFIELD;
import static utils.Constants.PASSWORD;

public class LoginPresenter extends Presenter<LoginPresenter.Displayable> {

    public static final String NAME = "login-form";

    public LoginPresenter(Displayable view){
        super(view);
    }

    @Override
    public void execute(){
        getView().getSubmitButton().addActionListener(this::loginClient);
    }

    private void loginClient(ActionEvent actionEvent) {
        Gson gson = new Gson();
        UserSimple userObject = new UserSimple(
                getView().getValueForField(LOGINFIELD),
                getView().getValueForField(PASSWORD),
                getView().getValueForField(IPADDRESS)
        );
        String userJson = gson.toJson(userObject);

        String host = "10.31.0.222";
        int port = 2345;
        SocketClient connexion = new SocketClient(host, port);
        connexion.myConnexion(userJson, host, port);
        System.out.print(userJson);
    }

    @Override
    public String getPath() { return NAME; }

    public interface Displayable extends View {

        JButton getSubmitButton();
        String getValueForField(String field);
    }
}
