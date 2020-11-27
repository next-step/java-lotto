package lotto.domain;

import java.util.Set;

public class Lotto {

    private LottoNumber lottoNumbers;

    public Lotto(LottoNumber lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoNumbers.getLottoNumber().stream()
                .filter(prizeLotto::existByIndexNumber)
                .count();
        boolean isBonusball = matchBonusball(prizeLotto);
        return PrizeInformation.findByPrizePrice(new MatchStatus(prizeCount, isBonusball));
    }

    private boolean matchBonusball(PrizeLotto prizeLotto) {
        return lottoNumbers.getLottoNumber().stream().anyMatch(prizeLotto::matchBonusBall);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumber();
    }

    public int sizeLottoNumber() {
        return lottoNumbers.getLottoNumber().size();
    }
}