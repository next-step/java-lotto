package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.validate.NumberValidation.checkBonusNumber;

public class WinnerNumber {

    private Lotto winLotto;
    private LottoNumber bonusNumber;

    public WinnerNumber(String lottoNumbers) {
        this.winLotto = new Lotto(lottoNumbers);
    }

    public WinnerNumber(String lottoNumbers, int bonusNumber) {
        this.winLotto = new Lotto(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        checkBonusNumber(this.winLotto, this.bonusNumber);
    }

    public Map<RankLotto, Integer> statisticsResult(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> RankLotto.findRank(lotto.match(this.winLotto), lotto.matchNumber(this.bonusNumber)))
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum));
    }

    public Lotto resultLotto() {
        return winLotto;
    }
}
