package lotto.step4.view;

import lotto.step4.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 로또 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int money = sc.nextInt();
        new Money(money);
        return money;
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return sc.nextInt();
    }

    public static List<Lottery> inputManualLottoNumbers(int lottoCount) {
        List<Lottery> lotteries = new ArrayList<>();
        if (lottoCount == 0){
            return lotteries;
        }
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
        sc.nextLine();
        while (lottoCount-- > 0) {
            lotteries.add(LottoCreator.convertToLotto(sc.nextLine()));
        }
        return lotteries;
    }

    public static Lottery inputLastWinningNumbers() {
        System.out.println(INPUT_LAST_WINNING_NUMBERS);
        return LottoCreator.convertToLotto(sc.nextLine());
    }

    public static LottoNumber inputBonusBall() {
        System.out.println(INPUT_BONUS_NUMBER);
        return new LottoNumber(sc.nextInt());
    }

}
