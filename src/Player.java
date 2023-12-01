import java.util.Scanner;

public class Player {
    String name;
    Scanner in = new Scanner(System.in);
    String namePlayer;
    Unit[] units;

    int curActive = 0;

    Player(String namePlayer) {
        this.namePlayer = namePlayer;
        units = new Unit[3];

        System.out.println("Выберите 3 героя в том порядке, в котором они будут атаковать (написать номер)\n" +
                "1. Knight\n" +
                "2. Wizard\n" +
                "3. Terminator");

        int temp;
        for (int i = 0; i < 3; i++) {
            System.out.print("~");
            temp = in.nextInt();

            if (temp == 1) {
                units[i] = new Knight();
            } else if (temp == 2) {
                units[i] = new Wizard();
            } else if (temp == 3) {
                units[i] = new Terminator();
            } else {
                System.out.println("Mimo");
                i--;
            }
        }
    }

    public double getHpPlayer() {
        double summa = 0;
        for (Unit unit : units) {
            summa += unit.health;
        }

        return summa;
    }
    public void showLivingUnits(){
        for (Unit unit : units) {
            System.out.print(unit.name + "(" + unit.health + ") ");
        }
        System.out.println();
    }


    public void getCurActive() {
        for (int i = 0; i < 3; i++) {
            if (units[i].health != 0) {
                curActive = i;
                break;
            }
        }
    }
}