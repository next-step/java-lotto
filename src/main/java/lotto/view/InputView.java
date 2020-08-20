package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_PHRASE = "구입금액을 입력해 주세요.";
    private static final String WINNING_TICKET_PHRASE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public int getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_PHRASE);
        return Integer.valueOf(scanner.nextLine());
    }

    public List<Integer> getWinningNumbers() {
        System.out.println(WINNING_TICKET_PHRASE);
        String input = scanner.nextLine();
        System.out.println(input);
        return Arrays.stream(input.replaceAll(" ", "").split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
