package Game_bev0802.Units;
import java.util.ArrayList;
/**
 * Класс отвечающий за передвижения героев на поле.
 */
public class Position{
    protected int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод вычисления расстояния до указанного героя
     * @param unit - указанный герой
     * @return - double - расстояние до героя
     * 
     */
    public double getDistance(BaseHero unit){
        return Math.sqrt(Math.pow(x - unit.position.x, 2) + Math.pow(y - unit.position.y, 2));
    }

    /**
     * Конструктор приравнивания(сравнения)
     * @param position 
     * @return
     */
    public boolean isEquals(Position position){
        return (position.x == x && position.y == y);
    }

        /**
         * Конструктор расчета движения героев.
         * @param unit
         * @return
         */
    public int[] getDirection(BaseHero unit){
        int dx = Math.abs(unit.position.x - x);
        int dy = Math.abs(unit.position.y - y);
        if (dx>=dy){
            dx = (unit.position.x - x)/Math.abs(unit.position.x - x);
            dy = 0;
        } else {
            dy = (unit.position.y - y)/Math.abs(unit.position.y - y);
            dx = 0;
        }
        int [] direction = new int[] {dx, dy};
        return direction;
    }
    /**
     * Конструктор проверки положения героев. 
     * @param position
     * @param teamArray
     * @return
     */
    public boolean chekPosition(Position position, ArrayList<BaseHero> teamArray){
        for (BaseHero hero : teamArray) {
            if (hero.getPosition().isEquals(position) && hero.getHp()>0)
                return false;
        }
        return true;
    }
}