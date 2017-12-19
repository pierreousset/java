package view;

import presenter.UserListPresenter;

import javax.swing.*;
import java.awt.*;

public class UserListView implements UserListPresenter.Displayable {

    private JButton backButton;
    private JTable userTable;

    @Override
    public Component getComponent(){
        JPanel panel = new JPanel(new BorderLayout());

        backButton = new JButton("Back to dashboard");
        panel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        userTable = new JTable();
        panel.add(backButton, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public JButton getBackButton() {
        return backButton;
    }

    @Override
    public JTable getUserTable(){
        return userTable;
    }
}
