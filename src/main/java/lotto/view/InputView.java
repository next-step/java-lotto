package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputMoneyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String strLottoNumbers = scanner.nextLine();
        return Arrays.stream(strLottoNumbers.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }
}
