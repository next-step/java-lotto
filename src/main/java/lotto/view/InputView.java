package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static long readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        long amount = Long.parseLong(SCANNER.nextLine());

        if (amount < 1000) {
            throw new IllegalArgumentException("1000원 이상의 구입금액을 입력해주세요");
        }

        return amount;
    }

    public static List<LottoNumber> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();

        List<Integer> winningNumbers = splitLottoNumbers(input);
        if (winningNumbers.size() != LottoTicket.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호의 개수가 부족하거나 초과합니다.");
        }

        return winningNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
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
