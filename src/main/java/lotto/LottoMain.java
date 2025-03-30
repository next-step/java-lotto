package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        LottoMain.lotto();
    }

    public static void lotto() {
        int budget = InputView.getPositiveNumberInput("구입금액을 입력해 주세요.");

        List<LottoNumbers> lottoNumbers = LottoStore.sellLotto(budget);
        for (LottoNumbers lottoNumber : lottoNumbers) {
            ResultView.printLottoNumber(lottoNumber);
        }

        Set<Integer> winningNumbers = InputView.getPositiveNumberSetInput("지난 주 당첨 번호를 입력해 주세요.", ",", LottoNumbersCondition.getDefaultInstance().getLottoNumberSize());
        LottoRound lottoRound = new LottoRound(winningNumbers);

        Map<LottoRank, Integer> lottoRankToCountMap = lottoRound.checkLottoRank(lottoNumbers);
        double rateOfReturn = (double) LottoStore.receiveWinnings(lottoRankToCountMap) / (budget * LottoStore.LOTTO_PRICE);
        ResultView.printStat(rateOfReturn, lottoRankToCountMap);
    }
}
