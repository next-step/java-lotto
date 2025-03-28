package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.LottoConfig.LOTTO_NUMBER_SIZE;

public class Lotto {
    public static void main(String[] args) {
        Lotto.lotto();
    }

    public static void lotto() {
        int lottoCount = InputView.getPositiveNumberInput("구입금액을 입력해 주세요.") / 1000;

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumber lottoNumber = LottoMachine.generateLottoNumber();
            lottoNumbers.add(lottoNumber);
            ResultView.printLottoNumber(lottoNumber);
        }

        Set<Integer> winningNumbers = InputView.getPositiveNumberSetInput("지난 주 당첨 번호를 입력해 주세요.", ",", LOTTO_NUMBER_SIZE);
        LottoRound lottoRound = new LottoRound(winningNumbers);

        ResultView.printStat(lottoCount, lottoRound.checkLottoRank(lottoNumbers));
    }
}
