package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DemonKing extends Enemy {

    //CONSTRUCTOR
    public DemonKing () {
        this.setHp(700);
        createDemonKing();
    }

    //CREATE TEXTBOX
    public Picture demonKingDie = new Picture(50,160,"/io/codeforall/forsome/images/text_box/demon_king_die.png");
    public Picture textApocalypse = new Picture(50,160,"/io/codeforall/forsome/images/text_box/demon_king_apocalypse.png");
    public Picture textInfernalFlames = new Picture(50,160,"/io/codeforall/forsome/images/text_box/demon_king_infernal_flames.png");
    public Picture textFlameArmor = new Picture(50,160,"/io/codeforall/forsome/images/text_box/demon_king_flame_armor.png");
    public Picture textBlazingHell = new Picture(50,160,"/io/codeforall/forsome/images/text_box/demon_king_blazing_hell.png");

    //CREATE
    public static Picture demonKing = new Picture(280,10, "/io/codeforall/forsome/images/enemies/demonKing.png");
    public void createDemonKing() {
        demonKing.draw();
    }

    //EFFECTS
    public Picture apocalypse = new Picture(410,160,"/io/codeforall/forsome/images/effects/apocalypse.png");
    public Picture infernalFlames = new Picture(410,160,"/io/codeforall/forsome/images/effects/infernalflames.png");
    public Picture flameArmor = new Picture(410,160,"/io/codeforall/forsome/images/effects/flamearmor.png");
    public Picture blazingHell = new Picture(410,160,"/io/codeforall/forsome/images/effects/blazinghell.png");

    public void createApocalypse() {
        apocalypse.draw();
        apocalypse.grow(50,50);
    }
    public void createInfernalFlames() {
        infernalFlames.draw();
    }
    public void createflameArmor() {
        flameArmor.draw();
    }
    public void createBlazingHell() {
        blazingHell.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(demonKing);
    }

    @Override
    public void die() {
        demonKingDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        demonKingDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        demonKing.delete();
    }

    //SPELLS
    public void apocalypse(Hero[] heroes) {
        textApocalypse.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textApocalypse.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createApocalypse();
        try {
            Thread.sleep(1000);
            apocalypse.delete();
            for (int i = 0; i < heroes.length; i++) {
                if (!heroes[i].getDead()) {
                    heroes[i].die();
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void infernalFlames(Hero hero) {
        //(AOE)
        textInfernalFlames.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textInfernalFlames.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createInfernalFlames();
        try {
            Thread.sleep(2000);
            infernalFlames.delete();
            hero.hit(45);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void flameArmor() {
        textFlameArmor.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textFlameArmor.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createflameArmor();
        try {
            Thread.sleep(1000);
            flameArmor.delete();
            this.buffHp(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void blazingHell(Hero hero) {
        textBlazingHell.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textBlazingHell.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createBlazingHell();
        try {
            Thread.sleep(1000);
            blazingHell.delete();
            hero.hit(70);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
