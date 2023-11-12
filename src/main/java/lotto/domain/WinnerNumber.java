package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerNumber {

    private static final String DELIMITER = ",";
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinnerNumber(String lottoNumbers) {
        this.lotto = new Lotto(createLottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> createLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Map<RankLotto, Integer> statisticsResult(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> RankLotto.findRank(lotto.match(this.lotto), lotto.matchBonus(this.bonusNumber)))
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum));
    }

    public Lotto resultLotto() {
        return lotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
