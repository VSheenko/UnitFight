import java.security.SecureRandom;
import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);
    SecureRandom random = new SecureRandom();
    int move = random.nextInt(2);
    int mode = 0;
    Player[] players;

    /*
    1 - Auto
    2 - Manual
     */
    Game(int mode) {
        players = new Player[2];

        System.out.println("Добро пожаловать в 'Мир меча, магии и ТЕРМИНАТОРОВ'");
        System.out.println("========Начнем========");
        System.out.print("Выберите имена для игроков:\n" +
                "~Первый игрок: ");
        players[0] = new Player(in.next());
        System.out.print("~Второй игрок: ");
        players[1] = new Player(in.next());
        this.mode = mode;
        System.out.println("=======Режим " + mode + "=======");
    }

    protected void gameBody() {
        while (players[0].getHpPlayer() != 0 && players[1].getHpPlayer() != 0) {
            if (move % 2 == 0) {
                System.out.println("Ход игрока " + players[0].namePlayer + " | Активный юнит - " + (players[0].curActive + 1));
                playerMove(players[0], players[1]);
            } else if (move % 2 == 1) {
                System.out.println("Ход игрока " + players[1].namePlayer + " | Активный юнит - " + (players[1].curActive + 1));
                playerMove(players[1], players[0]);
            }
            move += 1;
            move %= 2;
        }


        if (players[0].getHpPlayer() == 0) System.out.println("====== Игрок " + players[1].namePlayer + " победил =======");
        else System.out.println("====== Игрок " + players[0].namePlayer + " победил =======");

    }

    private void playerMove (Player p1, Player p2) {
        System.out.println("Выберите оппонента (1 - 3):");
        p2.showLivingUnits();
        int opponent = 0;

        if (mode == 1) {
            opponent = random.nextInt(3);
            System.out.println(opponent);
        } else if (mode == 2) {
            opponent = in.nextInt();
        }

        if (p2.units[opponent - 1].health == 0) {
            System.out.println("Юнит уже не дышит");
        } else {
            p1.units[p1.curActive].Attack(p2.units[opponent - 1]);
        }
        p2.getCurActive();
        System.out.println(">------------------------------------<");
    }
}
