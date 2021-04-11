package step4.domain;


import step4.exception.IllegalLottoBonusNumberException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoWinnerNumber {
    private final LottoNumber lottoBonusNumber;
    private final Lotto lottoWinnerNumbers;

    public LottoWinnerNumber(int lottoBonusNumber, String lottoNumbers) {
        this.lottoWinnerNumbers = Lotto.of(lottoNumbers);
        lottoBonusNumberDuplicateCheck(lottoBonusNumber);
        this.lottoBonusNumber = LottoNumber.valueOf(lottoBonusNumber);
    }

    private void lottoBonusNumberDuplicateCheck(int lottoBonusNumber) {
        if (lottoWinnerNumbers.isContains(LottoNumber.valueOf(lottoBonusNumber))) {
            throw new IllegalLottoBonusNumberException("로또 당첨번호와 일치합니다.");
        }
    }

    public LottoNumber getLottoBonusNumber() {
        return lottoBonusNumber;
    }

    public Map<Rank, Long> getMatchResults(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> {
                    boolean matchBonus = lotto.isContains(lottoBonusNumber);
                    int countOfMatch = lotto.matchNumberCounts(lottoWinnerNumbers);
                    return Rank.valueOf(countOfMatch, matchBonus);})
                .filter(rank -> rank != Rank.MISS)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
