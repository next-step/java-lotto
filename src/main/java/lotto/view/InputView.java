package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc = new Scanner(System.in);
    private static final int REFERENCE_PRICE = 1000;
    private static final int REMAINDER_VALUE = 10;

    private int count = 0;

    public int buyLotto() {
        System.out.println("구매할 로또 금액을 입력하세요.");
        return sc.nextInt();
    }

    public int validateLotto(int price) {
        if (price % REMAINDER_VALUE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해야 합니다.");
        }

        if (price < REFERENCE_PRICE) {
            throw new IllegalArgumentException("돈이 천원보다 작습니다.");
        }

        count = price / REFERENCE_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public List<Integer> lastWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return makeCorrectNumber(sc.next());
    }

    private List<Integer> makeCorrectNumber(String text) {
        return Arrays.stream(text.split(","))
                     .map(str -> Integer.parseInt(str))
                     .collect(Collectors.toList());
    }
}
