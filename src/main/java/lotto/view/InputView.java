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
        int totalAmount = Integer.parseInt(SCANNER.nextLine()); // 금액을 입력 받음
        return totalAmount;
    }

    public List<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = SCANNER.nextLine();
        return inputNumberChangeArray(winningNumbers.trim())
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static Stream<Integer> inputNumberChangeArray(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(",\\s*"))
                .map(Integer::parseInt);
    }

    public LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = Integer.parseInt(SCANNER.nextLine()); // 여기서 nextLine()으로 보너스 볼을 받음
        return new LottoNumber(bonusBall);
    }
}
