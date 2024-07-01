package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Imp extends Enemy {

    //CONSTRUCTOR
    public Imp() {
        this.setHp(150);
        createImp();
    }

    //CREATE TEXTBOX
    public Picture impDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/imp_die.png");
    public Picture textFlameBall = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/imp_flame_ball.png");

    //CREATE
    public Picture imp = new Picture(900, 210, "/io/codeforall/forsome/images/enemies/imp.png");
    public void createImp() {
        imp.draw();
    }

    //EFFECTS
    public Picture flameBall = new Picture(410, 160, "/io/codeforall/forsome/images/effects/flameball.png");
    public void createFlameBall() {
        flameBall.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(imp);
    }

    @Override
    public void die() {
        impDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        impDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        imp.delete();
    }

    //SPELLS
    public void flameBall(Hero hero) {
        textFlameBall.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textFlameBall.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createFlameBall();
        try {
            Thread.sleep(1000);
            flameBall.delete();
            hero.hit(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
