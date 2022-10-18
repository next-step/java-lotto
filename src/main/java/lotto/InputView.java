package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static long readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(SCANNER.nextLine());
    }

    public static List<LottoNumber> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();

        List<Integer> winningNumbers = splitLottoNumbers(input);
        if (winningNumbers.size() != LottoTicket.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호의 개수가 부족하거나 초과합니다.");
        }

        return winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private static List<Integer> splitLottoNumbers(String numberString) {
        if (numberString.isBlank()) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(numberString.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
