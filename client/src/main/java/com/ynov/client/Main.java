package com.ynov.client;

import presenter.DashboardPresenter;
import presenter.LoginPresenter;
import presenter.UserListPresenter;
import presenter.UsersFormPresenter;
import service.Dispatcher;
import utils.SocketClient;
import view.DashboardView;
import view.LoginView;
import view.UserListView;
import view.UsersFormView;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {

    public static void main(String[] args) {
        invokeLater(Main::run);
    }

    private static void run() {
        JFrame jFrame = new JFrame();

        Dispatcher dispatcher = new Dispatcher(jFrame);
        dispatcher.registerPresenter(new DashboardPresenter(new DashboardView()));
        dispatcher.registerPresenter(new LoginPresenter(new LoginView()));
        dispatcher.registerPresenter(new UsersFormPresenter(new UsersFormView()));
        dispatcher.registerPresenter(new UserListPresenter(new UserListView()));
        jFrame.setVisible(true);
        jFrame.setName(DashboardPresenter.NAME);
        jFrame.setSize(800,800);
    }
}
