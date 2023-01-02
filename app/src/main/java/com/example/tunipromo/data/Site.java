package com.example.tunipromo.data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Site implements Serializable {
    private String id;
    private String titre;
    private String categorie;
    private String localisation;
    private List<String> imgs;
    private String videos;
    private String descr;

    public Site(String id, String titre, String categorie, String localisation, List<String> imgs, String videos, String descr) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.localisation = localisation;
        this.imgs = imgs;
        this.videos = videos;
        this.descr = descr;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
