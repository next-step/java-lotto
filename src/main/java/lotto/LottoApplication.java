package lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int totalPrice = InputView.inputTotalPrice();
        System.out.println(totalPrice/1000 + "개를 구매했습니다.");
        List<LottoNumber> lastResultNumber = InputView.inputLottoNumberLastResult();
    }
}
