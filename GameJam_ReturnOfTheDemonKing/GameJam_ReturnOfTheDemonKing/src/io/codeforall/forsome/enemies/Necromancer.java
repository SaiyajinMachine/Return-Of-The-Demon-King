package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Necromancer extends Enemy {

    //CONSTRUCTOR
    public Necromancer() {
        this.setHp(300);
        createNecromancer();
    }

    //CREATE TEXTBOX
    public Picture necromancerDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/necromancer_die.png");
    public Picture textShadowBolt = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/necromancer_shadow_bolt.png");

    //CREATE
    public static Picture necromancer = new Picture(600, 90, "/io/codeforall/forsome/images/enemies/necromancer.png");
    public void createNecromancer() {
        necromancer.draw();
    }

    //EFFECTS
    public Picture shadowBolt = new Picture(410, 160, "/io/codeforall/forsome/images/effects/shadowbolt.png");
    public void createShadowBolt() {
        shadowBolt.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(necromancer);
    }

    @Override
    public void die() {
        necromancerDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        necromancerDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        necromancer.delete();
    }

    //SPELLS
    public void shadowBolt(Hero hero) {
        textShadowBolt.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textShadowBolt.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createShadowBolt();
        try {
            Thread.sleep(1000);
            shadowBolt.delete();
            hero.hit(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
