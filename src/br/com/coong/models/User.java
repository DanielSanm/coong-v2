package br.com.coong.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User {

    private String name;
    private String email;
    private String password;
    private boolean isAdm;

    public User(String name, String email, String password, boolean isAdm) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdm = isAdm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        MessageDigest algorithm = null;
        try {

            algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdm() {
        return isAdm;
    }

    public void setAdm(boolean adm) {
        isAdm = adm;
    }
}
