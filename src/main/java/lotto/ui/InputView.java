/*
 * UI 입력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.LottoStrategy.LOTTO_SIZE;
import static lotto.domain.Price.LOTTO_PRICE;
import static lotto.util.Message.ILLEGAL_LOTTO_SIZE;
import static lotto.util.Message.OVERLAP_NUMBER;

public class InputView {

    public static final String BUYING_MESSAGE_BEFORE = "구입금액을 입력해 주세요.";
    public static final String BUYING_MESSAGE_AFTER = "개를 구매했습니다.";
    public static final String WINNING_MESSAGE_BEFORE = "지난주 당첨 번호를 입력해 주세요. (구분자는 ', ')";
    public static final String DELIMITER = ", ";


    private static Scanner sc;

    public static int inputBuy() {
        openScanner();
        System.out.println(BUYING_MESSAGE_BEFORE);
        int result = sc.nextInt() / LOTTO_PRICE;
        System.out.println(result + BUYING_MESSAGE_AFTER);
        sc.nextLine();
        return result;
    }

    public static List<LottoNumber> inputWinning() {
        System.out.println(WINNING_MESSAGE_BEFORE);
        String[] result = sc.nextLine().split(DELIMITER);
        checkNumberSize(result);
        checkNumberOverlap(result);

        return Arrays.stream(result)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static void openScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    private static boolean checkNumberSize(String[] result) {
        if (result.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_SIZE);
        }
        return true;
    }

    private static boolean checkNumberOverlap(String[] result) {
        if(Arrays.stream(result)
                .distinct()
                .count() != result.length) {
            throw new IllegalArgumentException(OVERLAP_NUMBER);
        }

        return true;
    }

}
