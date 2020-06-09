package step2.view;

import step2.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    public int getLottoAmount(int purchaseAmount) {
        int lottoAmount = calcLottoAmount(purchaseAmount);
        System.out.println(lottoAmount + "개를 구매했습니다.");
        return lottoAmount;
    }


    private int calcLottoAmount(int purchaseAmount) {
        if (purchaseAmount < 1000)
            throw new IllegalArgumentException("최소 구매금액은 " + Constants.LOTTO_PRICE + "원 입니다");
        return purchaseAmount / Constants.LOTTO_PRICE;
    }

    public List<String> getWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        return splitWinningNumber(scanner.nextLine().replace(" ", ""));
    }

    private List<String> splitWinningNumber(String input) {
        String[] splitStrArr = input.split(",");
        if (splitStrArr.length != 6)
            throw new IllegalArgumentException("당첨번호는 6개 이어야 합니다.");

        return Arrays.asList(splitStrArr);
    }
}
