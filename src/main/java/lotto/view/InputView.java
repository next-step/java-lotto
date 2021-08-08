package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoNumbers requestWinnerNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return new LottoNumbers(Arrays.stream(scanner.nextLine().split(",")).map(String::trim).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList()));
    }
}
