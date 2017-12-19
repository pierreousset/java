package presenter;

import domain.User;
import model.UsersRoleSelection;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static utils.Constants.*;

public class UsersFormPresenter extends Presenter<UsersFormPresenter.Displayable>
{
    public static final String NAME = "users-form";

    public UsersFormPresenter(Displayable view)
    {
        super(view);
    }

    public void execute() {
        populateComboBox();
        getView().getBackButton().addActionListener(e -> goTo(DashboardPresenter.NAME));
        getView().getSubmitButton().addActionListener(this::createUser);
    }

    private void createUser(ActionEvent actionEvent) {
        UsersRoleSelection selection = (UsersRoleSelection) getView().getUserRole().getSelectedItem();
        try {
            User user = selection
                    .getClazz()
                    .getConstructor(String.class, String.class, String.class, String.class)
                    .newInstance(
                            getView().getValueForField(LASTNAME),
                            getView().getValueForField(FIRSTNAME),
                            getView().getValueForField(EMAIL),
                            getView().getValueForField(USERPASSWORD)
                    );
            getView().reset();
            goTo(DashboardPresenter.NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateComboBox() {
    getView().getUserRole().setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if(value instanceof UsersRoleSelection) {
                setText(((UsersRoleSelection) value).getName());
            }
            return this;
        }
    });
}

    @Override
    public String getPath() {
        return NAME;
    }

    public interface Displayable extends View {
        JButton getBackButton();
        JButton getSubmitButton();
        JComboBox<UsersRoleSelection> getUserRole();//Manque la liste et la methode de selection de l'user
        String getValueForField(String field);
        void reset();
    }

}
