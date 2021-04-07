/*
 * UI 입력을 담당하는 클래스
 * */
package lotto.ui;

import lotto.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.Rank.LOTTO_PRICE;
import static lotto.util.StringUtil.*;

public class InputView {

    public static final String BUYING_MESSAGE_BEFORE = "구입금액을 입력해 주세요.";
    public static final String WINNING_MESSAGE_BEFORE = "지난주 당첨 번호를 입력해 주세요. (구분자는 ', ')";
    public static final String BONUS_MESSAGE_BEFORE = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_LOTTO_SIZE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";


    private static Scanner sc;

    public static int inputBuy() {
        openScanner();
        System.out.println(BUYING_MESSAGE_BEFORE);
        int size = inputInt() / LOTTO_PRICE;
        return size;
    }

    public static int inputManualSize() {
        System.out.println(MANUAL_LOTTO_SIZE_MESSAGE);
        return inputInt();
    }

    public static ArrayList<Integer> inputWinning() {
        System.out.println(WINNING_MESSAGE_BEFORE);
        return inputNumbers();
    }

    public static ArrayList<ArrayList<Integer>> inputManualLotto(int size) {
        if (size <= 0) {
            return null;
        }
        System.out.println(MANUAL_LOTTO_NUMBER_MESSAGE);
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(inputNumbers());
        }
        return numbers;
    }

    public static int inputBonus() {
        System.out.println(BONUS_MESSAGE_BEFORE);
        return inputInt();
    }

    public static ArrayList<Integer> inputNumbers() {
        String[] result = sc.nextLine().split(DELIMITER);
        checkNumberSize(result);
        checkNumberOverlap(result);

        return Arrays.stream(result)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static int inputInt() {
        return StringUtil.parseInt(sc.nextLine());
    }

    public static void openScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }


}
