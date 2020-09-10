package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.ArrayList;

public class ResultView {

    public static void viewPurchaseLottoCount(int purchaseLottoCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(purchaseLottoCount).append("개를 구매하였습니다.");
        System.out.println(sb.toString());
    }

    public static void viewLottoNumber(Lottos lottos) {
        lottos.lottos.stream().forEach(lotto -> {
            System.out.println(lotto.getLottoNums().toString());
        });
    }

    public static void viewLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("------------");
        ArrayList<Integer> placeCntList = lottoResult.getPlaceCnt();
        viewLottoPlace(Rank.FourthPlace, placeCntList.get(3));
        viewLottoPlace(Rank.ThirdPlace, placeCntList.get(2));
        viewLottoPlace(Rank.SecondPlace, placeCntList.get(1));
        viewLottoPlace(Rank.FirstPlace, placeCntList.get(0));

        StringBuilder sb = new StringBuilder();

        sb.append("총 수익률은 ").append(lottoResult.getProfitPercent()).append("입니다.");
        System.out.println(sb.toString());
       
    }
    private static void viewLottoPlace(Rank rank, Integer cnt) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount()).append("개 일치").append(" (").append(rank.getWinnings()).append(")-").append(cnt).append("개");
        System.out.println(sb.toString());
        
    }
}
