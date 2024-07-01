package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ghoul extends Enemy {

    //CONSTRUCTOR
    public Ghoul() {
        this.setHp(100);
        createGhoul();
    }

    //CREATE TEXTBOX
    public Picture ghoulDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/ghoul_die.png");
    public Picture textCannibalize = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/ghoul_cannibalize.png");
    public Picture textVomit = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/ghoul_vomit.png");

    //CREATE
    public Picture ghoul = new Picture(70, 230, "/io/codeforall/forsome/images/enemies/ghoul.png");
    public void createGhoul() {
        ghoul.draw();
    }

    //EFFECTS
    public Picture cannibalize = new Picture(410, 160, "/io/codeforall/forsome/images/effects/cannibalize.png");
    public Picture vomit = new Picture(410, 160, "/io/codeforall/forsome/images/effects/vomit.png");

    public void createCannibalize() {
        cannibalize.draw();
    }
    public void createVomit() {
        vomit.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(ghoul);
    }

    @Override
    public void die() {
        ghoulDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ghoulDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ghoul.delete();
    }

    //SPELLS
    public void cannibalize(Hero hero) {
        textCannibalize.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textCannibalize.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createCannibalize();
        try {
            Thread.sleep(1000);
            cannibalize.delete();
            hero.hit(25);
            this.buffHp(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void vomit(Hero hero) {
        //(AOE)
        textVomit.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textVomit.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createVomit();
        try {
            Thread.sleep(1000);
            vomit.delete();
            hero.debuffDex(4);
            hero.debuffWis(4);
            hero.debuffStr(4);
            hero.hit(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
