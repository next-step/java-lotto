package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getSeed() {
        System.out.println(Message.SEED_MONEY);
        return scanner.nextInt();
    }

    public static String getPrize() {
        System.out.println(Message.LAST_PRIZE);
        return scanner.nextLine();
    }
}
