package lotto.view;

import lotto.domain.Lotteries;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Price;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this(System.in);
    }

    InputView(final InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public Price inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return new Price(Integer.parseInt(scanner.nextLine()));
    }

    public LottoNumbers inputLastWeekendWinningLottery() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return new LottoNumbers(scanner.nextLine());
    }

    public LottoNumber inputBonusBall() {
        System.out.println();
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return LottoNumber.valueOf(Integer.valueOf(scanner.nextLine()));
    }

    public int inputManualCount() {
        System.out.println();
        System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
        return Integer.valueOf(scanner.nextLine());
    }

    public Lotteries inputManualLottoNumbers(final int manualCount) {
        System.out.println();
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            lottoNumbers.add(new LottoNumbers(scanner.nextLine()));
        }
        return new Lotteries(lottoNumbers);
    }
}
