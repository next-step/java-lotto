package view;

import domain.LottoResultResponse;
import enums.Rank;
import java.util.List;

public class ResultView {

    public void result(LottoResultResponse lottoResultResponse){
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Rank> ranks = lottoResultResponse.getRanks();
        System.out.println("3개 일치 (5000원)- "+ getCount(ranks, Rank.FIVE_PLACE));
        System.out.println("4개 일치 (50000원)- "+getCount(ranks, Rank.FOUR_PLACE));
        System.out.println("5개 일치 (1500000)- "+getCount(ranks, Rank.THIRD_PLACE));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - "+getCount(ranks, Rank.SECOND_PLACE));
        System.out.println("6개 일치 (2000000000원)- "+getCount(ranks, Rank.FIRST_PLACE));
        System.out.println("총 수익률은"+ String.format("%.2f", lottoResultResponse.getYield()));
    }

    private long getCount(List<Rank> ranks, Rank domain) {
        return ranks.stream().filter(rank-> rank == domain).count();
    }
}
