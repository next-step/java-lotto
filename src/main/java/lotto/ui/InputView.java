package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Price;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_INSERT_PRICE = "구입금액을 입력해 주세요.";
    private static final String ANSWER_INSERT_PRICE = "%d개를 구매했습니다.";
    private static final String QUESTION_INSERT_WIN_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_DELIMITER = ",";

    public Price insertPrice() {
        System.out.println(QUESTION_INSERT_PRICE);
        Scanner scanner = new Scanner(System.in);
        return Price.of(scanner.nextLine());
    }

    public void answerPrice(int count) {
        System.out.println(String.format(ANSWER_INSERT_PRICE, count));
    }

    public void printLotto(Lotto lotto) {
        String[] numbers = lotto.getLottoNumberList().stream().map(value -> String.valueOf(value.getNumber())).toArray(String[]::new);
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public Lotto insertWinLotto() {
        System.out.println(QUESTION_INSERT_WIN_LOTTO);
        Scanner scanner = new Scanner(System.in);
        String[] winNumberStrings = scanner.nextLine().split(LOTTO_DELIMITER);
        List<Integer> winNumberList = Arrays.stream(winNumberStrings).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        return Lotto.generateByManual(winNumberList);
    }
}
