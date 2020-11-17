package view;

import domain.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final String LOTTO_PRICE_TOTAL = "구입금액을 입력해주세요.";
    private final String LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public int inputPrice() {
        System.out.println(LOTTO_PRICE_TOTAL);
        return Integer.parseInt(scanner.nextLine());
    }

    public LottoNumbers inputLastWinningNumber() {
        System.out.println(LAST_LOTTO_NUMBER);
        String[] split = scanner.nextLine().split(", ");
        return new LottoNumbers().from(
                Arrays.stream(split)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

}
