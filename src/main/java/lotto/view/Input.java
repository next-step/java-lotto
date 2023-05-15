package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class Input {
    private static final String QUESTION_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_FOR_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_FOR_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_FOR_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_FOR_BONUS = "보너스 볼을 입력해 주세요.";

    public Lottos setLottos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_MONEY);
        int money = scanner.nextInt();
        System.out.println();

        System.out.println(QUESTION_FOR_MANUAL_COUNT);
        int manualCount = scanner.nextInt();
        System.out.println();

        System.out.println(QUESTION_FOR_MANUAL_NUMBERS);
        List<Lotto> manualLottos = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < manualCount; i++) {
            String manualLottoString = scanner.nextLine();
            manualLottos.add(new Lotto(split(manualLottoString)));
        }
        System.out.println();

        return new Lottos(money, manualLottos);
    }

    public WinNumbers setWinNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_FOR_WIN_NUMBERS);
        String winNumbersString = scanner.nextLine();

        System.out.println(QUESTION_FOR_BONUS);
        int bonus = scanner.nextInt();
        System.out.println();

        return new WinNumbers(split(winNumbersString), bonus);
    }

    private static Set<Integer> split(String WinNumbersString) {
        return Arrays.stream(WinNumbersString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
