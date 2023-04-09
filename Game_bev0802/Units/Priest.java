package Game_bev0802.Units;
/**
 * класс МОНАХ - потомок класса MagicClass
 */
public class Priest extends MagicClass implements GameInterface{

    public Priest(int team, String name, int x, int y) {
            super(30, 30, 5, 4, 4, 7, 12, 1, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Priest";
    }
    @Override
    public String getCharName(){
        return "G";
    }
}
