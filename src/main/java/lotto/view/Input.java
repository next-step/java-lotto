package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.strategy.ManualNumberList;
import lotto.strategy.NumberList;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Input {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBER_LIST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner sc1 = new Scanner(System.in);
    private static final Scanner sc2 = new Scanner(System.in);
    private static final Scanner sc4 = new Scanner(System.in);
    private static final Scanner sc5 = new Scanner(System.in);

    public static BigDecimal inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        BigDecimal amount = sc1.nextBigDecimal();
        return amount;
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return sc2.nextInt();
    }

    public static List<Lotto> inputManualNumberList(int cnt, NumberList numberList) {
        System.out.println();
        System.out.println(INPUT_MANUAL_NUMBERS);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            lottos.add(new Lotto(numberList.makeNumberList()));
            System.out.println();
        }

        return lottos;
    }

    public static List<Integer> inputWinnerNumberList() {
        System.out.println(INPUT_WINNER_NUMBER_LIST);
        String line = sc4.nextLine();
        String[] str = line.split(", ");

        List<Integer> winnerNumberList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winnerNumberList.add(Integer.valueOf(str[i]));
        }

        return winnerNumberList;
    }

    public static Integer inputBonusBallNumber() {
        System.out.println(INPUT_BONUS_BALL_NUMBER);
        return sc5.nextInt();
    }
}
