package lotto.ui;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LAST_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요";

    public static String getPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return Console.readLine();
    }

    public static String getWinningNumber() {
        System.out.println(LAST_WINNING_MESSAGE);
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }

    public static String getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Console.readLine();
    }

    public static List<String> getManualLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Console.readLine());
        }
        return lottos;
    }
}
