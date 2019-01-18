package com.example.dudas.sushi;

public class Profile {
    private String nazwa;
    private String opis;
    private Long cena;
    private boolean permission;

    public Profile() {
    }

    public Profile(String nazwa, String opis, Long cena, boolean permission) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.permission=permission;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
