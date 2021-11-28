package lotto.lottogame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String COMMA = ",";
    private static final int LOTTO_SIZE = 6;

    private InputView() {
        throw new AssertionError();
    }

    public static int printInputOrderPrice() {
        System.out.println("구매 금액을 입력해주세요.");
        String orderPrice = sc.nextLine();
        checkIsDigit(orderPrice);
        int price = Integer.parseInt(orderPrice);
        if (price < 1000) {
            throw new IllegalArgumentException("1000원 이상 입력바람");
        }
        return Integer.parseInt(orderPrice);
    }

    public static int printInputOrderCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String orderCount = sc.nextLine();
        checkIsDigit(orderCount);
        return Integer.parseInt(orderCount);
    }

    public static List<List<Integer>> printInputLottoNumbers(int orderCount) {
        if (orderCount <= 0) {
            return new ArrayList<>();
        }
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> lotteries = new ArrayList<>();
        for (int i = 0; i < orderCount; i++) {
            lotteries.add(inputToLottoNumbers());
        }
        return lotteries;
    }

    public static List<Integer> printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputToLottoNumbers();
    }

    public static int PrintInputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = sc.nextLine();
        checkIsDigit(bonusBall);
        System.out.println();
        return Integer.parseInt(bonusBall);
    }

    private static List<Integer> inputToLottoNumbers() {
        String[] input = sc.nextLine().split(COMMA);
        Arrays.stream(input)
                .forEach(InputView::checkIsDigit);
        List<Integer> lottoNumbers = Arrays.stream(input)
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
        checkNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static void checkIsDigit(String orderPrice) {
        for (char c : orderPrice.trim().toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
        }
    }

    private static void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력 해주세요.!!");
        }
        numbers.forEach(n -> {
            if (!(1 <= n && n <= 45)) {
                throw new IllegalArgumentException("1~45 숫자를 입력해주세요.!!");
            }});
    }

}
