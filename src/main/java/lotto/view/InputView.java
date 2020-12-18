package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_LOTTO_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String UNNECESSARY_SPACE_DELIMITER = " ";
    private static final String EMPTY = "";
    private static final String NUMBER_DELIMITER = ",";
    private static final String BONUS_BALL_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int readPurchasingAmount() {
        System.out.println(PURCHASE_LOTTO_INPUT_MESSAGE);
        return readInteger();
    }

    public static Lotto readWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        LottoNumbers winningLottoNumbers = new LottoNumbers(convertWinningLottoNumbers(readString()));
        return new Lotto(winningLottoNumbers);
    }

    public static LottoNumber readBonusLottoNumber() {
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
        return new LottoNumber(readInteger());
    }

    private static List<Integer> convertWinningLottoNumbers(String numbers) {
        String[] convertedNumbers = numbers.replace(UNNECESSARY_SPACE_DELIMITER, EMPTY).split(NUMBER_DELIMITER);
        return Arrays.stream(convertedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
