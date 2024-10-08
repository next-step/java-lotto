package step2;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;

public class LottoMain {

    public static void main(String[] args) {
        // 로또 구입
        InputView inputView = new InputView();
        int cashAmount = inputView.getCashAmount();
        int purchaseCount = cashAmount / 1000;
        inputView.printPurchaseCount(purchaseCount);

        // 로또 생성
        List<Lotto> lottoList = LottoMachine.getInstance().create(purchaseCount);

        // 로또 출력
        ResultView resultView = new ResultView();
        resultView.printLottoNumbers(lottoList);

        // 과거 당첨 번호 입력
        Set<Integer> winningNumbers = inputView.getWinningNumbers();

        // 당첨 확인
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int count = LottoMachine.getInstance().match(lotto, winningNumbers);
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        }

        // 결과 출력
        String profitRate = LottoMachine.getInstance().calculateProfitRate(countMap, cashAmount);
        resultView.printResult(countMap, cashAmount, profitRate);
    }

}
