package view;

import domain.LottoResultResponse;
import enums.Rank;
import java.util.List;

public class ResultView {

    public ResultView(LottoResultResponse lottoResultResponse){
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Rank> ranks = lottoResultResponse.getRanks();
        System.out.println("3개 일치 (5000원)- "+ranks.stream().filter(rank-> rank == Rank.THIRD_PLACE).count());
        System.out.println("4개 일치 (50000원)- "+ranks.stream().filter(rank-> rank == Rank.FOUR_PLACE).count());
        System.out.println("5개 일치 (1500000)- "+ranks.stream().filter(rank-> rank == Rank.SECOND_PLACE).count());
        System.out.println("6개 일치 (2000000000원)- "+ranks.stream().filter(rank-> rank == Rank.FIRST_PLACE).count());
        System.out.println("총 수익률은"+ lottoResultResponse.getYield());
    }


}
