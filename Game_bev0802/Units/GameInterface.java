package Game_bev0802.Units;
import java.util.ArrayList;
/**
 * Интерфейс шаг героя и информация о герое
*/
public interface GameInterface {
    /**
     * Список команды.
     * @param teamArray
     */
    void step(ArrayList<BaseHero> teamArray);    
    String getInfo();
}
