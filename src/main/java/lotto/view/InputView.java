package lotto.view;

import lotto.Lotto;

public class InputView {
    private InputView() {
    }

    public static void printPurchaseRequest() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구입했습니다.");
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.lottoNumbers());
    }
}
