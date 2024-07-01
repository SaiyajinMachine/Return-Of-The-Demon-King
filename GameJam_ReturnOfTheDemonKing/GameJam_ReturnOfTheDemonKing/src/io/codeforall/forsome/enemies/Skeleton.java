package io.codeforall.forsome.enemies;

import io.codeforall.forsome.heroes.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Skeleton extends Enemy {

    //CONSTRUCTOR
    public Skeleton() {
        this.setHp(75);
        createSkeleton();
    }

    //CREATE TEXTBOX
    public Picture skeletonDie = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/skeleton_die.png");
    public Picture textSlash = new Picture(50, 160, "/io/codeforall/forsome/images/text_box/skeleton_slash.png");

    //CREATE
    public static Picture skeleton = new Picture(220, 120, "/io/codeforall/forsome/images/enemies/skeleton.png");
    public void createSkeleton() {
        skeleton.draw();
    }

    //EFFECTS
    public Picture slash = new Picture(410, 160, "/io/codeforall/forsome/images/effects/slash.png");
    public void createSlash() {
        slash.draw();
    }

    //METHODS
    @Override
    public void hit(int damage) {
        super.hit(damage);
        tremble(skeleton);
    }

    @Override
    public void die() {
        skeletonDie.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        skeletonDie.delete();
        super.die();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        skeleton.delete();
    }

    //SPELLS
    public void slash(Hero hero) {
        textSlash.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        textSlash.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        createSlash();
        try {
            Thread.sleep(1000);
            slash.delete();
            hero.hit(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
