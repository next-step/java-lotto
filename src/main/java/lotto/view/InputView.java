package lotto.view;

import lotto.domain.Lotto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_CUSTOM_INPUT_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MESSAGE_CUSTOM_INPUT_LOTTO_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    public static final String REGEX = ", ";

    public static int getLottoMoney() {
        System.out.println(INPUT_MESSAGE_LOTTO_MONEY);
        return scanner.nextInt();
    }

    public static int getCustomInputLottoCount() {
        System.out.println(INPUT_MESSAGE_CUSTOM_INPUT_LOTTO_COUNT);
        return scanner.nextInt();
    }

    public static List<Lotto> getCustomLottos(int customCount) {
        if (customCount == 0) return null;

        System.out.println(INPUT_MESSAGE_CUSTOM_INPUT_LOTTO_NUMBER);
        scanner.nextLine();
        String lottoNumber = scanner.nextLine();
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < customCount; i++) {
            lottos.add(new Lotto(getCommonLottoNumbers(lottoNumber)));
        }

        return lottos;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        scanner.nextLine();
        String winningLottoNumber = scanner.nextLine();
        return getCommonLottoNumbers(winningLottoNumber);
    }

    public static int getBonusBall() {
        System.out.println(INPUT_MESSAGE_BONUS_BALL);
        return scanner.nextInt();
    }

    public static List<Integer> getCommonLottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(REGEX))
                .map(InputView::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }
}
