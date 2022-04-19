package lotto.ui;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static int promptPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine(); // 엔터 입력 무시

        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 구매하실 수 있습니다.");
        }

        return purchaseAmount;
    }

    public static Lotto promptWinningLotto() {
        System.out.println("지난 주 당첨 번호를 예시와 같은 형식으로 입력해 주세요. ex)1,2,3,4,5,6");
        String[] stringNumbers = scanner.nextLine()
                .trim()
                .split(",");
        List<Integer> numbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
