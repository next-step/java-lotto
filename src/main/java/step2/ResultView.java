package step2;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView(){

    }

    public void printPurchaseNumber(PurchaseManager manager) {
        System.out.println(manager.getPurchasedLottoNumber().getNumber()+"개 구매했습니다.");
    }

    public void printLottoList(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()){
            printLotto(lotto);
            System.out.println();
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.print("[");
        String result = lotto.getLottoNumberList()
                .stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
        System.out.print(result);
        System.out.print("]");
    }

    public void printLottoStatistic(Lottos lottos, WinningLotto winningLotto) {
        Rank ranking = lottos.makeStatistic(winningLotto);
        System.out.println("당첨통계");
        System.out.println("------");
        for(int rank = 3; rank <= 6;rank++){
            HitCount hitCount = new HitCount(rank);
            System.out.println(String.format("%d개 일치 (%d)원 - %d개",
                    rank,LottoPrize.getPrizeInfoByHitCount(hitCount).prize(),ranking.size(hitCount)));
        }
    }
}
