package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.UserLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static UserLottos getManualLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> userLottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Console.readLine()))
                .collect(Collectors.toList());
        return new UserLottos(userLottos);
    }
}
