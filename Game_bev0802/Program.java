package Game_bev0802;

import java.util.ArrayList;
import java.util.Scanner;

import Game_bev0802.Units.*;

public class Program {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> allUnits;
    public static ArrayList<String> namesHero;
    public static Scanner iScanner = new Scanner(System.in, "cp866");
    static boolean GameOver = false;

    public static void main(String[] args) {

        Init.createTeam();                       // инициализация двух команд
        System.out.println(" -- НАЧАЛО БОЯ ---");

        ConsoleView.view();                     // вывести начальную граф/табличку состояния обеих команд

        do {
            System.out.println();
            System.out.println("Нажмите кнопку Enter... (0 - завершение игры)");
            String str = iScanner.nextLine();
            if (str.equals("0"))        // если ввели 0 - то завершение игры
                GameOver = true;
            else                          
            Init.makeStep();                    // сделать STEP для всех юнитов
            ConsoleView.view();                 // вывести псевдографику
        } while (!GameOver);                    // завершить цикл если GameOver

        iScanner.close();
    }
}   
    