package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.util.IntegerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_INSERT_PRICE = "구입금액을 입력해 주세요.";
    private static final String QUESTION_INSERT_WIN_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_INSERT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_INSERT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_INSERT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_DELIMITER = ",";

    public Price insertPrice() {
        System.out.println(QUESTION_INSERT_PRICE);
        Scanner scanner = new Scanner(System.in);
        return Price.of(scanner.nextLine());
    }

    public List<List<Integer>> insertManualLottoNumberList() {
        System.out.println(QUESTION_INSERT_MANUAL_LOTTO_COUNT);
        Scanner scanner = new Scanner(System.in);
        int manualLottoCount = IntegerUtils.parsePositiveInt(scanner.nextLine());

        System.out.println(QUESTION_INSERT_MANUAL_LOTTO_NUMBER);
        List<List<Integer>> manualLottoNumbersList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String[] numberStrings = scanner.nextLine().split(LOTTO_DELIMITER);
            List<Integer> numberList = Arrays.stream(numberStrings).map(IntegerUtils::parsePositiveInt).collect(Collectors.toList());
            manualLottoNumbersList.add(numberList);
        }
        return manualLottoNumbersList;
    }

    public Lotto insertWinLotto() {
        System.out.println(QUESTION_INSERT_WIN_LOTTO);
        Scanner scanner = new Scanner(System.in);
        String[] winNumberStrings = scanner.nextLine().split(LOTTO_DELIMITER);
        List<Integer> winNumberList = Arrays.stream(winNumberStrings).map(IntegerUtils::parsePositiveInt).collect(Collectors.toList());
        return new Lotto(winNumberList);
    }

    public int insertBonusNumber() {
        System.out.println(QUESTION_INSERT_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
