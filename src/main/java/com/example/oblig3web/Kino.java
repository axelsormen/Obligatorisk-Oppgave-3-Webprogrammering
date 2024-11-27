package com.example.oblig3web;

public class Kino {
    private int id;
    private String film;
    private int antall;
    private String fornavn;
    private String etternavn;
    private int telefonnr;
    private String epost;

    public Kino() {
    }

    public Kino(int id, String film, int antall, String fornavn, String etternavn, int telefonnr, String epost) {
        this.id = id;
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }

    public int getId() {
        return id;
    }

    public String getFilm() {
        return film;
    }

    public int getAntall() {
        return antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getTelefonnr() {
        return telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setTelefonnr(int telefonnr) {
        this.telefonnr = telefonnr;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}


