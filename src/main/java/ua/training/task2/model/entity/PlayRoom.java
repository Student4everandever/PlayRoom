package ua.training.task2.model.entity;

import java.util.ArrayList;
import java.util.List;

public class PlayRoom {

    private List<Toy> toyList = new ArrayList<>();

    private String name;
    private String created;
    private String createdUa;
    private String modified;
    private String modifiedUa;

    public PlayRoom() {
    }

    public PlayRoom(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public void setToyList(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public List<Toy> getToyList() {
        return toyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedUa() {
        return createdUa;
    }

    public void setCreatedUa(String createdUa) {
        this.createdUa = createdUa;
    }

    public String getModifiedUa() {
        return modifiedUa;
    }

    public void setModifiedUa(String modifiedUa) {
        this.modifiedUa = modifiedUa;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
