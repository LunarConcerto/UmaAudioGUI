package com.github.lunarconcerto.umaaudiogui;

import org.nutz.dao.entity.annotation.Table;

@Table("a")
public class AssetInfo {

    int i ;

    String n ;

    String d ;

    int g ;

    int l ;

    long c ;

    String h ;

    String m ;

    int k ;

    int s ;

    int p ;

    public AssetInfo() {
    }

    public AssetInfo(int i, String n, String d, int g, int l, long c, String h, String m, int k, int s, int p) {
        this.i = i;
        this.n = n;
        this.d = d;
        this.g = g;
        this.l = l;
        this.c = c;
        this.h = h;
        this.m = m;
        this.k = k;
        this.s = s;
        this.p = p;
    }

    public int getI() {
        return i;
    }

    public AssetInfo setI(int i) {
        this.i = i;
        return this;
    }

    public String getHStart(){
        String hash = getH();

        return hash.substring(0,2);
    }

    public String getN() {
        return n.substring(n.lastIndexOf("/") + 1);
    }

    public AssetInfo setN(String n) {
        this.n = n;
        return this;
    }

    public String getD() {
        return d;
    }

    public AssetInfo setD(String d) {
        this.d = d;
        return this;
    }

    public int getG() {
        return g;
    }

    public AssetInfo setG(int g) {
        this.g = g;
        return this;
    }

    public int getL() {
        return l;
    }

    public AssetInfo setL(int l) {
        this.l = l;
        return this;
    }

    public long getC() {
        return c;
    }

    public AssetInfo setC(long c) {
        this.c = c;
        return this;
    }

    public String getH() {
        return h;
    }

    public AssetInfo setH(String h) {
        this.h = h;
        return this;
    }

    public String getM() {
        return m;
    }

    public AssetInfo setM(String m) {
        this.m = m;
        return this;
    }

    public int getK() {
        return k;
    }

    public AssetInfo setK(int k) {
        this.k = k;
        return this;
    }

    public int getS() {
        return s;
    }

    public AssetInfo setS(int s) {
        this.s = s;
        return this;
    }

    public int getP() {
        return p;
    }

    public AssetInfo setP(int p) {
        this.p = p;
        return this;
    }

    @Override
    public String toString() {
        return i+".name=" + getN() + "||hash=" + h ;
    }
}
