package model;

import domain.User;

public class UsersRoleSelection {

    private String name;
    private Class<? extends User> clazz;

    public UsersRoleSelection(String name, Class<? extends User> clazz){
        this.name = name;
        this.clazz = clazz;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Class<? extends User> getClazz(){
        return clazz;
    }

    public void setClazz(Class<? extends User> clazz){
        this.clazz = clazz;
    }
}
