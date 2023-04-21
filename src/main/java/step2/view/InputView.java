package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int PRICE_PER_LOTTO = 1000;

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumOfLottoTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validateAmountUnit(purchaseAmount);
        int numOfLotto = purchaseAmount / PRICE_PER_LOTTO;
        System.out.println(numOfLotto + "개를 구매했습니다");
        return purchaseAmount / PRICE_PER_LOTTO;
    }

    private void validateAmountUnit(int purchaseAmount) {
        if (purchaseAmount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("구입금액을 1000원 단위로 입력해주세요.");
        }
    }

    public List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumbers = scanner.next();
        System.out.println();
        return Arrays.stream(winNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
