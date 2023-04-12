package Game_bev0802;

import Game_bev0802.Units.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Класс для создания команд.
 */
public class Init {
    public static void createTeam() {
                 
        Program.namesHero = new ArrayList<>();  // список имен для созданных героев (чтобы проверять на повторы)

        /**
         * создаем команду №1
         */
        Program.whiteSide = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    Program.whiteSide.add(new Priest(1, createNames(), 0, i));
                    break;
                case 1:
                    Program.whiteSide.add(new Robber(1, createNames(), 0, i));
                    break;
                case 2:
                    Program.whiteSide.add(new Sniper(1, createNames(), 0, i));
                    break;
                case 3:
                    Program.whiteSide.add(new Peasant(1, createNames(), 0, i));
                    break;
            }
        }

        /**
         * сортировка команды 
         */      
        Program.whiteSide.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (int)(u2.getHp() - (int)(u1.getHp()));
                return (u2.getSpeed() - u1.getSpeed());
            }
        });

        // создаем команду №2 и выводим список в терминал
        Program.darkSide = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    Program.darkSide.add(new Magician(2, createNames(), 9, i));
                    break;
                case 1:
                    Program.darkSide.add(new Spearman(2, createNames(), 9, i));
                    break;
                case 2:
                    Program.darkSide.add(new Crossbowman(2, createNames(), 9, i));
                    break;
                case 3:
                    Program.darkSide.add(new Peasant(2, createNames(), 9, i));
                    break;
            }
        }
        // сортировка команды
            Program.darkSide.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (int)(u2.getHp() - (int)(u1.getHp()));
                return (u2.getSpeed() - u1.getSpeed());
            }
        });

        // создание ОБШЕЙ команды и сортировка ее по скорости героя
        Program.allUnits = new ArrayList<>();
        Program.allUnits.addAll(Program.whiteSide);
        Program.allUnits.addAll(Program.darkSide);
        Program.allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u2.getSpeed() - u1.getSpeed() == 0)
                    return (int)(u2.getHp() - (int)(u1.getHp()));
                return (u2.getSpeed() - u1.getSpeed());
            }
        });
    }

    // метод STEP для обеих команд
    public static void makeStep(){
        BaseHero hero = Program.whiteSide.get(0);
        for (int i = 0; i < Program.GANG_SIZE; i++) {
            hero = Program.whiteSide.get(i);
            hero.step(Program.allUnits);
            if (hero.getGameOver() > 0) break;
            hero = Program.darkSide.get(i);
            hero.step(Program.allUnits);
            if (hero.getGameOver() > 0) break;
        }
        if (hero.getGameOver() > 0){
            Program.GameOver = true;
            if (hero.getGameOver() == 1)
                System.out.println("\n  <<< Победила команда Green !!! >>>\n");
            else
                System.out.println("\n  <<< Победила команда Blue !!! >>>\n");
        }
    }

    /**
     * метод рандомного выбора имени из списка Names.java
     @return String name
     */

    private static String createNames() {
        String nameRandom;
        do {
            nameRandom = Names.values()[new Random().nextInt(Names.values().length)].toString();
        } while ( Program.namesHero.size() > 0 &&  Program.namesHero.contains(nameRandom));
         Program.namesHero.add(nameRandom);
        return nameRandom;
    }    
}