package lotto.view;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_BUY_MONEY_MESSAGE = "구매금액을 입력해 주새요.";
    public static final String INPUT_PREVIOUS_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String SPLIT_DELIMITER = ",";
    private static Scanner scanner;

    public static int inputBuyMoney() {
        scanner = new Scanner(System.in);
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public static Lotto inputPreviousLottoNumber() {
        scanner = new Scanner(System.in);
        System.out.println(INPUT_PREVIOUS_LOTTO_NUMBER_MESSAGE);
        String inputLottoNumberString = scanner.nextLine();

        Set<Ball> lottoNumberSet = Arrays.stream(inputLottoNumberString.split(SPLIT_DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .map(Ball::new)
                .collect(Collectors.toSet());

        return new Lotto(lottoNumberSet);
    }

}
