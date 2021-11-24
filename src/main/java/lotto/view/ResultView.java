package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class ResultView {

    public static void printOrderCount(int orderCount) {
        System.out.println(orderCount + "개를 구매했습니다");
    }

    public static void printOrderLottoNumber(LottoTicket lottoTicket) {
        lottoTicket.getLotto().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }
}
