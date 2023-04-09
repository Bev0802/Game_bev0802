package Game_bev0802.Units;
/**
 * класс СНАЙПЕРОВ - потомок класса ShooterClass
 */
public class Sniper extends ShooterClass implements GameInterface{

    public Sniper(int team, String name, int x, int y) {
        super(15, 15, 9, 8, 10, 10, 12, 32, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Sniper";
    }

    @Override
    public String getCharName(){
        return "S";
    }
}