package step2;

import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public LottoBuyRequest buyLotto() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        int lottoCount = getLottoCnt(amount);
        System.out.println(lottoCount + "를 구매하였습니다.");
        return new LottoBuyRequest(amount, lottoCount);
    }

    public int getLottoCnt(int amount) {
        amountValidate(amount);
        return amount / LOTTO_PRICE;
    }

    public void amountValidate(int amount) {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("금액은 천원 단위로 입력해주세요");
        }
    }
}
