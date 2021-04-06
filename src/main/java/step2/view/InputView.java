package step2.view;

import static step2.util.StringConstant.NEW_LINE;
import static step2.view.Validator.validateGame;
import static step2.view.Validator.validateMinManualCount;
import static step2.view.Validator.validateMinSeed;
import static step2.view.Validator.validateParesInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getSeed() {
        System.out.println(Message.SEED_MONEY);
        int seed = validateParesInt(scanner.nextLine());
        validateMinSeed(seed);
        return seed;
    }

    public static String getPrize() {
        System.out.println(Message.LAST_PRIZE);
        String prize = scanner.nextLine();
        validateGame(prize);
        return prize;
    }

    public static String getBonus() {
        System.out.println(Message.BONUS);
        String bonus = scanner.nextLine();
        validateParesInt(bonus);
        return bonus;
    }

    public static int getManualCount() {
        System.out.println(Message.MANUAL_COUNT);
        int manualCount = validateParesInt(scanner.nextLine());
        validateMinManualCount(manualCount);
        return manualCount;
    }

    public static String getManualGames(int manualGameSize) {
        System.out.println(Message.MANUAL_GAMES);
        List<String> manualGames = new ArrayList<>();
        for (int size = 0; size < manualGameSize; ++size) {
            String game = scanner.nextLine();
            validateGame(game);
            manualGames.add(game);
        }
        return String.join(NEW_LINE, manualGames);
    }
}
