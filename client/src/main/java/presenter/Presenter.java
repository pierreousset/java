package presenter;

import service.Dispatcher;
import view.View;

import java.awt.*;

public abstract class Presenter<V extends View> {
    private V view;

    public Presenter(V view){
        this.view = view;
    }

    public Component presentView(){
        return view.getComponent();
    }

    public V getView(){
        return view;
    }

    public abstract String getPath();

    public void execute(){

    }

    protected void goTo (String name) {
        Dispatcher.getInstance().present(name);
    }
}
