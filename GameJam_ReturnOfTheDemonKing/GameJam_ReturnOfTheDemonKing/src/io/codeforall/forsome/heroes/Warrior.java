package io.codeforall.forsome.heroes;

import io.codeforall.forsome.enemies.Enemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Warrior extends Hero {

    //CONSTRUCTOR
    public Warrior() {
        this.setHp(200);
        this.setStr(20);
        this.setWis(5);
        this.setDex(10);
    }

    //CREATE TEXTBOX
    public Picture textMortalStrike = new Picture(50,160,"/io/codeforall/forsome/images/text_box/warrior_mortal_strike.png");
    public Picture textWhirlwind = new Picture(50,160,"/io/codeforall/forsome/images/text_box/warrior_whirlwind.png");
    public Picture textIgnorePain = new Picture(50,160,"/io/codeforall/forsome/images/text_box/warrior_ignore_pain.png");
    public Picture textBattleCry = new Picture(50,160,"/io/codeforall/forsome/images/text_box/warrior_battle_cry.png");
    public Picture textWarriorDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/warrior_death.png");

    //CREATE
    public static Picture warrior = new Picture(700,260, "/io/codeforall/forsome/images/heroes/warrior.png");
    public void createWarrior() {
        warrior.draw();
    }

    //EFFECTS
    public Picture mortalStrike = new Picture(410,160,"/io/codeforall/forsome/images/effects/mortalstrike.png");
    public Picture whirlwind = new Picture(410,160,"/io/codeforall/forsome/images/effects/whirlwind.png");
    public Picture ignorePain = new Picture(410,160,"/io/codeforall/forsome/images/effects/ignorepain.png");
    public Picture battleCry = new Picture(410,160,"/io/codeforall/forsome/images/effects/battlecry.png");

    public void createMortalStrike() {
        mortalStrike.draw();
    }
    public void createWhirlwind() {
        whirlwind.draw();
    }
    public void createIgnorePain() {
        ignorePain.draw();
    }
    public void createBattleCry() {
        battleCry.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(warrior);
    }

    @Override
    public void die() {
        textWarriorDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textWarriorDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        warrior.delete();
    }

    //SPELLS
    public void mortalStrike(Enemy enemy) {
        textMortalStrike.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textMortalStrike.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createMortalStrike();
        try {
            Thread.sleep(1000);
            mortalStrike.delete();
            enemy.hit(2* this.getStr());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void whirlwind(Enemy enemy) {
        //Aoe
        textWhirlwind.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textWhirlwind.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createWhirlwind();
        try {
            Thread.sleep(1000);
            whirlwind.delete();
            enemy.hit(this.getStr());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ignorePain() {
        textIgnorePain.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textIgnorePain.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createIgnorePain();
        try {
            Thread.sleep(1000);
            ignorePain.delete();
            this.buffHp(40);
            this.buffStr(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void battleCry(Hero hero) {
       //Aoe
        textBattleCry.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBattleCry.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createBattleCry();
        try {
            Thread.sleep(1000);
            battleCry.delete();
            hero.buffStr(10);
            hero.buffWis(10);
            hero.buffDex(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
