package com.example.maisestudo;

import java.io.Serializable;

public class Users implements Serializable {
    public String email;
    public String name;
    public String uid;
    public Integer cursos;
    public String turno;

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Users(String email, String name, String uid, Integer cursos) {
        this.email = email;
        this.name = name;
        this.uid = uid;
        this.cursos = cursos;
    }

    public Users() {

    }

    public Integer getCursos() {
        return cursos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCursos(Integer cursos) {
        this.cursos = cursos;
    }
}
