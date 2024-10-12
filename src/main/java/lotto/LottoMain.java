package lotto;

import lotto.constant.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;


public class LottoMain {

    public static void main(String[] args) {
        // 로또 구입
        InputView inputView = new InputView();
        LottoMachine machine = LottoMachine.of(inputView.getCashAmount());
        inputView.printPurchaseCount(machine.calculatePurchaseCount());

        // 로또 생성
        List<Lotto> lottoList = machine.createAutomatically();

        // 로또 출력
        ResultView resultView = new ResultView();
        resultView.printLottoNumbers(lottoList);

        // 과거 당첨 번호 입력
        Set<Integer> winningNumbers = inputView.getWinningNumbers();

        // 당첨 확인
        EnumMap<Prize, Integer> countMap = machine.checkLottoPrize(lottoList, winningNumbers);

        // 결과 출력
        String profitRate = machine.calculateProfitRate(countMap, 2);
        resultView.printResult(countMap, profitRate);
    }

}
