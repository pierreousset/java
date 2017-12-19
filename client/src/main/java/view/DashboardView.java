package view;

import presenter.DashboardPresenter;

import javax.swing.*;
import java.awt.*;

public class DashboardView implements DashboardPresenter.Displayable {

    private JButton loginButton;

    public DashboardView(){
        loginButton = new JButton("Log In");
    }

    @Override
    public Component getComponent() {
        DefaultButtonModel model = new DefaultButtonModel();
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(Box.createVerticalGlue());
        verticalBox.add(loginButton);
        verticalBox.add(Box.createVerticalGlue());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(verticalBox);
        return panel;
    }

    @Override
    public JButton getLoginButton() {
        return loginButton;
    }
}
