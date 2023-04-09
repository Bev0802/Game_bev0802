package Game_bev0802.Units;
import java.util.ArrayList;
/**
 * КРЕСТЬЯНИН - не имеет промежуточного подкласса, он сразу потомок класса BaseHero
 */
public class Peasant extends BaseHero implements GameInterface{

    public Peasant(int team, String name, int x, int y) {
        super(1, 1, 3, 1, 1, 1, 1, team, name, x, y);
    }

    @Override
    public String getClassName(){
        return "Peasant";
    }

    @Override
    public String getCharName(){
        return "P";
    }

    @Override
    public String getInfo(){
        return super.getInfo() + String.format("\t    ");
    }

    @Override
    public void step(ArrayList<BaseHero> teamOpponent) {
        System.out.printf("(%d) %s %s:\n    > Готов принести стрелы!\n", this.getTeam(), this.getClassName(), this.getName());
    }
}
