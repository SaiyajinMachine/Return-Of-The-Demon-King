package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wolf extends Enemy {

    //CONSTRUCTOR
    public Wolf() {
        this.setHp(90);
        createWolf();
    }

    //CREATE TEXTBOX
    public Picture wolfDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/wolf_die.png");
    public Picture textHowl = new Picture(50,160,"/io/codeforall/forsome/images/text_box/wolf_howl.png");
    public Picture textCrunch = new Picture(50,160,"/io/codeforall/forsome/images/text_box/wolf_crunch.png");

    //CREATE
    public static Picture wolf = new Picture(730,200, "/io/codeforall/forsome/images/enemies/wolf.png");
    public void createWolf() {
        wolf.draw();
    }

    //EFFECTS
    public Picture howl = new Picture(410, 160, "/io/codeforall/forsome/images/effects/howl.png");
    public Picture crunch = new Picture(410, 160, "/io/codeforall/forsome/images/effects/bite.png");

    public void createHowl() {
        howl.draw();
    }
    public void createCrunch() {
        crunch.draw();
    }


    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(wolf);
    }

    @Override
    public void die() {
        wolfDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wolfDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wolf.delete();
    }

    //SPELLS
    public void howl(Hero hero) {
        // (Aoe)
        textHowl.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textHowl.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createHowl();
        try {
            Thread.sleep(1000);
            howl.delete();
            hero.debuffDex(4);
            hero.debuffWis(4);
            hero.debuffStr(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void crunch(Hero hero) {
        textCrunch.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textCrunch.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createCrunch();
        try {
            Thread.sleep(1000);
            crunch.delete();
            hero.hit(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

