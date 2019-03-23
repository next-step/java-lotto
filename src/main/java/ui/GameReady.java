package ui;

import view.InputPriceView;
import view.InputWinningView;

import java.util.Scanner;

public class GameReady {
    private static final String INPUT_PRICE_COMMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static InputPriceView inputPrice() {
        System.out.println(INPUT_PRICE_COMMENT);
        InputPriceView priceView = new InputPriceView(scanner.nextInt());
        return priceView;
    }

    public static InputWinningView inputWinning() {
        System.out.println(INPUT_WINNING_COMMENT);
        InputWinningView winningView = new InputWinningView(scanner.skip("[\\r\\n]+").nextLine());
        return winningView;
    }
}
