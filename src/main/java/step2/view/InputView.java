package step2.view;

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

    public static int getBonus() {
        System.out.println(Message.BONUS);
        return Integer.parseInt(scanner.nextLine());
    }
}
