package Game_bev0802.Units;

/**
 * класс РАЗБОЙНИКОВ - потомок класса InfantryClass
 *  
 */ 
public class Robber extends InfantryClass implements GameInterface{
/**
  * Параметры класса РАЗБОЙНИКОВ
  * @param team - номер команды
  * @param name - имя героя
  * @param x - коррдината на поле X
  * @param y - коррдината на поле Y
  *
 */
    public Robber(int team, String name, int x, int y) {
        super(20, 20, 6, 2, 4, 3, 8, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Robber";
    }

    @Override
    public String getCharName(){
        return "R";
    }
}