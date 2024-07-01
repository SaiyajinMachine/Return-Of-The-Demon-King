package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Witch extends Enemy {

    //CONSTRUCTOR
    public Witch() {
        this.setHp(180);
        createWitch();
    }

    //CREATE TEXTBOX
    public Picture witchDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/witch_die.png");
    public Picture textPestilence = new Picture(50,160,"/io/codeforall/forsome/images/text_box/witch_pestilence.png");
    public Picture textAffliction = new Picture(50,160,"/io/codeforall/forsome/images/text_box/witch_affliction.png");

    //CREATE
    public static Picture witch = new Picture(490,130, "/io/codeforall/forsome/images/enemies/witch.png");
    public void createWitch() {
        witch.draw();
    }

    //EFFECTS
    public Picture pestilence = new Picture(410,160, "/io/codeforall/forsome/images/effects/affliction.png");
    public Picture affliction = new Picture(410,160, "/io/codeforall/forsome/images/effects/pestilence.png");
    public void createPestilence() {
        pestilence.draw();
    }
    public void createAffliction() {
        affliction.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(witch);
    }

    @Override
    public void die() {
        witchDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        witchDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        witch.delete();
    }

    //SPELLS
    public void pestilence(Hero hero) {
        //(Aoe)
        textPestilence.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textPestilence.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createPestilence();
        try {
            Thread.sleep(1000);
            pestilence.delete();
            hero.debuffDex(5);
            hero.debuffWis(5);
            hero.debuffStr(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void affliction(Hero hero) {
        //(Aoe)
        textAffliction.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textAffliction.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createAffliction();
        try {
            Thread.sleep(1000);
            affliction.delete();
            hero.hit(35);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
