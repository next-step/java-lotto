package step3.view;

import step3.domain.LottoTicket;
import step3.domain.LottoTickets;

import java.util.List;

public class ResultView {
    public static void view(LottoTickets lottoTickets) {
        StringBuilder sb = new StringBuilder();
        for(LottoTicket lotto : lottoTickets.getLottoTicket()) {
            sb.append(lotto.getLottoNumbers() + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void result(float revenue, int[] result) {
        System.out.println("\n당첨 통계");
        System.out.println("------------");
        System.out.println("3개 일치 (5000원) - " + result[1] + "개");
        System.out.println("4개 일치 (50000원) - " + result[2] + "개");
        System.out.println("5개 일치 (1500000원) - " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000) - " + result[4] + "개");
        System.out.println("6개 일치 (20000000000원) - " + result[5] + "개");
        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미)");
    }
}
