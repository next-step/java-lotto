package lotto.ui;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.rank.LottoRank;
import lotto.domain.lotto.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printMatchResult(List<LottoRank> lottoRankList) {
        lottoRankList.stream().forEach(lottoRank -> System.out.println("매칭 : " + lottoRank.getCountOfMatch() + " 금액 : " + lottoRank.getWinningMoney()));

        System.out.println("총 수익률은 입니다.");
    }

    public void printLottoTicketList(List<LottoTicket> lottoTicketList) {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
                .forEach(lottoTicket -> printLottoNumbers(lottoTicket));

        System.out.println();
    }

    private void printLottoNumbers(LottoTicket lottoTicket) {
        List<Integer> collect = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}

