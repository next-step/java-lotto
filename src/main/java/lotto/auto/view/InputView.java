package lotto.auto.view;

import lotto.auto.domain.Lotto;
import lotto.auto.domain.LottoPaper;
import lotto.auto.vo.WinNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String REQUEST_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUEST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String SPLIT_STRING = ", ";
    Scanner scanner = new Scanner(System.in);

    public int requestMoney() {
        System.out.println(REQUEST_PRICE_MESSAGE);
        String money = scanner.nextLine();
        return Integer.parseInt(money);
    }

    public int requestManualLottoCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        String count = scanner.nextLine();
        return Integer.parseInt(count);
    }

    ;

    public LottoPaper requestManualLottoNumber(LottoPaper lottoPaper, int count) {
        System.out.println(REQUEST_MANUAL_LOTTO_NUMBER);
        for (int i = 0; i < count; i++) {
            String result = scanner.nextLine();
            String[] split = result.split(SPLIT_STRING);
            lottoPaper.addManualLotto(new Lotto(Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList())));
        }
        return lottoPaper;
    }

    public WinNumber requestWinNumber() {
        System.out.println(REQUEST_WIN_NUMBER_MESSAGE);
        String result = scanner.nextLine();
        String[] splitResults = result.split(SPLIT_STRING);
        return new WinNumber(Arrays.stream(splitResults).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public int requestBonusBall() {
        System.out.println(REQUEST_BONUS_BALL);
        String bonusBall = scanner.nextLine();
        return Integer.parseInt(bonusBall);
    }
}
