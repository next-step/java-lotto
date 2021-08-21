package step3.view;

import step3.util.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final Double chargeOfLotto = 1000.0;

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

    public void printNumOfLotto(int numOfLotto, int numOfManualPurchaseLotto) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.\n", numOfManualPurchaseLotto, numOfLotto);
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
