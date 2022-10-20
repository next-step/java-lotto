package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class InputView {

    private static final String TOTAL_PRICE = "구매금액을 입력해 주세요.";
    private static final String LAST_LOTTO_RESULT = "지난주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_COUNT_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputTotalPrice() {
        System.out.println(TOTAL_PRICE);
        return SCANNER.nextInt();
    }

    public static List<Integer> inputLottoNumberLastResult() {
        System.out.println(LAST_LOTTO_RESULT);
        return Arrays.stream(SCANNER.next().split(","))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int inputBonusBall() {
        System.out.println(BONUS_BALL);
        return SCANNER.nextInt();
    }

    public static int inputManualCountNumber() {
        System.out.println(MANUAL_COUNT_NUMBER);
        return SCANNER.nextInt();
    }

    public static List<Lotto> inputManualLottoNumber(int count) {
        System.out.println(MANUAL_LOTTO_NUMBER);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> collect = Arrays.stream(SCANNER.next().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
            lottos.add(Lotto.of(collect));
        }
        return lottos;
    }
}
