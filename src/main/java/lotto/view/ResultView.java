package lotto.view;

import lotto.domain.item.LottoTicket;

import java.util.List;

public class ResultView {

    public static void printLoots(List<LottoTicket> lottos) {
        System.out.println(lottos.size() + "개를 구매 했습니다.");
        for (LottoTicket lotto: lottos){
            System.out.println(lotto);
        }
    }
}
