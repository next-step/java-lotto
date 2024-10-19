package lotto.view;

import lotto.entity.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputTotalAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public List<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = SCANNER.next();
        return inputNumberChangeArray(winningNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static Stream<Integer> inputNumberChangeArray(String winningNumbers) {
        return Arrays.stream(winningNumbers.replace(" ","").split(","))
                .map(Integer::parseInt);
    }
}
