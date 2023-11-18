package lotto.view;

import lotto.model.LottoNumbers;
import lotto.model.PositiveNumber;
import lotto.model.WinnerNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    static Scanner scanner = new Scanner(System.in);

    public long getInput() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextLong();
    }

    public WinnerNumbers getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        LottoNumbers numbers = new LottoNumbers(
                Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .map(PositiveNumber::new)
                        .collect(Collectors.toSet()));
        return new WinnerNumbers(numbers);
    }
}
