package step3.view;

import step3.util.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final Double chargeOfLotto = 1000.0;
    public void printMatchedLottoRecord(Map<Rank, Integer> matchedLottoRecordArray) {

        System.out.println("당첨 통계");
        System.out.println("-------");
        System.out.printf("%s개 일치 (%s)- %s개\n",Rank.FIFTH.getCountOfMatch(),Rank.FIFTH.getWinningMoney(),matchedLottoRecordArray.get(Rank.FIFTH));
        System.out.printf("%s개 일치 (%s)- %s개\n",Rank.FOURTH.getCountOfMatch(),Rank.FOURTH.getWinningMoney(),matchedLottoRecordArray.get(Rank.FOURTH));
        System.out.printf("%s개 일치 (%s)- %s개\n",Rank.THIRD.getCountOfMatch(),Rank.THIRD.getWinningMoney(),matchedLottoRecordArray.get(Rank.THIRD));
        System.out.printf("%s개 일치 (%s)- %s개\n",Rank.SECOND.getCountOfMatch(),Rank.SECOND.getWinningMoney(),matchedLottoRecordArray.get(Rank.SECOND));
        System.out.printf("%s개 일치 (%s)- %s개\n",Rank.FIRST.getCountOfMatch(),Rank.FIRST.getWinningMoney(),matchedLottoRecordArray.get(Rank.FIRST));
    }

    private void printResultMessage(double yield) {
        if (yield < 1) {
            System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",yield);
            return;
        }
        if (yield >= 1) {
            System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)",yield);
            return;
        }

    }

    public void printIssuedLottoList(List<List<Integer>> issuedLottolist) {
        issuedLottolist.stream()
                .forEach(issuedLotto -> System.out.println(issuedLotto));
    }

    public void printResultPrice(int resultPrice, int numOfLotto) {
        Double totalSpendMoney = numOfLotto * chargeOfLotto;
        Double yeild = resultPrice / totalSpendMoney;
        printResultMessage(yeild);
    }
}
