package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.validate.NumberValidation.checkBonusNumber;

public class WinnerNumber {

    private static final String DELIMITER = ",";
    private Lotto winLotto;
    private LottoNumber bonusNumber;

    public WinnerNumber(String lottoNumbers) {
        this.winLotto = new Lotto(createLottoNumbers(lottoNumbers));
    }

    public WinnerNumber(String lottoNumbers, int bonusNumber) {
        this.winLotto = new Lotto(createLottoNumbers(lottoNumbers));
        this.bonusNumber = new LottoNumber(bonusNumber);
        checkBonusNumber(this.winLotto, this.bonusNumber);
    }

    private List<LottoNumber> createLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
