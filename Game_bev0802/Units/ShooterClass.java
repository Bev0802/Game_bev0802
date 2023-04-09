package Game_bev0802.Units;
import java.util.ArrayList;
/**
 * 3. ShooterClass - класс бойцов дальнего боя / стрелков (потомок класса BaseHero)
 * это родительский класс для:
 * 3.1. Sniper - класс СНАЙПЕРОВ (потомок класса ShooterClass)
 * 3.2. Crossbowman - класс АРБАЛЕТЧИКОВ (потомок класса ShooterClass)
 *
 */
public abstract class ShooterClass extends BaseHero {

    protected int arrows; // количество стрел
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
     * @param x - коррдината на поле X
     * @param y - коррдината на поле Y
     * @param aroows - колличество стрел
     */
    public ShooterClass(float hp, float maxHp, int speed, int damage, int damageMax, int defence, int attack, int arrows, int team,
                        String name, int x, int y) {
        super(hp, maxHp, speed, damage, damageMax, defence, attack, team, name, x, y);
        this.arrows = arrows;
    }

    // Получение информации о герое
    @Override
    public String getInfo(){
        return super.getInfo() + String.format("%d", arrows); // String.format("\u21F6%-3d");
    }

    protected int getArrows() {
        return this.arrows;
    }
    
    @Override
    public void step(ArrayList<BaseHero> teamArray) {
        if (hp<=0) hp = 0;
        else if (arrows>0) {
            System.out.printf("(%d) %s %s:\n    > К выстрелу готов! У меня %d стрел\n", 
                                this.getTeam(), this.getClassName(), this.getName(), arrows);
            int opponentIndex = nearestIndexEnemy(teamArray);
            if (opponentIndex<0) this.setGameOver(team);
            else {
                BaseHero opponent = teamArray.get(opponentIndex);
                System.out.printf("    > Вижу цель! -> %s %s", opponent.getClassName(), opponent.getName());
                System.out.printf("  (расстояние до цели: %d)\n", (int)position.getDistance(opponent));
                System.out.print("    > Выстрелил! ");
                this.attack(opponent);
                int indexPeasant  = mineIndexPeasant(teamArray);
                if (indexPeasant<0) {
                    arrows -= 1;
                    System.out.println("    > у нас крестьян больше нет, запас стрел пополнить не могу...");
                }
                opponentIndex = nearestIndexEnemy(teamArray);
                if (opponentIndex<0) this.setGameOver(team);
            }
        }
        else 
            System.out.printf("(%d) %s %s:\n    > Стрелять не могу... У меня закончились стрелы!\n", this.getTeam(), this.getClassName(), this.getName());
    }

    /**
     * Метод поиска индекса крестьянина из своей команды
     * @param teamArray
     * @return индекс крестьянина, если нет то будет -1
     */
    protected int mineIndexPeasant(ArrayList<BaseHero> teamArray){
        for (int i = 0; i < teamArray.size(); i++) {
            // если: 1) герой из своей команды, 2) это крестьянин, 3) он живой
            if (teamArray.get(i).getTeam() == team && teamArray.get(i).getClassName().equals("Крестьянин") && teamArray.get(i).getHp()>0)
                return i;
        }
        return -1;
    }
}
