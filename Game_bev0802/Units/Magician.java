package Game_bev0802.Units;
/** 
 * Magician - класс МАГОВ или КОЛДУНОВ (потомок MagClass) 
 * 
 */
public class Magician extends MagicClass implements GameInterface{

    int magicPower;
    public Magician(int team, String name, int x, int y) {
        super(30, 30, 9, 5, 5, 12, 17, 1, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Magician";
    }

    @Override
    public String getCharName(){
        return "M";
    }
}