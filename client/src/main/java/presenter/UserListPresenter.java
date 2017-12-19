package presenter;

import view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserListPresenter extends Presenter<UserListPresenter.Displayable> {

    public UserListPresenter(Displayable view){
        super(view);
    }

    public static final String NAME = "user";

    @Override
    public String getPath() {
        return NAME;
    }

    public interface Displayable extends View {
        JButton getBackButton();
        JTable getUserTable();
    }

    @Override
    public void execute(){
        getView().getBackButton().addActionListener(e -> goTo(DashboardPresenter.NAME));
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Nom", "Prenom", "Email", "Rôle"},0
        );

        getView().getUserTable().setModel(model);
    }
}