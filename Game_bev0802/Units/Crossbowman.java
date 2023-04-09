package Game_bev0802.Units;

/**
 * Класс АРБАЛЕТЧИК - потомок класса ShooterClass
 * 
 */

public class Crossbowman extends ShooterClass implements GameInterface{
/**
 * 
 * @param team - номер команды
 * @param name - имя героя
 * @param x - коррдината на поле X
 * @param y - коррдината на поле Y
 */
    public Crossbowman(int team, String name, int x, int y) {
        super(10, 10, 7, 2, 3, 25, 7, 16, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Crossbowman";
    }

    @Override
    public String getCharName(){
        return "С";
    }
}