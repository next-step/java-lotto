package step3.domain.lotto;

import java.util.List;

public class UserLotto {

    private final List<LottoNumber> lottoNumbers;

    public UserLotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static UserLotto from(List<LottoNumber> lottoNumbers) {
        return new UserLotto(lottoNumbers);
    }

    public LottoResult match(WinningLotto winningLotto, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        this.lottoNumbers.stream().forEach(lottoNumber -> {
            boolean hasBonusNumber = lottoNumber.hasBonusNumber(bonusNumber);
            int countOfMatch = winningLotto.findCountOfMatch(lottoNumber);
            lottoResult.increaseCount(Rank.findRank(countOfMatch, hasBonusNumber));
        });
        return lottoResult;
    }
}
