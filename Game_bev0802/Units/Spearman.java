package Game_bev0802.Units;
/**
 * 
 * класс КОПЕЙЩИКОВ - потомок класса InfantryClass
 * 
 */ 
public class Spearman extends InfantryClass implements GameInterface{

    public Spearman(int team, String name, int x, int y) {
        super(50, 50, 4, 1, 3, 5, 4, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Spearman";
    }

    @Override
    public String getCharName(){
        return "C";
    }
}