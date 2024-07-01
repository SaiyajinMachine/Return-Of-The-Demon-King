package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bat extends Enemy {

    //CONSTRUCTOR
    public Bat() {
        this.setHp(50);
        createBat();
    }

    //CREATE TEXTBOX
    public Picture textBite = new Picture(50,160,"/io/codeforall/forsome/images/text_box/bat_bite.png");
    public Picture textScreech = new Picture(50,160,"/io/codeforall/forsome/images/text_box/bat_screech.png");
    public Picture textBatDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/bat_die.png");

    //CREATE
    public Picture bat = new Picture(470,60, "/io/codeforall/forsome/images/enemies/bat.png");
    public void createBat() {
        bat.draw();
    }

    //EFFECTS
    public Picture screech = new Picture(410,160,"/io/codeforall/forsome/images/effects/screech.png");
    public Picture bite = new Picture(410,160,"/io/codeforall/forsome/images/effects/bite.png");

    public void createScreech() {
        screech.draw();
    }
    public void createBite() {
        bite.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(bat);
    }

    @Override
    public void die() {
        textBatDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBatDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bat.delete();
    }

    //SPELLS
    public void screech(Hero hero) {
        textScreech.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textScreech.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       createScreech();
        try {
            Thread.sleep(1000);
            screech.delete();
            hero.debuffDex(2);
            hero.debuffWis(2);
            hero.debuffStr(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void bite(Hero hero) {
        textBite.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBite.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createBite();
        try {
            Thread.sleep(1000);
            bite.delete();
            hero.hit(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
