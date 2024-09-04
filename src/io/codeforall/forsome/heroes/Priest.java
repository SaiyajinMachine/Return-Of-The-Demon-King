package io.codeforall.forsome.heroes;

import io.codeforall.forsome.enemies.Enemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Priest extends Hero {

    //CONSTRUCTOR
    public Priest() {
        this.setHp(150);
        this.setStr(15);
        this.setWis(15);
        this.setDex(15);
    }

    //CREATE TEXTBOX
    public Picture textSmite = new Picture(50,160,"/io/codeforall/forsome/images/text_box/priest_smite.png");
    public Picture textDivineStorm = new Picture(50,160,"/io/codeforall/forsome/images/text_box/priest_divine_storm.png");
    public Picture textFlagellation = new Picture(50,160,"/io/codeforall/forsome/images/text_box/priest_flagellation.png");
    public Picture textHolyNova = new Picture(50,160,"/io/codeforall/forsome/images/text_box/priest_holy_nova.png");
    public Picture textPriestDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/priest_death.png");
    //CREATE
    public static Picture priest = new Picture(500,300, "/io/codeforall/forsome/images/heroes/priest.png");
    public void createPriest() {
        priest.draw();
    }

    //EFFECTS
    public Picture smite = new Picture(410,160,"/io/codeforall/forsome/images/effects/smite.png");
    public Picture divineStorm = new Picture(410,160,"/io/codeforall/forsome/images/effects/divinestorm.png");
    public Picture flagellation = new Picture(410,160,"/io/codeforall/forsome/images/effects/flagellation.png");
    public Picture holyNova = new Picture(410,160,"/io/codeforall/forsome/images/effects/holynova.png");

    public void createSmite() {
        smite.draw();
    }
    public void createDivineStorm() {
        divineStorm.draw();
    }
    public void createFlagellation() {
        flagellation.draw();
    }
    public void createHolyNova() {
        holyNova.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(priest);
    }

    @Override
    public void die() {
        textPriestDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textPriestDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        priest.delete();
    }

    //SPELLS
    public void smite(Enemy enemy) {
        textSmite.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSmite.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createSmite();
        try {
            Thread.sleep(1000);
            smite.delete();
            enemy.hit(2 * this.getWis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void divineStorm(Enemy enemy) {
        //Aoe
        textDivineStorm.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textDivineStorm.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createDivineStorm();
        try {
            Thread.sleep(1000);
            divineStorm.delete();
            enemy.hit(this.getWis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void flagellation() {
        textFlagellation.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textFlagellation.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createFlagellation();
        try {
            Thread.sleep(1000);
            flagellation.delete();
            this.buffWis(5);
            this.hit(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void holyNova(Hero hero) {
        //Aoe
        textHolyNova.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textHolyNova.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createHolyNova();
        try {
            Thread.sleep(1000);
            holyNova.delete();
            hero.buffStr(5);
            hero.buffDex(5);
            hero.buffWis(5);
            hero.buffHp(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
