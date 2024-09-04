package io.codeforall.forsome.heroes;

import io.codeforall.forsome.enemies.Enemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gunner extends Hero {

    //CONSTRUCTOR
    public Gunner() {
        this.setHp(175);
        this.setStr(5);
        this.setWis(10);
        this.setDex(20);
    }

    //CREATE TEXTBOX
    public Picture textBullseye = new Picture(50,160,"/io/codeforall/forsome/images/text_box/gunner_bullseye.png");
    public Picture textRicochet = new Picture(50,160,"/io/codeforall/forsome/images/text_box/gunner_ricochet.png");
    public Picture textRaiseFocus = new Picture(50,160,"/io/codeforall/forsome/images/text_box/gunner_raise_focus.png");
    public Picture textRapidFire = new Picture(50,160,"/io/codeforall/forsome/images/text_box/gunner_rapid_fire.png");
    public Picture textGunnerDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/gunner_death.png");


    //CREATE
    public static Picture gunner = new Picture(100,260, "/io/codeforall/forsome/images/heroes/gunner.png");
    public void createGunner() {
        gunner.draw();
    }

    //EFFECTS
    public Picture bullseye = new Picture(410,160,"/io/codeforall/forsome/images/effects/bullseye.png");
    public Picture ricochet = new Picture(410,160,"/io/codeforall/forsome/images/effects/ricochet.png");
    public Picture raiseFocus = new Picture(410,160,"/io/codeforall/forsome/images/effects/raisefocus.png");
    public Picture rapidFire = new Picture(410,160,"/io/codeforall/forsome/images/effects/rapidshot.png");

    public void createBullseye() {
        bullseye.draw();
    }
    public void createRicochet() {
        ricochet.draw();
    }
    public void createRaiseFocus() {
        raiseFocus.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(gunner);
    }

    @Override
    public void die() {
        textGunnerDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textGunnerDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gunner.delete();
    }

    //SPELLS
    public void bullseye(Enemy enemy) {
        textBullseye.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBullseye.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createBullseye();
        try {
            Thread.sleep(1000);
            bullseye.delete();
            enemy.hit(2 * getDex());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ricochet(Enemy enemy) {
        //Aoe
        textRicochet.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textRicochet.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createRicochet();
        try {
            Thread.sleep(1000);
            ricochet.delete();
            enemy.hit(getDex());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void raiseFocus() {
        textRaiseFocus.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textRaiseFocus.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createRaiseFocus();
        try {
            Thread.sleep(1000);
            raiseFocus.delete();
            this.buffDex(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void rapidFire(Enemy enemy) {
        textRapidFire.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textRapidFire.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rapidFire.draw();
        try {
            Thread.sleep(1000);
            rapidFire.delete();
            buffDex(3);
            enemy.hit(this.getDex());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
