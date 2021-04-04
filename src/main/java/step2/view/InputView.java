package step2.view;

import static step2.util.StringConstant.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getSeed() {
        System.out.println(Message.SEED_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getPrize() {
        System.out.println(Message.LAST_PRIZE);
        return scanner.nextLine();
    }

    public static String getBonus() {
        System.out.println(Message.BONUS);
        return scanner.nextLine();
    }

    public static int getManualCount() {
        System.out.println(Message.MANUAL_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getManualGames(int manualGameSize) {
        System.out.println(Message.MANUAL_GAMES);
        List<String> manualGames = new ArrayList<>();
        for (int size = 0; size < manualGameSize; ++size) {
            manualGames.add(scanner.nextLine());
        }
        return String.join(NEW_LINE,manualGames);
    }
}
