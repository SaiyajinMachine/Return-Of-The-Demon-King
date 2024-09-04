package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DevilLord extends Enemy {

    //CONSTRUCTOR
    public DevilLord() {
        this.setHp(400);
        createDevilLord();
    }

    //CREATE TEXTBOX
    public Picture devilLordDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/devil_lord_die.png");
    public Picture textIncinerate = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/devil_lord_incinerate.png");
    public Picture textCataclysm = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/devil_lord_cataclysm.png");

    //CREATE
    public static Picture devilLord = new Picture(300, 40, "/io/codeforall/forsome/images/enemies/devilLord.png");
    public void createDevilLord() {
        devilLord.draw();
    }

    //EFFECTS
    public Picture incinerate = new Picture(410, 160, "/io/codeforall/forsome/images/effects/incinerate.png");
    public Picture cataclysm = new Picture(410, 160, "/io/codeforall/forsome/images/effects/cataclysm.png");

    public void createIncinerate() {
        incinerate.draw();
    }
    public void createCataclysm() {
        cataclysm.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(devilLord);

    }

    @Override
    public void die() {
        devilLordDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        devilLordDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        devilLord.delete();
    }

    //SPELLS
    public void incinerate(Hero hero) {
        textIncinerate.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textIncinerate.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createIncinerate();
        try {
            Thread.sleep(1000);
            incinerate.delete();
            hero.hit(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cataclysm(Hero hero) {
        //(AOE)
        textCataclysm.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textCataclysm.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createCataclysm();
        try {
            Thread.sleep(1000);
            cataclysm.delete();
            hero.hit(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
