package lotto.view;

import lotto.domain.LottoTicket;
import lotto.util.LottoViewConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TerminalInputView {

    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        scanner.reset();
        return Integer.parseInt(
                scanner.nextLine());
    }

    public List<Integer> lottoWinningNumbers() {
        scanner.reset();
        String[] numbers = scanner.nextLine()
                .split(LottoViewConstants.LOTTO_NUMBERS_DELIMITER);
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
