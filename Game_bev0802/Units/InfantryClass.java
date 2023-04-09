package Game_bev0802.Units;
import java.util.ArrayList;

/** 
 * 2. InfantryClass - класс бойцов ближнего боя / пехотинцев (потомок класса BaseHero)
 * это родительский класс для:
 * 2.1. Robber - класс РАЗБОЙНИКОВ (потомок класса InfantryClass)
 * 2.2. Spearman - класс КОПЕЙЩИКОВ (потомок класса InfantryClass)
 * 
*/
public abstract class InfantryClass extends BaseHero {
/**
 * 
 * @param hp - текущее здоровье
 * @param maxHp - максимальное здоровье
 * @param speed - скорость
 * @param damage - уровень урона
 * @param damageMax - уровень максимального урона
 * @param defence - уровень защиты
 * @param attack - уровень атаки
 * @param team - номер команды
 * @param name - имя героя
 * @param x
 * @param y
 */

    public InfantryClass(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int team,
                        String name, int x, int y) {
        super(hp, maxHp, speed, damage, damageMax, defence, attack, team, name, x, y);
    }

    @Override
    public String getInfo(){
        return super.getInfo() + String.format("\t    ");
    }

    @Override
    public void step(ArrayList<BaseHero> teamArray) {
        if (hp<=0) hp = 0;
        else {
            System.out.printf("(%d) %s %s:\n    > К бою готов!\n", this.getTeam(), this.getClassName(), this.getName());
            int opponentIndex = nearestIndexEnemy(teamArray);
            if (opponentIndex<0) this.setGameOver(team);
            else {
                BaseHero opponent = teamArray.get(opponentIndex);
                System.out.printf("    > Я выбрал цель! -> %s %s", 
                                        opponent.getClassName(), opponent.getName());
                double len = position.getDistance(opponent);
                //int lens = (int)(Math.round(len));
                System.out.printf("  (расстояние до цели: %.0f)\n", len);
                if (len<=1.5){
                    System.out.print("    > Атакую !");
                    this.attack(opponent);
                } else {
                    this.move(opponent);
                }
            }
        }
    }
}
