package lotto;

import java.util.List;

public class ResultView {

    public void lottoSizeResultView(int manualLottos, int lottoNums) {
        System.out.println("수동으로 " + manualLottos + "장, " + "자동으로" + lottoNums + "개를 구매했습니다.");
    }

    public void lottoNumbersView(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void reportView(LottoResult lottoResult) {
        statisticsView(lottoResult.matchRank(Rank.FIFTH),
                lottoResult.matchRank(Rank.FOURTH),
                lottoResult.matchRank(Rank.THIRD),
                lottoResult.matchRank(Rank.SECOND),
                lottoResult.matchRank(Rank.FIRST));
        rateOfReturnView(lottoResult.calculateRateOfReturn());
    }


    private void rateOfReturnView(String rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn +"입니다.");
    }

    private void statisticsView(long fifth, long fourth,long third, long second, long first) {
        String sb = String.format("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개\n", fifth, fourth, third, second, first);
        System.out.println(sb);
    }

}
