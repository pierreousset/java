package view;

import component.LabelTextField;
import presenter.LoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static utils.Constants.*;

public class LoginView implements LoginPresenter.Displayable{

    private JButton submitButton;
    private Map<String, LabelTextField> fields;

    public LoginView(){
        fields = new HashMap<>();
    }

    @Override
    public Component getComponent() {
        JPanel panel = new JPanel();
        addLoginField(panel);
        addPasswordField(panel);
        addIPAddressField(panel);
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        panel.setSize(600,900);

        return panel;
    }

    private void addLoginField(JPanel panel){
        LabelTextField  loginfield = new LabelTextField("Email");
        fields.put(LOGINFIELD, loginfield);
        panel.add(loginfield);
    }

    private void addPasswordField(JPanel panel){
        LabelTextField  passwordfield = new LabelTextField("Mot de passe");
        fields.put(PASSWORD, passwordfield);
        panel.add(passwordfield);
    }

    private void addIPAddressField(JPanel panel){
        LabelTextField  ipAddressfield = new LabelTextField("Adresse IP");
        fields.put(IPADDRESS, ipAddressfield);
        panel.add(ipAddressfield);
    }

    @Override
    public JButton getSubmitButton() {
        return submitButton;
    }

    @Override
    public String getValueForField(String field){
        return fields.get(field).getInputValue();
    }
}
