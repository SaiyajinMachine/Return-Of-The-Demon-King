package io.codeforall.forsome.heroes;

import io.codeforall.forsome.enemies.Enemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mage extends Hero {

    //CONSTRUCTOR
    public Mage() {
        this.setHp(150);
        this.setStr(5);
        this.setWis(20);
        this.setDex(10);
    }

    //CREATE TEXTBOX
    public Picture textFireball = new Picture(50,160, "/io/codeforall/forsome/images/text_box/mage_fireball.png");
    public Picture textBlizzard = new Picture(50,160, "/io/codeforall/forsome/images/text_box/mage_blizzard.png");
    public Picture textMageArmor = new Picture(50,160, "/io/codeforall/forsome/images/text_box/mage_mage_armor.png");
    public Picture textPyroBlast = new Picture(50,160, "/io/codeforall/forsome/images/text_box/mage_pyro_blast.png");
    public Picture textMageDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/mage_death.png");

    //CREATE
    public static Picture mage = new Picture(300,280, "/io/codeforall/forsome/images/heroes/mage.png");
    public void createMage() {
        mage.draw();
    }

    //EFFECTS
    public Picture fireball = new Picture(410,160,"/io/codeforall/forsome/images/effects/fireball.png");
    public Picture blizzard = new Picture(410,160,"/io/codeforall/forsome/images/effects/blizzard.png");
    public Picture mageArmor = new Picture(410,160,"/io/codeforall/forsome/images/effects/magearmor.png");
    public Picture pyroBlast = new Picture(410,160,"/io/codeforall/forsome/images/effects/pyroblast.png");

    public void createFireball() {
        fireball.draw();
    }
    public void createBlizzard() {
        blizzard.draw();
    }
    public void createMageArmor() {
        mageArmor.draw();
    }
    public void createPyroBlast() {
        pyroBlast.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(mage);
    }

    @Override
    public void die() {
        textMageDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textMageDie.delete();super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mage.delete();
    }

    //SPELLS
    public void fireball(Enemy enemy) {
        textFireball.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textFireball.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createFireball();
        try {
            Thread.sleep(1000);
            fireball.delete();
            enemy.hit(2 * this.getWis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void blizzard(Enemy enemy) {
        //Aoe
        textBlizzard.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBlizzard.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createBlizzard();
        try {
            Thread.sleep(1000);
            blizzard.delete();
            enemy.hit(this.getWis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void mageArmor() {
        textMageArmor.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textMageArmor.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createMageArmor();
        try {
            Thread.sleep(1000);
            mageArmor.delete();
            this.buffHp(40);
            this.buffWis(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pyroBlast(Enemy enemy) {
        textPyroBlast.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textPyroBlast.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createPyroBlast();
        try {
            Thread.sleep(1000);
            pyroBlast.delete();
            enemy.hit(3*this.getWis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
