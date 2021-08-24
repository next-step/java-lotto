package UI;

import Lotto.Number.LottoNumber;
import Lotto.Ticket.LottoTicket;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResultView {

    public static void showTotalNumberOfPurchasedLottoTickets(int totalNumber) {
        System.out.println(totalNumber + "개를 구매했습니다.");
    }

    public static void showLottoNumbersOfEachTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(showLottoNumbers());
    }

    // TODO: 생각해보기 (List<Integer>를 로또 티켓에서 바로 반환하는 것은 안될까?
    private static Consumer<LottoTicket> showLottoNumbers() {
        return lottoTicket -> System.out.println(lottoTicket.getValue().stream().mapToInt(LottoNumber::getValue).boxed().collect(Collectors.toList()));
    }

    public static void showGameResult() {
        System.out.println("당첨 통계\n---------");
        // TODO: 아래 내용 프린트할 객체 만들기
        /*3개 일치 (5000원)- 1개
            4개 일치 (50000원)- 0개
            5개 일치 (1500000원)- 0개
            6개 일치 (2000000000원)- 0개
            총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)*/
    }
}
