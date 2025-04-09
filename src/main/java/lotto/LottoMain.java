package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoRound;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        LottoMain.lotto();
    }

    public static void lotto() {
        int budget = InputView.getPositiveNumberInputWithLowBound("구입금액을 입력해 주세요.");
        int slipsCount = InputView.getPositiveNumberInput("수동으로 구매할 로또 수를 입력해 주세요.");

        List<Set<Integer>> slipsLottoNumbers = InputView.getPositiveNumberSetInput("수동으로 구매할 번호를 입력해 주세요.", ",", slipsCount);

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(LottoStore.sellLotto(slipsLottoNumbers));
        lottoNumbers.addAll(LottoStore.sellLotto(budget));

        for (LottoNumbers lottoNumber : lottoNumbers) {
            ResultView.printLottoNumber(lottoNumber);
        }

        Set<Integer> winningNumbers = InputView.getPositiveNumberSetInput("지난 주 당첨 번호를 입력해 주세요.", ",");
        int bonusNumber = InputView.getLottoNumberInput("보너스 볼을 입력해 주세요.");
        LottoRound lottoRound = new LottoRound(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoRound.checkLottoRank(lottoNumbers);
        double rateOfReturn = lottoResult.rateOfReturn();
        ResultView.printStat(rateOfReturn, lottoResult);
    }
}
