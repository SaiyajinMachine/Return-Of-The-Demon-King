package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Troll extends Enemy {

    //CONSTRUCTOR
    public Troll() {
        this.setHp(200);
        createTroll();
    }

    //CREATE TEXTBOX
    public Picture trolldie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/troll_die.png");
    public Picture textSmash = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/troll_smash.png");
    public Picture textSwipe = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/troll_swipe.png");
    public Picture textRegenerate = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/troll_regenerate.png");

    //CREATE
    public Picture troll = new Picture(600, 60, "/io/codeforall/forsome/images/enemies/troll.png");
    public void createTroll() {
        troll.draw();
    }

    //EFFECTS
    public Picture smash = new Picture(410, 160, "/io/codeforall/forsome/images/effects/smash.png");
    public Picture swipe = new Picture(410, 160, "/io/codeforall/forsome/images/effects/swipe.png");
    public Picture regenerate = new Picture(410, 160, "/io/codeforall/forsome/images/effects/regeneration.png");

    public void createSmash() {
        smash.draw();
    }
    public void createSwipe() {
        swipe.draw();
    }
    public void createRegenerate() {
        regenerate.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(troll);
    }

    @Override
    public void die() {
        trolldie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        trolldie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        troll.delete();
    }

    //SPELLS
    public void smash(Hero hero) {
        textSmash.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSmash.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createSmash();
        try {
            Thread.sleep(1000);
            smash.delete();
            hero.hit(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipe(Hero hero) {
        //(AOE)
        textSwipe.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSwipe.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createSwipe();
        try {
            Thread.sleep(1000);
            swipe.delete();
            hero.hit(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void regenerate() {
        textRegenerate.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textRegenerate.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createRegenerate();
        try {
            Thread.sleep(1000);
            regenerate.delete();
            this.buffHp(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
