package io.codeforall.forsome.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Slime extends Enemy{

    //CONSTRUCTOR
    public Slime() {
        this.setHp(20);
        createSlime();
    }

    //CREATE TEXTBOX
    public Picture textSplash = new Picture(50,160,"/io/codeforall/forsome/images/text_box/slime_splash.png");
    public Picture textSlimeDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/slime_die.png");

    //CREATE
    public Picture slime = new Picture(170,230, "/io/codeforall/forsome/images/enemies/slime.png");
    public void createSlime() {
        slime.draw();
    }

    //EFFECTS
    public Picture splash = new Picture(410,160, "/io/codeforall/forsome/images/effects/splash.png");
    public void createSplash() {
        splash.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(slime);
    }

    @Override
    public void die() {
        textSlimeDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSlimeDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        slime.delete();
    }

    //SPELLS
    public void splash() {
        textSplash.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSplash.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createSplash();
        try {
            Thread.sleep(1000);
            splash.delete();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
