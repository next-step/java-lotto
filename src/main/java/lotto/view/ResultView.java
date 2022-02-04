package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoGenerator;

public class ResultView {

    private static int quantity;

    public static void printLottoQuantity(int purchasePrice) {
        quantity = LottoGenerator.getLottoQuantity(purchasePrice);
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printTotalLottoNumbers() {
        List<Lotto> lottoNumbers = LottoGenerator.getTotalLottoNumbers(quantity);
        lottoNumbers.forEach(e -> System.out.println(e.getNumbers()));
    }
}
