package presenter;

import view.View;

import javax.swing.*;

public class DashboardPresenter extends Presenter<DashboardPresenter.Displayable> {

    public static final String NAME = "dashboard";

    public interface Displayable extends View {
        JButton getLoginButton();
    }

    public DashboardPresenter(Displayable view) {super(view);}

    @Override
    public void execute() {
        getView().getLoginButton().addActionListener(e -> goTo(LoginPresenter.NAME));
    }

    @Override
    public String getPath() { return NAME; }
}
