package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class ResultView {

    public static void printTicket(List<LottoNumbers> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.stream().forEach(System.out::println);
    }


}
