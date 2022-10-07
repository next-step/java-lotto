package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String TOTAL_PRICE = "구매금액을 입력해 주세요.";
    private static final String LAST_LOTTO_RESULT = "지난주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputTotalPrice() {
        System.out.println(TOTAL_PRICE);
        return SCANNER.nextInt();
    }

    public static List<LottoNumber> inputLottoNumberLastResult() {
        System.out.println(LAST_LOTTO_RESULT);
        return Arrays.stream(SCANNER.next().split(","))
            .mapToInt(Integer::parseInt)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());
    }
}
