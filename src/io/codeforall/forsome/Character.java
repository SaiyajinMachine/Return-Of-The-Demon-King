package io.codeforall.forsome;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Character {

    //PROPERTIES
    int hp; //HealthPoints
    int str; //Strength
    int wis; //Wisdom
    int dex; //Dexterity
    protected boolean dead = false;

    //DEAD
    private Picture died = new Picture(410,160,"/io/codeforall/forsome/images/effects/dead.png");

    public void createDied() {
        died.draw();
        died.grow(0,-20);
    }

    //GETTERS
    public int getHp() {
        return this.hp;
    }
    public int getStr() {
        return this.str;
    }
    public int getWis() {
        return this.wis;
    }
    public int getDex() {
        return this.dex;
    }
    public boolean getDead(){
        return this.dead;
    }

    //SETTERS
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public void setWis(int wis) {
        this.wis = wis;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }

    //METHODS

    public void hit(int damage) {
        this.setHp(this.getHp() - damage);
        if (this.getHp() <= 0) {
            this.die();
        }
    }

    public void tremble(Picture picture) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                picture.translate(-10,0);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                picture.translate(10,0);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                picture.translate(10,0);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                picture.translate(-10,0);
            }
        });
                thread.start();

    }

    public void die() {
        dead = true;
        this.setHp(0);
        createDied();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        died.delete();
    }

    //BUFFS
    public void buffHp(int amount) {
        this.setHp(this.getHp() + amount);
    }
    public void buffStr(int amount) {
        this.setStr(this.getStr() + amount);
    }
    public void buffWis(int amount) {
        this.setWis(this.getWis() + amount);
    }
    public void buffDex(int amount) {
        this.setDex(this.getDex() + amount);
    }

    //DEBUFFS
    public void debuffStr(int amount) {
        this.setStr(this.getStr() - amount);
    }
    public void debuffWis(int amount) {
        this.setWis(this.getWis() - amount);
    }
    public void debuffDex(int amount) {
        this.setDex(this.getDex() - amount);
    }

}