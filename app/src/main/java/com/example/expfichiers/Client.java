package com.example.expfichiers;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Client implements Serializable
{
    private int num;
    private String nom;
    public Client() {
    }
    public Client(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }
    public void setNum(int num) {
        this.num = num;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        return "Client{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                '}';
    }
    public void ecrireDansFichier(Context context)
            throws IOException
    {
         File path = context.getFilesDir();
        File file = new File(path, "client.txt");
        FileOutputStream fw = new FileOutputStream(file,true);
        fw.write((num+"|" + nom +"\n").getBytes());
        fw.close();
        fw.close();
    }
    public static String lireDepuisFichier(Context context)
            throws IOException {
        File path = context.getFilesDir();
        File file = new File(path, "client.txt");
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        FileInputStream in = new FileInputStream(file);
        try {
            in.read(bytes);
        } finally {
            in.close();
        }
        String contents = new String(bytes);
        return contents;
    }
    public static ArrayList<Client>  chargerArrayListdepuisFichier(Context context)
            throws Exception
    {
        ArrayList<Client> Al = new ArrayList<>();
    String contents =lireDepuisFichier(context);
    StringTokenizer stt = new StringTokenizer(contents,"\n");
        String ligne;
        //Boucle sur les lignes
    while (stt.hasMoreTokens()) {
        ligne = stt.nextToken();
//Récupération des champs num et nom sépartés par |
        StringTokenizer st = new StringTokenizer(ligne, "|");
        int num = Integer.parseInt(st.nextToken().toString());
        String nom = st.nextToken().toString();
        Client cl = new Client(num, nom);
        Al.add(cl);
    }
    return  Al;
}
}
