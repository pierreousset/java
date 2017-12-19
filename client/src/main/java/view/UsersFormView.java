package view;

import component.LabelTextField;
import domain.User;
import model.UsersRoleSelection;
import presenter.UsersFormPresenter;

import javax.swing.*;
import javax.validation.ConstraintViolation;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static utils.Constants.*;

public class UsersFormView implements UsersFormPresenter.Displayable
{
    private JComboBox<UsersRoleSelection> userRole;
    private JButton backButton;
    private JButton submitButton;
    private Map<String, LabelTextField> fields;

    public UsersFormView() { fields = new HashMap<>(); }

    @Override
    public Component getComponent() {
        JPanel panel = new JPanel(new SpringLayout());
        addLastname(panel);
        addFirstname(panel);
        addEmail(panel);
        addPassword(panel);
        addUserRole(panel);
        backButton = new JButton("Back");
        submitButton = new JButton("Submit");
        panel.add(backButton);
        panel.add(submitButton);
        panel.setSize(600, 900);

        return panel;
    }

    private void addLastname(JPanel panel) {
        LabelTextField lastname = new LabelTextField("Nom");
        fields.put(LASTNAME, lastname);
        panel.add(lastname);
    }

    private void addFirstname(JPanel panel) {
        LabelTextField firstname = new LabelTextField("Prénom");
        fields.put(FIRSTNAME, firstname);
        panel.add(firstname);
    }

    private void addEmail(JPanel panel) {
        LabelTextField email = new LabelTextField("Email");
        fields.put(EMAIL, email);
        panel.add(email);
    }

    private void addPassword(JPanel panel) {
        LabelTextField password = new LabelTextField("Mot de Passe");
        fields.put(USERPASSWORD, password);
        panel.add(password);
    }

    private void addUserRole(JPanel panel) {
        JLabel userRoleLabel = new JLabel("Role de l'utilisateur");
        panel.add(userRoleLabel);
        userRole = new JComboBox<UsersRoleSelection>();
        userRoleLabel.setLabelFor(userRole);
        panel.add(userRole);
    }


    @Override
    public JButton getBackButton() {
        return backButton;
    }

    @Override
    public JButton getSubmitButton() {
        return submitButton;
    }

    @Override
    public JComboBox<UsersRoleSelection> getUserRole() {
        return userRole;
    }

    @Override
    public String getValueForField(String field) {
        return fields.get(field).getInputValue();
    }

    public void mapErrors(Set<ConstraintViolation<User>> errors){
        fields.entrySet().stream().forEach(entry -> {
            Optional<ConstraintViolation<User>> violation =  errors.stream().filter(c -> c.getPropertyPath().toString().equals(entry.getKey())).findFirst();
            if (violation.isPresent()){
                entry.getValue().displayErrorMessage(violation.get().getMessage());
            } else {
                entry.getValue().removeErrorMessage();
            }
        });
    }

    @Override
    public void reset() {
        userRole.setSelectedIndex(-1);
        fields.entrySet().stream().map(Map.Entry::getValue).forEach(LabelTextField::reset);
    }
}
