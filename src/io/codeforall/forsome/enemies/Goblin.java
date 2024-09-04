package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Goblin extends Enemy {

    //CONSTRUCTOR
    public Goblin() {
        this.setHp(50);
        createGoblin();
    }

    //CREATE TEXTBOX
    public Picture goblinDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/goblin_die.png");
    public Picture textStab = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/goblin_stab.png");

    //CREATE
    public Picture goblin = new Picture(70, 280, "/io/codeforall/forsome/images/enemies/goblin.png");

    public void createGoblin() {
        goblin.draw();
    }

    //EFFECTS
    public Picture stab = new Picture(410, 160, "/io/codeforall/forsome/images/effects/stab.png");
    public void createStab() {
        stab.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(goblin);
    }

    @Override
    public void die() {
        goblinDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        goblinDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        goblin.delete();
    }

    //SPELLS
    public void stab(Hero hero) {
        textStab.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textStab.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hero.hit(20);
        createStab();
        try {
            Thread.sleep(1000);
            stab.delete();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
