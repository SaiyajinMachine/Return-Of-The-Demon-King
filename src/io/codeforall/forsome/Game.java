package io.codeforall.forsome;

import io.codeforall.forsome.enemies.*;
import io.codeforall.forsome.heroes.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game implements KeyboardHandler {
    private int chance;
    private Keyboard keyboard;
    private int roundCounter = 0;
    private boolean isPriest = false;
    private boolean isGunner = false;
    private boolean isWarrior = false;
    private boolean isMage = false;
    private Hero[] heroWave1 = new Hero[1];
    private Hero[] heroWave2 = new Hero[2];
    private Hero[] heroWave3 = new Hero[3];
    private Hero[] fullSquad = new Hero[4];
    private Enemy[] enemyWave1;
    private Enemy[] enemyWave2;
    private Enemy[] enemyWave3;
    private Enemy[] enemyWave4;
    private Enemy[] bossFight;
    private boolean battle1 = false;
    private boolean battle2 = false;
    private boolean battle3 = false;
    private boolean battle4 = false;

    private boolean battle5 = false;
    private Hero warrior = new Warrior();
    private Hero mage = new Mage();
    private Hero gunner = new Gunner();
    private Hero priest = new Priest();
    private boolean pressedQ = true;
    private boolean pressedW = true;
    private boolean pressedE = true;
    private boolean pressedR = true;
    private boolean pressed1 = true;
    private boolean pressed2 = true;
    private boolean pressed3 = true;
    private boolean pressed4 = true;
    private boolean pressedA = true;
    private boolean pressedB = true;
    private boolean pressedC = true;
    private boolean pressedD = true;
    private boolean batAttacked = true;
    private boolean slimeAttacked = true;
    private boolean wolfAttacked = true;
    private boolean trollAttacked = true;
    private boolean necromancerAttacked = true;
    private boolean ghoulAttacked = true;
    private boolean witchAttacked = true;
    private boolean impAttacked = true;
    private boolean goblinAttacked = true;
    private boolean devilLordAttacked = true;
    private boolean demonKingAttacked = true;
    private boolean skeletonAttacked = true;
    private boolean warriorAttacked = true;
    private boolean mageAttacked = true;
    private boolean priestAttacked = true;
    private boolean gunnerAttacked = true;

    private int turn = 0;
    private boolean round1over = false;
    private boolean round2over = false;
    private boolean round3over = false;
    private boolean round4over = false;


    //GAME START
    public void start() {
        gameStart();
    }

    public void randomChance() {
        chance = (int) (Math.random() * 4) + 1;
    }


    public void checkIfWarriorDied(Hero[] heroes) {
        if (heroes[0].dead) {
            bgGameOver.draw();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
    }

    public void checkIfRound1Over() {
        if ((enemyWave1[0]).dead && (enemyWave1[1]).dead && (enemyWave1[2]).dead) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    round1over = true;
                    startRound2();
                }
            });
            thread.start();

        }
    }

    public void checkIfRound2Over() {
        if ((enemyWave2[0]).dead && (enemyWave2[1]).dead && (enemyWave2[2]).dead) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    round2over=true;
                    startRound3();

                }
            });
            thread.start();
        }
    }

    public void checkIfRound3Over() {
        if ((enemyWave3[0]).dead && (enemyWave3[1]).dead && (enemyWave3[2]).dead && (enemyWave3[3]).dead) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    round3over=true;
                    startRound4();
                }
            });
            thread.start();
        }
    }

    public void checkIfRound4Over() {
        if ((enemyWave4[0]).dead && (enemyWave4[1]).dead && (enemyWave4[2]).dead) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    round4over=true;
                    startBossRound();
                }
            });
            thread.start();
        }
    }

    public void startRound1Turns() {
        randomChance();
        checkIfRound1Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round1over) {
            return;
        }
        if((enemyWave1[0].dead)){
            slimeAttacked=false;
        }
        if((enemyWave1[1].dead)){
            wolfAttacked=false;
        }
        if (!batAttacked && !(enemyWave1[0]).dead) {
            if (chance > 2) {
                ((Bat) enemyWave1[0]).bite(heroWave1[0]);
            }
            if (chance <= 2) {
                ((Bat) enemyWave1[0]).screech(heroWave1[0]);
            }
            batAttacked = true;
            slimeAttacked = false;
            if ((enemyWave1[1]).dead) {
                wolfAttacked = false;
            }
        }
        checkIfRound1Over();
        checkIfWarriorDied(heroWave1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round1over) {
            return;
        }
        turn++;
        if (!slimeAttacked && !(enemyWave1[1]).dead) {
            if (chance <= 4) {
                ((Slime) enemyWave1[1]).splash();
            }
            slimeAttacked = true;
            wolfAttacked = false;
            if ((enemyWave1[2]).dead) {
                batAttacked = false;
            }
        }
        checkIfRound1Over();
        checkIfWarriorDied(heroWave1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round1over) {
            return;
        }
        turn++;
        if (!wolfAttacked && !(enemyWave1[2]).dead) {
            if (chance > 2) {
                ((Wolf) enemyWave1[2]).howl(heroWave1[0]);
            }
            if (chance <= 2) {
                ((Wolf) enemyWave1[2]).crunch(heroWave1[0]);
            }
            wolfAttacked = true;
            if ((enemyWave1[0]).dead) {
                slimeAttacked = false;
            }
        }
        checkIfRound1Over();
        checkIfWarriorDied(heroWave1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round1over) {
            return;
        }
        turn++;
        if (turn == 3) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (isWarrior) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warriorAttack.draw();
                    }
                    pressed1 = false;
                    pressed2 = false;
                    pressed3 = false;
                    pressed4 = false;
                    turn = 0;
                }
            });
            thread.start();

        }

    }

    public void startRound2Turns() {
        randomChance();

        checkIfRound2Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round2over) {
            return;
        }
        if((enemyWave2[0].dead)){
            goblinAttacked=false;
        }
        if((enemyWave2[1].dead)){
            wolfAttacked=false;
        }
        if((enemyWave2[2].dead)){
            heroWave2[1].attacked=false;
        }

        if (!trollAttacked && !(enemyWave2[0].dead)) {

            if (chance <= 2) {
                if (!heroWave2[0].dead && !heroWave2[1].dead) {
                    ((Troll) enemyWave2[0]).smash(heroWave2[(int) (Math.round(Math.random() * 1))]);
                }
                if (heroWave2[0].dead) {
                    ((Troll) enemyWave2[0]).smash(heroWave2[1]);
                }
                if (heroWave2[1].dead) {
                    ((Troll) enemyWave2[0]).smash(heroWave2[0]);
                }
            }
            if (chance == 3) {
                for (int i = 0; i < heroWave2.length; i++) {
                    if (!heroWave2[i].dead) {
                        ((Troll) enemyWave2[0]).swipe(heroWave2[i]);
                    }
                }
            }
            if (chance == 4) {
                ((Troll) enemyWave2[0]).regenerate();
            }
            trollAttacked = true;
            goblinAttacked = false;
            if ((enemyWave2[1]).dead) {
                wolfAttacked = false;
            }
        }
        checkIfWarriorDied(heroWave2);
        checkIfRound2Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round2over) {
            return;
        }
        turn++;
        if (!goblinAttacked && !(enemyWave2[1].dead)) {

            if (chance <= 4) {
                if (!heroWave2[0].dead && !heroWave2[1].dead) {
                    ((Goblin) enemyWave2[1]).stab(heroWave2[(int) (Math.round(Math.random() * 1))]);
                }
                if (heroWave2[0].dead) {
                    ((Goblin) enemyWave2[1]).stab(heroWave2[1]);
                }
                if (heroWave2[1].dead ) {
                    ((Goblin) enemyWave2[1]).stab(heroWave2[0]);
                }

            }
            goblinAttacked = true;
            wolfAttacked = false;
            if ((enemyWave2[2]).dead) {
                trollAttacked = false;
            }
        }
        checkIfWarriorDied(heroWave2);
        checkIfRound2Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round2over) {
            return;
        }
        turn++;
        if (!wolfAttacked && !(enemyWave2[2].dead)) {

            if (chance > 2) {
                if (!heroWave2[0].dead && !heroWave2[1].dead) {
                    ((Wolf) enemyWave2[2]).howl(heroWave2[(int) (Math.round(Math.random() * 1))]);
                }
                if (heroWave2[0].dead) {
                    ((Wolf) enemyWave2[2]).howl(heroWave2[1]);
                }

                if (heroWave2[1].dead ) {
                    ((Wolf) enemyWave2[2]).howl(heroWave2[0]);
                }
            }
            if (chance <= 2) {
                if (!heroWave2[0].dead && !heroWave2[1].dead) {
                    ((Wolf) enemyWave2[2]).crunch(heroWave2[(int) (Math.round(Math.random() * 1))]);
                }
                if (heroWave2[0].dead) {
                    ((Wolf) enemyWave2[2]).crunch(heroWave2[1]);
                }

                if (heroWave2[1].dead ) {
                    ((Wolf) enemyWave2[2]).crunch(heroWave2[0]);
                }
            }
            wolfAttacked = true;
            heroWave2[1].attacked = false;
            if ((heroWave2[1]).dead) {
                trollAttacked = false;
            }

        }
        checkIfWarriorDied(heroWave2);
        checkIfRound2Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round2over) {
            return;
        }
        turn++;
        if (!heroWave2[1].attacked && !heroWave2[1].dead) {
            if (chance == 1) {
                if (!enemyWave2[0].dead && !enemyWave2[1].dead) {
                    ((Priest) heroWave2[1]).smite(enemyWave2[(int) (Math.round(Math.random() * 1))]);
                }
                if (enemyWave2[0].dead) {
                    ((Priest) heroWave2[1]).smite(enemyWave2[1]);
                }
                if (enemyWave2[1].dead) {
                    ((Priest) heroWave2[1]).smite(enemyWave2[0]);
                }
            }

            if (chance == 2) {
                for (int i = 0; i < enemyWave2.length; i++) {
                    if (!enemyWave2[i].dead) {
                        ((Priest) heroWave2[1]).divineStorm(enemyWave2[i]);
                    }
                }

            }
            if (chance == 3) {
                ((Priest) heroWave2[1]).flagellation();
            }
            if (chance == 4) {
                for (int i = 0; i < heroWave2.length; i++) {
                    if (!heroWave2[i].dead) {
                        ((Priest) heroWave2[1]).holyNova(heroWave2[i]);
                    }
                }
            }
            heroWave2[1].attacked = true;
            trollAttacked = false;
            if ((enemyWave2[0]).dead) {
                goblinAttacked = false;
            }
        }
        checkIfRound2Over();
        checkIfWarriorDied(heroWave2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round2over) {
            return;
        }
        turn++;

        if (turn == 4) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (isWarrior) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warriorAttack.draw();
                    }
                    pressed1 = false;
                    pressed2 = false;
                    pressed3 = false;
                    pressed4 = false;
                    turn = 0;
                }
            });
            thread.start();

        }

    }

    public void startRound3Turns() {
        randomChance();

        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        if((enemyWave3[0].dead)){
            witchAttacked=false;
        }
        if((enemyWave3[1].dead)){
            skeletonAttacked=false;
        }
        if((enemyWave3[2].dead)){
            ghoulAttacked=false;
        }
        if((enemyWave3[3].dead)){
            heroWave3[1].attacked=false;
        }
        if((heroWave3[1].dead)){
            heroWave3[2].attacked=false;
        }

        if (!necromancerAttacked && !(enemyWave3[0].dead)) {

            if (chance <= 4) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Necromancer) enemyWave3[0]).shadowBolt(heroWave3[1]);
                    }

                }

            }
            necromancerAttacked = true;
            witchAttacked = false;
            if ((enemyWave3[1]).dead) {
                skeletonAttacked = false;
            }
        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;
        if (!witchAttacked && !(enemyWave3[1].dead)) {

            if (chance > 2) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Witch) enemyWave3[1]).pestilence(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Witch) enemyWave3[1]).pestilence(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Witch) enemyWave3[1]).pestilence(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Witch) enemyWave3[1]).pestilence(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).pestilence(heroWave3[1]);
                    }

                }

            }
            if (chance <= 2) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Witch) enemyWave3[1]).affliction(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Witch) enemyWave3[1]).affliction(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Witch) enemyWave3[1]).affliction(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Witch) enemyWave3[1]).affliction(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Witch) enemyWave3[1]).affliction(heroWave3[1]);
                    }

                }
            }
            witchAttacked = true;
            skeletonAttacked = false;
            if ((enemyWave3[2]).dead) {
                ghoulAttacked = false;
            }
        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;
        if (!skeletonAttacked && !(enemyWave3[2].dead)) {
            if (chance <= 4) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Skeleton) enemyWave3[2]).slash(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Skeleton) enemyWave3[2]).slash(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Skeleton) enemyWave3[2]).slash(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Skeleton) enemyWave3[2]).slash(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave3[2]).slash(heroWave3[1]);
                    }

                }
            }
            skeletonAttacked = true;
            ghoulAttacked = false;
            if ((enemyWave3[3]).dead) {
                necromancerAttacked = false;
            }

        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;
        if (!ghoulAttacked && !(enemyWave3[3].dead)) {

            if (chance > 2) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).cannibalize(heroWave3[1]);
                    }

                }
            }
            if (chance <= 2) {
                if (!heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Ghoul) enemyWave3[3]).vomit(heroWave3[(int) (Math.round(Math.random() * 2))]);
                }
                if (heroWave3[0].dead && heroWave3[1].dead && !heroWave3[2].dead) {
                    ((Ghoul) enemyWave3[3]).vomit(heroWave3[2]);

                }
                if (heroWave3[1].dead && heroWave3[2].dead && !heroWave3[0].dead) {
                    ((Ghoul) enemyWave3[3]).vomit(heroWave3[0]);

                }
                if (heroWave3[0].dead && heroWave3[2].dead && !heroWave3[1].dead) {
                    ((Ghoul) enemyWave3[3]).vomit(heroWave3[1]);

                }
                if (heroWave3[0].dead && !heroWave3[1].dead && !heroWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[1]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[2]);
                    }
                }
                if (heroWave3[1].dead && !heroWave3[2].dead && !heroWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[2]);
                    }

                }
                if (heroWave3[2].dead && !heroWave3[0].dead && !heroWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[0]);
                    }
                    if (chance > 2) {
                        ((Ghoul) enemyWave3[3]).vomit(heroWave3[1]);
                    }

                }
            }
            ghoulAttacked = true;
            heroWave3[1].attacked = false;
            if ((heroWave3[1]).dead) {
                heroWave3[2].attacked = false;
            }

        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;
        if (!heroWave3[1].attacked && !heroWave3[1].dead) {
            if (chance == 1) {
                if (!enemyWave3[0].dead && !enemyWave3[1].dead && !enemyWave3[2].dead) {
                    ((Priest) heroWave3[1]).smite(enemyWave3[(int) (Math.round(Math.random() * 3))]);
                }
                if (enemyWave3[0].dead && enemyWave3[1].dead && !enemyWave3[2].dead) {
                    ((Priest) heroWave3[1]).smite(enemyWave3[2]);

                }
                if (enemyWave3[1].dead && enemyWave3[2].dead && !enemyWave3[0].dead) {
                    ((Priest) heroWave3[1]).smite(enemyWave3[0]);

                }
                if (enemyWave3[0].dead && enemyWave3[2].dead && !enemyWave3[1].dead) {
                    ((Priest) heroWave3[1]).smite(enemyWave3[1]);

                }
                if (enemyWave3[0].dead && !enemyWave3[1].dead && !enemyWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[1]);
                    }
                    if (chance > 2) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[2]);
                    }
                }
                if (enemyWave3[1].dead && !enemyWave3[2].dead && !enemyWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[0]);
                    }
                    if (chance > 2) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[2]);
                    }

                }
                if (enemyWave3[2].dead && !enemyWave3[0].dead && !enemyWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[0]);
                    }
                    if (chance > 2) {
                        ((Priest) heroWave3[1]).smite(enemyWave3[1]);
                    }

                }
            }
            if (chance == 2) {
                for (int i = 0; i < enemyWave3.length; i++) {
                    if (!enemyWave3[i].dead) {
                        ((Priest) heroWave3[1]).divineStorm(enemyWave3[i]);
                    }
                }

            }
            if (chance == 3) {
                ((Priest) heroWave3[1]).flagellation();
            }
            if (chance == 4) {
                for (int i = 0; i < heroWave3.length; i++) {
                    if (!heroWave3[i].dead) {
                        ((Priest) heroWave3[1]).holyNova(heroWave3[i]);
                    }
                }
            }
            heroWave3[1].attacked = true;
            heroWave3[2].attacked = false;
            if ((heroWave3[2]).dead) {
                trollAttacked = false;
            }

        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;
        if (!heroWave3[2].attacked && !heroWave3[2].dead) {
            if (chance == 1) {
                if (!enemyWave3[0].dead && !enemyWave3[1].dead && !enemyWave3[2].dead) {
                    ((Gunner) heroWave3[2]).bullseye(enemyWave3[(int) (Math.round(Math.random() * 3))]);
                }
                if (enemyWave3[0].dead && enemyWave3[1].dead && !enemyWave3[2].dead) {
                    ((Gunner) heroWave3[2]).bullseye(enemyWave3[2]);

                }
                if (enemyWave3[1].dead && enemyWave3[2].dead && !enemyWave3[0].dead) {
                    ((Gunner) heroWave3[2]).bullseye(enemyWave3[0]);

                }
                if (enemyWave3[0].dead && enemyWave3[2].dead && !enemyWave3[1].dead) {
                    ((Gunner) heroWave3[2]).bullseye(enemyWave3[1]);

                }
                if (enemyWave3[0].dead && !enemyWave3[1].dead && !enemyWave3[2].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[1]);
                    }
                    if (chance > 2) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[2]);
                    }
                }
                if (enemyWave3[1].dead && !enemyWave3[2].dead && !enemyWave3[0].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[0]);
                    }
                    if (chance > 2) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[2]);
                    }

                }
                if (enemyWave3[2].dead && !enemyWave3[0].dead && !enemyWave3[1].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[0]);
                    }
                    if (chance > 2) {
                        ((Gunner) heroWave3[2]).bullseye(enemyWave3[1]);
                    }

                }
            }
            if (chance == 2) {
                for (int i = 0; i < enemyWave3.length; i++) {
                    if (!enemyWave3[i].dead) {
                        ((Gunner) heroWave3[2]).ricochet(enemyWave3[i]);
                    }
                }

            }
            if (chance == 3) {
                ((Gunner) heroWave3[2]).raiseFocus();
            }
            if (chance == 4) {
                for (int i = 0; i < enemyWave3.length; i++) {
                    if (!enemyWave3[i].dead) {
                        ((Gunner) heroWave3[2]).rapidFire(enemyWave3[i]);
                    }
                }
            }
            heroWave3[2].attacked = true;
            necromancerAttacked = false;
            if ((enemyWave3[0]).dead) {
                witchAttacked = false;
            }

        }
        checkIfWarriorDied(heroWave3);
        checkIfRound3Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round3over) {
            return;
        }
        turn++;

        if (turn == 6) {
            Thread thread = new Thread(new Runnable()  {
                @Override
                public void run() {
                    if (isWarrior) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warriorAttack.draw();
                    }
                    pressed1 = false;
                    pressed2 = false;
                    pressed3 = false;
                    pressed4 = false;
                    turn = 0;
                }
            });
            thread.start();

        }

    }

    public void startRound4Turns() {
        randomChance();


       checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        if((enemyWave4[0].dead)){
            impAttacked=false;
        }
        if((enemyWave4[1].dead)){
            skeletonAttacked=false;
        }
        if((enemyWave4[2].dead)){
            fullSquad[1].attacked=false;
        }
        if((fullSquad[1].dead)){
            fullSquad[2].attacked=false;
        }
        if((fullSquad[2].dead)){
            fullSquad[3].attacked=false;
        }

        if (!devilLordAttacked && !(enemyWave4[0].dead)) {

            if (chance <= 2) {
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((DevilLord) enemyWave4[0]).incinerate(fullSquad[(int) (Math.round(Math.random() * 3))]);
                }

                if (fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);

                }
                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);

                }


                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);
                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);
                    }

                }

                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);

                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((DevilLord) enemyWave4[0]).incinerate(fullSquad[0]);

                    }

                }



            }
            if (chance > 2) {
                for (int i = 0; i < fullSquad.length; i++) {
                    if (!fullSquad[i].dead) {
                        ((DevilLord) enemyWave4[0]).cataclysm(fullSquad[i]);
                    }
                }
            }
            devilLordAttacked = true;
            impAttacked = false;
            if ((enemyWave4[1]).dead) {
                skeletonAttacked = false;
            }
        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }

        turn++;
        if (!impAttacked && !(enemyWave4[1].dead)) {

            if (chance <= 4) {
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((Imp) enemyWave4[1]).flameBall(fullSquad[(int) (Math.round(Math.random() * 3))]);                }

                if (fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);

                }
                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);

                }


                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);
                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);
                    }

                }

                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);

                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((Imp) enemyWave4[1]).flameBall(fullSquad[0]);

                    }

                }


            }
            impAttacked = true;
            skeletonAttacked = false;
            if ((enemyWave4[2]).dead) {
                devilLordAttacked = false;
            }
        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        turn++;
        if (!skeletonAttacked && !(enemyWave4[2].dead)) {
            if (chance <= 4) {
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((Skeleton) enemyWave4[2]).slash(fullSquad[(int) (Math.round(Math.random() * 3))]);
                }

                if (fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);

                }
                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);

                }


                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);
                    }

                }
                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);
                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);
                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);
                    }

                }

                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);

                    }

                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }

                    if (chance == 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[3]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);

                    }

                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance < 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[2]);
                    }
                    if (chance > 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[1]);
                    }

                    if (chance == 2) {
                        ((Skeleton) enemyWave4[2]).slash(fullSquad[0]);

                    }

                }
            }

            skeletonAttacked = true;
            fullSquad[1].attacked = false;
            if ((fullSquad[1]).dead) {
                fullSquad[2].attacked = false;
            }
        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        turn++;
        if (!fullSquad[1].attacked && !fullSquad[1].dead) {
            if (chance == 1) {
                if (!enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Priest) fullSquad[1]).smite(enemyWave4[(int) (Math.round(Math.random() * 2))]);
                }
                if (enemyWave4[0].dead && enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Priest) fullSquad[1]).smite(enemyWave4[2]);

                }
                if (enemyWave4[1].dead && enemyWave4[2].dead && !enemyWave4[0].dead) {
                    ((Priest) fullSquad[1]).smite(enemyWave4[0]);

                }
                if (enemyWave4[0].dead && enemyWave4[2].dead && !enemyWave4[1].dead) {
                    ((Priest) fullSquad[1]).smite(enemyWave4[1]);

                }
                if (enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    if (chance <= 2 ) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[1]);
                    }
                    if (chance > 2) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[2]);
                    }
                }
                if (enemyWave4[1].dead && !enemyWave4[2].dead && !enemyWave4[0].dead) {
                    if (chance <= 2 ) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[2]);
                    }

                }
                if (enemyWave4[2].dead && !enemyWave4[0].dead && !enemyWave4[1].dead) {
                    if (chance <= 2 ) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Priest) fullSquad[1]).smite(enemyWave4[1]);
                    }

                }
            }
            if (chance == 2) {
                for (int i = 0; i < enemyWave4.length; i++) {
                    if (!enemyWave4[i].dead) {
                        ((Priest) fullSquad[1]).divineStorm(enemyWave4[i]);
                    }
                }

            }
            if (chance == 3) {
                ((Priest) fullSquad[1]).flagellation();
            }
            if (chance == 4) {
                for (int i = 0; i < fullSquad.length; i++) {
                    if (!fullSquad[i].dead) {
                        ((Priest) fullSquad[1]).holyNova(fullSquad[i]);
                    }
                }
            }
            fullSquad[1].attacked = true;
            fullSquad[2].attacked = false;
            if ((fullSquad[2]).dead) {
                fullSquad[3].attacked = false;
            }

        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        turn++;
        if (!fullSquad[2].attacked && !fullSquad[2].dead) {
            if (chance == 1) {
                if (!enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Gunner) fullSquad[2]).bullseye(enemyWave4[(int) (Math.round(Math.random() * 2))]);
                }
                if (enemyWave4[0].dead && enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Gunner) fullSquad[2]).bullseye(enemyWave4[2]);

                }
                if (enemyWave4[1].dead && enemyWave4[2].dead && !enemyWave4[0].dead) {
                    ((Gunner) fullSquad[2]).bullseye(enemyWave4[0]);

                }
                if (enemyWave4[0].dead && enemyWave4[2].dead && !enemyWave4[1].dead) {
                    ((Gunner) fullSquad[2]).bullseye(enemyWave4[1]);

                }
                if (enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[1]);
                    }
                    if (chance > 2) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[2]);
                    }
                }
                if (enemyWave4[1].dead && !enemyWave4[2].dead && !enemyWave4[0].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[2]);
                    }

                }
                if (enemyWave4[2].dead && !enemyWave4[0].dead && !enemyWave4[1].dead) {
                    if (chance <= 2 ) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Gunner) fullSquad[2]).bullseye(enemyWave4[1]);
                    }

                }
            }
            if (chance == 2) {
                for (int i = 0; i < enemyWave4.length; i++) {
                    if (!enemyWave4[i].dead) {
                        ((Gunner) fullSquad[2]).ricochet(enemyWave4[i]);
                    }
                }

            }
            if (chance == 3) {
                ((Gunner) fullSquad[2]).raiseFocus();
            }
            if (chance == 4) {
                for (int i = 0; i < enemyWave4.length; i++) {
                    if (!enemyWave4[i].dead) {
                        ((Gunner) fullSquad[2]).rapidFire(enemyWave4[i]);
                    }
                }
            }
            fullSquad[2].attacked = true;
            fullSquad[3].attacked = false;
            if ((fullSquad[3]).dead) {
                devilLordAttacked = false;
            }

        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        turn++;
        if (!fullSquad[3].attacked && !fullSquad[3].dead) {
            if (chance == 1) {
                if (!enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Mage) fullSquad[3]).fireball(enemyWave4[(int) (Math.round(Math.random() * 2))]);
                }
                if (enemyWave4[0].dead && enemyWave4[1].dead && !enemyWave4[2].dead) {
                    ((Mage) fullSquad[3]).fireball(enemyWave4[2]);

                }
                if (enemyWave4[1].dead && enemyWave4[2].dead && !enemyWave4[0].dead) {
                    ((Mage) fullSquad[3]).fireball(enemyWave4[0]);

                }
                if (enemyWave4[0].dead && enemyWave4[2].dead && !enemyWave4[1].dead) {
                    ((Mage) fullSquad[3]).fireball(enemyWave4[1]);

                }
                if (enemyWave4[0].dead && !enemyWave4[1].dead && !enemyWave4[2].dead) {
                    if (chance <= 2 ) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[1]);
                    }
                    if (chance > 2) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[2]);
                    }
                }
                if (enemyWave4[1].dead && !enemyWave4[2].dead && !enemyWave4[0].dead) {
                    if (chance <= 2 ) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[2]);
                    }

                }
                if (enemyWave4[2].dead && !enemyWave4[0].dead && !enemyWave4[1].dead) {
                    if (chance <= 2 ) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[0]);
                    }
                    if (chance > 2) {
                        ((Mage) fullSquad[3]).fireball(enemyWave4[1]);
                    }

                }
            }
            if (chance == 2) {
                for (int i = 0; i < enemyWave4.length; i++) {
                    if (!enemyWave4[i].dead) {
                        ((Mage) fullSquad[3]).blizzard(enemyWave4[i]);

                    }
                }

            }
            if (chance == 3) {
                ((Mage) fullSquad[3]).mageArmor();
            }
            if (chance == 4) {
                for (int i = 0; i < enemyWave4.length; i++) {
                    if (!enemyWave4[i].dead) {
                        ((Mage) fullSquad[3]).pyroBlast(enemyWave4[i]);
                    }
                }
            }
            fullSquad[3].attacked = true;
            if ((!enemyWave4[0].dead)) {
                impAttacked = false;
            }

        }
        checkIfWarriorDied(fullSquad);
        checkIfRound4Over();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(round4over) {
            return;
        }
        turn++;



        if (turn == 6) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (isWarrior) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warriorAttack.draw();
                    }
                    pressed1 = false;
                    pressed2 = false;
                    pressed3 = false;
                    pressed4 = false;
                    turn = 0;
                }
            });
            thread.start();

        }

    }

    public void startBossFightTurns() {
        fullSquad[1].attacked = true;
        fullSquad[2].attacked = true;
        fullSquad[3].attacked = true;
        demonKingAttacked = false;
        randomChance();
        roundPlayed();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (fullSquad[1].dead) {
            fullSquad[2].attacked = false;
        }
        if (fullSquad[2].dead) {
            fullSquad[3].attacked = false;
        }
        if (fullSquad[3].dead) {
            demonKingAttacked = false;
        }

        if (bossFight[0].dead) {
            new Thread(() -> startWinStage()).start();
            return;
        }

        if (roundCounter == 7) {
            ((DemonKing) bossFight[0]).apocalypse(fullSquad);
            demonKingAttacked = true;
            bgGameOver.draw();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
            return;
        }

        if (!demonKingAttacked) {
            if (chance <= 2) {
                randomChance();
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((DemonKing) bossFight[0]).blazingHell(fullSquad[(int) (Math.round(Math.random() * 3))]);
                }
                if (fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                }
                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                }
                if (fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    }
                }
                if (fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    }
                }
                if (!fullSquad[0].dead && fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    }
                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance <= 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
                if (fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else if (chance > 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    }
                }
                if (!fullSquad[0].dead && fullSquad[1].dead && !fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else if (chance > 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && fullSquad[2].dead && !fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[3]);
                    } else if (chance > 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
                if (!fullSquad[0].dead && !fullSquad[1].dead && !fullSquad[2].dead && fullSquad[3].dead) {
                    if (chance < 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[2]);
                    } else if (chance > 2) {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[1]);
                    } else {
                        ((DemonKing) bossFight[0]).blazingHell(fullSquad[0]);
                    }
                }
            } else if (chance == 3) {
                for (int i = 0; i < fullSquad.length; i++) {
                    if (!fullSquad[i].dead) {
                        ((DemonKing) bossFight[0]).infernalFlames(fullSquad[i]);
                    }
                }
            } else if (chance == 4) {
                ((DemonKing) bossFight[0]).flameArmor();
            }
            demonKingAttacked = true;
            fullSquad[1].attacked = false;
        }

        turn++;
        checkIfWarriorDied(fullSquad);

        if (!fullSquad[1].attacked && !fullSquad[1].dead) {
            switch (chance) {
                case 1:
                    ((Priest) fullSquad[1]).smite(bossFight[0]);
                    break;
                case 2:
                    ((Priest) fullSquad[1]).divineStorm(bossFight[0]);
                    break;
                case 3:
                    ((Priest) fullSquad[1]).flagellation();
                    break;
                case 4:
                    for (int i = 0; i < fullSquad.length; i++) {
                        if (!fullSquad[i].dead) {
                            ((Priest) fullSquad[1]).holyNova(fullSquad[i]);
                        }
                    }
                    break;
            }
            fullSquad[1].attacked = true;
            fullSquad[2].attacked = false;
        }

        turn++;
        checkIfWarriorDied(fullSquad);

        if (!fullSquad[2].attacked && !fullSquad[2].dead) {
            switch (chance) {
                case 1:
                    ((Gunner) fullSquad[2]).bullseye(bossFight[0]);
                    break;
                case 2:
                    ((Gunner) fullSquad[2]).ricochet(bossFight[0]);
                    break;
                case 3:
                    ((Gunner) fullSquad[2]).raiseFocus();
                    break;
                case 4:
                    ((Gunner) fullSquad[2]).rapidFire(bossFight[0]);
                    break;
            }
            fullSquad[2].attacked = true;
            fullSquad[3].attacked = false;
        }

        turn++;
        checkIfWarriorDied(fullSquad);

        if (!fullSquad[3].attacked && !fullSquad[3].dead) {
            switch (chance) {
                case 1:
                    ((Mage) fullSquad[3]).fireball(bossFight[0]);
                    break;
                case 2:
                    ((Mage) fullSquad[3]).blizzard(bossFight[0]);
                    break;
                case 3:
                    ((Mage) fullSquad[3]).mageArmor();
                    break;
                case 4:
                    ((Mage) fullSquad[3]).pyroBlast(bossFight[0]);
                    break;
            }
            fullSquad[3].attacked = true;
            demonKingAttacked = false;
        }

        turn++;
        checkIfWarriorDied(fullSquad);

        if (turn == 4) {
            new Thread(() -> {
                if (isWarrior) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    warriorAttack.draw();
                }
                pressed1 = false;
                pressed2 = false;
                pressed3 = false;
                pressed4 = false;
                turn = 0;
            }).start();
        }
    }


    private boolean skip = false;

    public Game() {
        this.keyboard = new Keyboard(this);
        addKeyboard();
    }

    public void isBattle1() {
        battle1 = true;
    }

    public void isBattle2() {
        battle2 = true;
    }

    public void isBattle3() {
        battle3 = true;
    }

    public void isBattle4() {
        battle4 = true;
    }

    public void isBattle5() {
        battle5 = true;
    }


    //CREATE TEXTS
    public Picture gameName = new Picture(70, 50, "/io/codeforall/forsome/images/gamename.png");
    public Picture start = new Picture(20, 350, "/io/codeforall/forsome/images/start.png");
    public Picture heroSelection = new Picture(60, 50, "/io/codeforall/forsome/images/text_box/hero_selection.png");
    public Picture priestSelect = new Picture(60, 315, "/io/codeforall/forsome/images/text_box/priest_select.png");
    public Picture warriorSelect = new Picture(60, 315, "/io/codeforall/forsome/images/text_box/warrior_select.png");
    public Picture mageSelect = new Picture(60, 315, "/io/codeforall/forsome/images/text_box/mage_select.png");
    public Picture gunnerSelect = new Picture(60, 315, "/io/codeforall/forsome/images/text_box/gunner_select.png");
    public Picture gunnerAttack = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/gunner_attack.png");
    public Picture priestAttack = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/priest_attack.png");
    public Picture mageAttack = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/mage_attack.png");
    public Picture warriorAttack = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/warrior_attack.png");
    public Picture targetLevel1 = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/target_level1.png");
    public Picture targetLevel2 = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/target_level2.png");
    public Picture targetLevel3 = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/target_level3.png");
    public Picture busty = new Picture(60, 160, "/io/codeforall/forsome/images/heroes/busty.png");
    public Picture targetLevel4 = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/target_level4.png");
    public Picture priestJoin = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/priest_join.png");
    public Picture gunnerJoin = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/gunner_join.png");
    public Picture mageJoin = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/mage_join.png");
    public Picture warriorJoin = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/warrior_join.png");
    public Picture targetDead = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/target_dead.png");
    public Picture credits = new Picture(60, 160, "/io/codeforall/forsome/images/text_box/credits.png");




    //BACKGROUNDS IMAGES
    public Picture bg1 = new Picture(10, 10, "/io/codeforall/forsome/images/bg/battle01-Woods.jpg");
    public Picture bg2 = new Picture(10, 10, "/io/codeforall/forsome/images/bg/battle02-Forest.jpg");
    public Picture bg3 = new Picture(10, 10, "/io/codeforall/forsome/images/bg/battle03-EvilCastle.jpg");
    public Picture bg4 = new Picture(10, 10, "/io/codeforall/forsome/images/bg/battle04-EvilCastle.jpg");
    public Picture bg5 = new Picture(10, 10, "/io/codeforall/forsome/images/bg/boss-Cave.jpg");
    public Picture bgStart = new Picture(10, 10, "/io/codeforall/forsome/images/bg/beginning.jpg");
    public Picture bgEnd = new Picture(10, 10, "/io/codeforall/forsome/images/bg/ending.jpg");
    public Picture bgGameOver = new Picture(10, 10, "/io/codeforall/forsome/images/bg/gameover.png");
    public Picture loading = new Picture(10, 10, "/io/codeforall/forsome/images/bg/loading.png");
    public Picture title = new Picture(10, 10, "/io/codeforall/forsome/images/bg/title.png");


    //CREATE BACKGROUNDS
    public void createBg1() {
        bg1.draw();
    }

    public void createBg2() {
        bg2.draw();
    }

    public void createBg3() {
        bg3.draw();
    }

    public void createBg4() {
        bg4.draw();
    }

    public void createBg5() {
        bg5.draw();
    }

    public void createBgStart() {
        bgStart.draw();
    }

    public void createBgEnd() {
        bgEnd.draw();
    }

    public void createBgGameOver() {
        bgGameOver.draw();
    }

    public void createLoading() {
        loading.draw();
    }

    public void createTitle() {
        title.draw();
    }

    public void addKeyboard() {
        KeyboardEvent pressQ = new KeyboardEvent();
        pressQ.setKey(KeyboardEvent.KEY_Q);
        pressQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressQ);

        KeyboardEvent pressW = new KeyboardEvent();
        pressW.setKey(KeyboardEvent.KEY_W);
        pressW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressW);

        KeyboardEvent pressE = new KeyboardEvent();
        pressE.setKey(KeyboardEvent.KEY_E);
        pressE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressE);

        KeyboardEvent pressR = new KeyboardEvent();
        pressR.setKey(KeyboardEvent.KEY_R);
        pressR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressR);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressSpace);

        KeyboardEvent press1 = new KeyboardEvent();
        press1.setKey(KeyboardEvent.KEY_1);
        press1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(press1);

        KeyboardEvent press2 = new KeyboardEvent();
        press2.setKey(KeyboardEvent.KEY_2);
        press2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(press2);

        KeyboardEvent press3 = new KeyboardEvent();
        press3.setKey(KeyboardEvent.KEY_3);
        press3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(press3);

        KeyboardEvent press4 = new KeyboardEvent();
        press4.setKey(KeyboardEvent.KEY_4);
        press4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(press4);

        KeyboardEvent pressA = new KeyboardEvent();
        pressA.setKey(KeyboardEvent.KEY_A);
        pressA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressA);

        KeyboardEvent pressB = new KeyboardEvent();
        pressB.setKey(KeyboardEvent.KEY_B);
        pressB.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressB);

        KeyboardEvent pressC = new KeyboardEvent();
        pressC.setKey(KeyboardEvent.KEY_C);
        pressC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressC);

        KeyboardEvent pressD = new KeyboardEvent();
        pressD.setKey(KeyboardEvent.KEY_D);
        pressD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressD);
    }

    //CHOOSE HERO
    public void choosePriest() {
        Warrior.warrior.delete();
        Mage.mage.delete();
        Gunner.gunner.delete();
        isPriest = true;
        Priest.priest.translate(-70, -170);
        priestSelect.draw();
        priestSelect.grow(-20, -20);
        heroWave1[0] = priest;
    }

    public void chooseMage() {
        Warrior.warrior.delete();
        Priest.priest.delete();
        Gunner.gunner.delete();
        isMage = true;
        Mage.mage.translate(110, -150);
        mageSelect.draw();
        mageSelect.grow(-20, -20);
        heroWave1[0] = mage;
    }

    public void chooseGunner() {
        Warrior.warrior.delete();
        Priest.priest.delete();
        Mage.mage.delete();
        isGunner = true;
        Gunner.gunner.translate(310, -170);
        gunnerSelect.draw();
        gunnerSelect.grow(-20, -20);
        heroWave1[0] = gunner;
    }

    public void chooseWarrior() {
        Priest.priest.delete();
        Mage.mage.delete();
        Gunner.gunner.delete();
        isWarrior = true;
        Warrior.warrior.translate(-290, -160);

        heroWave1[0] = warrior;
    }


    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        if (keyPressed == KeyboardEvent.KEY_Q) {
            if (pressedQ == false) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        priestSelect.draw();
                        priestSelect.grow(-20,-20);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        priestSelect.delete();
                    }
                });
                thread.start();
                chooseWarrior();
                pressedQ = true;
                pressedW = true;
                pressedE = true;
                pressedR = true;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_W) {
            if (pressedW == false) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mageSelect.draw();
                        mageSelect.grow(-20,-20);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        mageSelect.delete();
                    }
                });
                thread.start();
                chooseWarrior();
                pressedQ = true;
                pressedW = true;
                pressedE = true;
                pressedR = true;
            }

        }
        if (keyPressed == KeyboardEvent.KEY_E) {
            if (pressedE == false) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        gunnerSelect.draw();
                        gunnerSelect.grow(-20,-20);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        gunnerSelect.delete();
                    }
                });
                thread.start();

                chooseWarrior();
                pressedQ = true;
                pressedW = true;
                pressedE = true;
                pressedR = true;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_R) {
            if (pressedR == false) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        warriorSelect.draw();
                        warriorSelect.grow(-20, -20);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warriorSelect.delete();
                    }
                });
                thread.start();

                chooseWarrior();
                pressedQ = true;
                pressedW = true;
                pressedE = true;
                pressedR = true;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_SPACE) {
            skip();
        }
        if (keyPressed == KeyboardEvent.KEY_1) {

            if (pressed1 == false) {

                pressed1 = true;
                pressed2 = true;
                pressed3 = true;
                pressed4 = true;

                if (isWarrior) {
                    if (battle1) {
                        warriorAttack.delete();
                        targetLevel1.draw();
                    }
                    if (battle2) {
                        warriorAttack.delete();
                        targetLevel2.draw();
                    }
                    if (battle3) {
                        warriorAttack.delete();
                        targetLevel3.draw();
                    }
                    if (battle4) {
                        warriorAttack.delete();
                        targetLevel4.draw();
                    }
                    if (battle5){
                        warriorAttack.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(bossFight[0]);

                                try {
                                    demonKingAttacked = false;
                                    Thread.sleep(1000);

                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startBossFightTurns();

                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {

                    if (battle1) {
                        mageAttack.delete();
                        targetLevel1.draw();
                    }
                    if (battle2) {
                        mageAttack.delete();
                        targetLevel2.draw();
                    }
                    if (battle3) {
                        mageAttack.delete();
                        targetLevel3.draw();
                    }
                    if (battle4) {
                        mageAttack.delete();
                        targetLevel4.draw();
                    }
                }
                if (isPriest) {
                    if (battle1) {
                        priestAttack.delete();
                        targetLevel1.draw();
                    }
                    if (battle2) {
                        priestAttack.delete();
                        targetLevel2.draw();
                    }
                    if (battle3) {
                        priestAttack.delete();
                        targetLevel3.draw();
                    }
                    if (battle4) {
                        priestAttack.delete();
                        targetLevel4.draw();
                    }
                }
                if (isGunner) {
                    if (battle1) {
                        gunnerAttack.delete();
                        targetLevel1.draw();
                    }
                    if (battle2) {
                        gunnerAttack.delete();
                        targetLevel2.draw();
                    }
                    if (battle3) {
                        gunnerAttack.delete();
                        targetLevel3.draw();
                    }
                    if (battle4) {
                        gunnerAttack.delete();
                        targetLevel4.draw();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                pressedA = false;
                pressedB = false;
                pressedC = false;
                pressedD = false;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_2) {

            if (pressed2 == false) {

                pressed1 = true;
                pressed2 = true;
                pressed3 = true;
                pressed4 = true;

                if (isWarrior) {
                    warriorAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    if (!enemyWave1[i].dead) {
                                        ((Warrior) warrior).whirlwind(enemyWave1[i]);
                                        batAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound1Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    if (!enemyWave2[i].dead) {
                                        ((Warrior) warrior).whirlwind(enemyWave2[i]);
                                        trollAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound2Turns();
                            }
                        });
                        thread.start();

                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    if (!enemyWave3[i].dead) {
                                        ((Warrior) warrior).whirlwind(enemyWave3[i]);
                                        necromancerAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    if (!enemyWave4[i].dead) {
                                        ((Warrior) warrior).whirlwind(enemyWave4[i]);
                                        devilLordAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound4Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle5) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < bossFight.length; i++) {
                                    if (!bossFight[i].dead) {
                                        ((Warrior) warrior).whirlwind(bossFight[i]);

                                    }
                                }
                                try {
                                    demonKingAttacked = false;
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startBossFightTurns();
                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {
                    mageAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    ((Mage) mage).blizzard(enemyWave1[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    ((Mage) mage).blizzard(enemyWave2[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    ((Mage) mage).blizzard(enemyWave3[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    ((Mage) mage).blizzard(enemyWave4[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    priestAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    ((Priest) priest).divineStorm(enemyWave1[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    ((Priest) priest).divineStorm(enemyWave2[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    ((Priest) priest).divineStorm(enemyWave3[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    ((Priest) priest).divineStorm(enemyWave4[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    gunnerAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    ((Gunner) gunner).ricochet(enemyWave1[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    ((Gunner) gunner).ricochet(enemyWave2[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    ((Gunner) gunner).ricochet(enemyWave3[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    ((Gunner) gunner).ricochet(enemyWave4[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                }
            }

        }

        if (keyPressed == KeyboardEvent.KEY_3) {

            if (pressed3 == false) {

                pressed1 = true;
                pressed2 = true;
                pressed3 = true;
                pressed4 = true;

                if (isWarrior) {
                    warriorAttack.delete();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ((Warrior) warrior).ignorePain();
                            batAttacked = false;
                            trollAttacked = false;
                            necromancerAttacked = false;
                            devilLordAttacked = false;
                            demonKingAttacked = false;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if(battle1) {
                                startRound1Turns();
                            }
                            if(battle2) {
                                startRound2Turns();
                            }
                            if(battle3) {
                                startRound3Turns();
                            }
                            if(battle4) {
                                startRound4Turns();
                            }
                            if(battle5) {
                                startBossFightTurns();
                            }
                        }
                    });
                    thread.start();
                }
                if (isMage) {
                    mageAttack.delete();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ((Mage) mage).mageArmor();
                        }
                    });
                    thread.start();
                }
                if (isPriest) {
                    priestAttack.delete();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ((Priest) priest).flagellation();
                        }
                    });
                    thread.start();
                }
                if (isGunner) {
                    gunnerAttack.delete();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ((Gunner) gunner).raiseFocus();
                        }
                    });
                    thread.start();
                }
            }
        }
        if (keyPressed == KeyboardEvent.KEY_4) {

            if (pressed4 == false) {

                pressed1 = true;
                pressed2 = true;
                pressed3 = true;
                pressed4 = true;

                if (isWarrior) {
                    warriorAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < heroWave1.length; i++) {
                                    if (!heroWave1[i].dead) {
                                        ((Warrior) warrior).battleCry(heroWave1[i]);
                                        batAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound1Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < heroWave2.length; i++) {
                                    if (!heroWave2[i].dead) {
                                        ((Warrior) warrior).battleCry(heroWave2[i]);
                                        trollAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound2Turns();
                            }
                        });
                        thread.start();

                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < heroWave3.length; i++) {
                                    if (!heroWave3[i].dead) {
                                        ((Warrior) warrior).battleCry(heroWave3[i]);
                                        necromancerAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < fullSquad.length; i++) {
                                    if (!fullSquad[i].dead) {
                                        ((Warrior) warrior).battleCry(fullSquad[i]);
                                        devilLordAttacked = false;
                                    }
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound4Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle5) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < fullSquad.length; i++) {
                                    if (!fullSquad[i].dead) {
                                        ((Warrior) warrior).battleCry(fullSquad[i]);

                                    }
                                }
                                try {
                                    demonKingAttacked = false;
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startBossFightTurns();
                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {
                    mageAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    ((Mage) mage).pyroBlast(enemyWave1[i]);
                                }
                            }
                        });
                        thread.start();
                    }

                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    ((Mage) mage).pyroBlast(enemyWave2[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    ((Mage) mage).pyroBlast(enemyWave3[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    ((Mage) mage).pyroBlast(enemyWave4[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    priestAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).holyNova(priest);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).holyNova(priest);
                                ((Priest) priest).holyNova(gunner);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).holyNova(priest);
                                ((Priest) priest).holyNova(gunner);
                                ((Priest) priest).holyNova(mage);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).holyNova(priest);
                                ((Priest) priest).holyNova(gunner);
                                ((Priest) priest).holyNova(mage);
                                ((Priest) priest).holyNova(warrior);

                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    gunnerAttack.delete();
                    if (battle1) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave1.length; i++) {
                                    ((Gunner) gunner).rapidFire(enemyWave1[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave2.length; i++) {
                                    ((Gunner) gunner).rapidFire(enemyWave2[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave3.length; i++) {
                                    ((Gunner) gunner).rapidFire(enemyWave3[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < enemyWave4.length; i++) {
                                    ((Gunner) gunner).rapidFire(enemyWave4[i]);
                                }
                            }
                        });
                        thread.start();
                    }
                }

            }
        }


        if (keyPressed == KeyboardEvent.KEY_A) {

            if (pressedA == false) {

                if (isWarrior) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel1.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave1[0].dead) {
                            thread1.start();
                            return;
                        }

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave1[0]);
                                batAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound1Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel2.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave2[0].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave2[0]);
                                trollAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound2Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel3.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave3[0].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave3[0]);
                                necromancerAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel4.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave4[0].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave4[0]);
                                devilLordAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound4Turns();
                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave1[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave2[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave3[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave4[0]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave1[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave2[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave3[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave4[0]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave1[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave2[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave3[0]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave4[0]);
                            }
                        });
                        thread.start();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                pressedA = true;
                pressedB = true;
                pressedC = true;
                pressedD = true;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_B) {

            if (pressedB == false) {

                if (isWarrior) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel1.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave1[1].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave1[1]);
                                batAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound1Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel2.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave2[1].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave2[1]);
                                trollAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound2Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel3.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave3[1].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave3[1]);
                                necromancerAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel4.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave4[1].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave4[1]);
                                devilLordAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound4Turns();
                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave1[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave2[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave3[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave4[1]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave1[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave2[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave3[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave4[1]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave1[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave2[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave3[1]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave4[1]);
                            }
                        });
                        thread.start();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                pressedA = true;
                pressedB = true;
                pressedC = true;
                pressedD = true;
            }
        }
        if (keyPressed == KeyboardEvent.KEY_C) {
            if (pressedC == false) {
                if (isWarrior) {
                    if (battle1){
                        targetLevel1.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel1.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave1[2].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave1[2]);
                                batAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound1Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel2.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave2[2].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave2[2]);
                                trollAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound2Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel3.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave3[2].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave3[2]);
                                necromancerAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                targetDead.delete();
                                targetLevel4.draw();

                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;

                                pressed1 = false;


                            }
                        });
                        if (enemyWave4[2].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave4[2]);
                                devilLordAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound4Turns();
                            }
                        });
                        thread.start();
                    }
                }
                if (isMage) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave1[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave2[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave3[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave4[2]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave1[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave2[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave3[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave4[2]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    if (battle1) {
                        targetLevel1.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave1[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle2) {
                        targetLevel2.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave2[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave3[2]);
                            }
                        });
                        thread.start();
                    }
                    if (battle4) {
                        targetLevel4.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave4[2]);
                            }
                        });
                        thread.start();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                pressedA = true;
                pressedB = true;
                pressedC = true;
                pressedD = true;
            }
        }

        if (keyPressed == KeyboardEvent.KEY_D) {

            if (pressedD == false) {

                if (!battle3) {
                    pressedA = false;
                    pressedB = false;
                    pressedC = false;
                    return;

                }

                if (isWarrior) {
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                targetDead.draw();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                pressedA = false;
                                pressedB = false;
                                pressedC = false;
                                pressedD = false;
                                pressed1 = false;

                                targetDead.delete();
                                targetLevel3.draw();



                            }
                        });
                        if (enemyWave3[3].dead) {
                            thread1.start();
                            return;
                        }
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Warrior) warrior).mortalStrike(enemyWave3[3]);
                                necromancerAttacked = false;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                startRound3Turns();
                            }
                        });
                        thread.start();
                    }
                    pressedA = true ;
                    pressedB = true;
                    pressedC = true;
                    pressedD = true;
                }
                if (isMage) {
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Mage) mage).fireball(enemyWave3[3]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isPriest) {
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Priest) priest).smite(enemyWave3[3]);
                            }
                        });
                        thread.start();
                    }
                }
                if (isGunner) {
                    if (battle3) {
                        targetLevel3.delete();
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ((Gunner) gunner).bullseye(enemyWave3[3]);
                            }
                        });
                        thread.start();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public void skip() {
        skip = true;
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void roundPlayed() {
        roundCounter++;
    }

    public void gameStart() {
        createTitle();
        gameName.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        start.draw();
        start.grow(-80, 0);

        while (!skip) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        gameName.delete();
        title.delete();
        start.delete();
        createLoading();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        createBgStart();
        Warrior.warrior.draw();
        Mage.mage.draw();
        Priest.priest.draw();
        Gunner.gunner.draw();
        heroSelection.draw();
        pressedQ = false;
        pressedW = false;
        pressedE = false;
        pressedR = false;

        while (!(isGunner || isMage || isPriest || isWarrior)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        heroSelection.delete();
        startRound1();
    }

    public void createEnemyWave1() {
        enemyWave1 = new Enemy[3];
        enemyWave1[0] = new Bat();
        enemyWave1[1] = new Slime();
        enemyWave1[2] = new Wolf();
    }

    public void createEnemyWave2() {
        enemyWave2 = new Enemy[3];
        enemyWave2[0] = new Troll();
        enemyWave2[1] = new Goblin();
        enemyWave2[2] = new Wolf();
        Wolf.wolf.translate(-360, -60);
    }

    public void createEnemyWave3() {
        enemyWave3 = new Enemy[4];
        enemyWave3[0] = new Necromancer();
        Necromancer.necromancer.grow(-30, -30);
        enemyWave3[1] = new Witch();
        enemyWave3[2] = new Skeleton();
        Skeleton.skeleton.grow(-35, -35);
        enemyWave3[3] = new Ghoul();
    }

    public void createEnemyWave4() {
        enemyWave4 = new Enemy[3];
        enemyWave4[0] = new DevilLord();
        DevilLord.devilLord.grow(-30, -30);
        enemyWave4[1] = new Imp();
        enemyWave4[2] = new Skeleton();
    }

    public void createBoss() {
        bossFight = new Enemy[1];
        bossFight[0] = new DemonKing();
        DemonKing.demonKing.grow(-20, -20);
    }

    public void startRound1() {
        warrior = new Warrior();
        mage = new Mage();
        priest = new Priest();
        gunner = new Gunner();
        try {
            Thread.sleep(3000);
            bgStart.delete();
            Priest.priest.delete();
            Warrior.warrior.delete();
            Gunner.gunner.delete();
            Mage.mage.delete();
            loading.draw();

            try {
                Thread.sleep(2000);
                loading.delete();
                createBg1();
                createEnemyWave1();
                isBattle1();


                if (isWarrior) {
                    Warrior.warrior.draw();
                    Warrior.warrior.translate(0, 150);

                    Thread.sleep(1000);

                    warriorAttack.draw();

                }
                if (isMage) {
                    Mage.mage.draw();
                    Mage.mage.translate(0, 170);

                    Thread.sleep(1000);

                    mageAttack.draw();
                }
                if (isPriest) {
                    Priest.priest.draw();
                    Priest.priest.translate(0, 140);

                    Thread.sleep(1000);
                    priestAttack.draw();
                }

                if (isGunner) {
                    Gunner.gunner.draw();
                    Gunner.gunner.translate(0, 180);

                    Thread.sleep(1000);

                    gunnerAttack.draw();
                }

                Thread.sleep(1000);

                pressed1 = false;
                pressed2 = false;
                pressed3 = false;
                pressed4 = false;


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void startRound2() {
        warrior = new Warrior();
        mage = new Mage();
        priest = new Priest();
        gunner = new Gunner();


        loading.draw();
        bg1.delete();
        Warrior.warrior.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        createBg2();
        createEnemyWave2();
        isBattle2();
        battle1 = false;

        if (isWarrior) {
            Warrior.warrior.delete();
            Warrior.warrior.draw();
            Warrior.warrior.translate(55, 35);
            Priest.priest.draw();
            Priest.priest.translate(-250, 30);
            heroWave2[0] = warrior;
            heroWave2[1] = priest;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            priestJoin.draw();


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            priestJoin.delete();

            warriorAttack.draw();
            pressed1 = false;
            pressed2 = false;
            pressed3 = false;
            pressed4 = false;

        }
        if (isMage) {
            Mage.mage.delete();
            Mage.mage.draw();
            Mage.mage.translate(0, 170);
            Warrior.warrior.draw();
            Warrior.warrior.translate(-100, 20);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            mageAttack.draw();
        }
        if (isPriest) {
            Priest.priest.delete();
            Priest.priest.draw();
            Priest.priest.translate(0, 170);
            Gunner.gunner.draw();
            Gunner.gunner.translate(105, 20);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            priestAttack.draw();
        }
        if (isGunner) {
            Gunner.gunner.delete();
            Gunner.gunner.draw();
            Gunner.gunner.translate(0, 180);
            Mage.mage.draw();
            Mage.mage.translate(-80, 20);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            gunnerAttack.draw();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pressed1 = false;
        pressed2 = false;
        pressed3 = false;
        pressed4 = false;


    }

    public void startRound3() {
        warrior = new Warrior();
        mage = new Mage();
        priest = new Priest();
        gunner = new Gunner();


        loading.draw();
        bg2.delete();
        Warrior.warrior.delete();
        Priest.priest.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        createBg3();
        createEnemyWave3();
        isBattle3();
        battle2 = false;

        if (isWarrior) {
            Warrior.warrior.delete();
            Warrior.warrior.draw();
            Warrior.warrior.translate(-70, 5);
            Priest.priest.delete();
            Priest.priest.draw();
            Priest.priest.translate(-30, 0);
            Gunner.gunner.draw();
            Gunner.gunner.translate(480, 20);
            heroWave3[0] = warrior;
            heroWave3[1] = priest;
            heroWave3[2] = gunner;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gunnerJoin.draw();


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gunnerJoin.delete();
            warriorAttack.draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            pressed1 = false;
            pressed2 = false;
            pressed3 = false;
            pressed4 = false;

        }
    }

    public void startRound4() {
        warrior = new Warrior();
        mage = new Mage();
        priest = new Priest();
        gunner = new Gunner();

        loading.draw();
        Warrior.warrior.delete();
        Priest.priest.delete();
        Gunner.gunner.delete();
        bg3.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        createBg4();
        createEnemyWave4();
        isBattle4();
        battle3 = false;

        if (isWarrior) {
            Warrior.warrior.delete();
            Warrior.warrior.draw();
            Warrior.warrior.translate(-50, 0);
            Priest.priest.delete();
            Priest.priest.draw();
            Priest.priest.translate(-30, 0);
            Gunner.gunner.delete();
            Gunner.gunner.draw();
            Gunner.gunner.translate(200, 0);
            Mage.mage.draw();
            Mage.mage.translate(250, 30);
            fullSquad[0] = warrior;
            fullSquad[1] = priest;
            fullSquad[2] = gunner;
            fullSquad[3] = mage;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mageJoin.draw();


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mageJoin.delete();
            warriorAttack.draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            pressed1 = false;
            pressed2 = false;
            pressed3 = false;
            pressed4 = false;

        }
    }

    public void startBossRound() {
        warrior = new Warrior();
        mage = new Mage();
        priest = new Priest();
        gunner = new Gunner();
        loading.draw();
        Warrior.warrior.delete();
        Priest.priest.delete();
        Gunner.gunner.delete();
        Mage.mage.delete();
        bg4.delete();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        createBg5();
        createBoss();
        isBattle5();
        battle4 = false;

        if (isWarrior) {
            Warrior.warrior.delete();
            Warrior.warrior.draw();
            Priest.priest.delete();
            Priest.priest.draw();
            Gunner.gunner.delete();
            Gunner.gunner.draw();
            Mage.mage.delete();
            Mage.mage.draw();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            warriorAttack.draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            pressed1 = false;
            pressed2 = false;
            pressed3 = false;
            pressed4 = false;

        }

    }

    public void startWinStage() {
        loading.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loading.delete();
        bg5.delete();
        createBgEnd();
        busty.draw();
        busty.translate(270,-60);
        Warrior.warrior.delete();
        Warrior.warrior.draw();
        Priest.priest.delete();
        Priest.priest.draw();
        Gunner.gunner.delete();
        Gunner.gunner.draw();
        Mage.mage.delete();
        Mage.mage.draw();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        credits.draw();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

}