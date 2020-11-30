package lotto.domain;

import java.util.Set;

public class LottoNumber {

    private Set<Integer> lottoNumbers;

    private LottoNumber(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumber from(Set<Integer> lottoNumbers) {
        ProviderLottoNumbers.isValidLottoNumber(lottoNumbers);
        return new LottoNumber(lottoNumbers);
    }

    public Set<Integer> getLottoNumber() {
        return lottoNumbers;
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoNumbers.stream()
                .filter(prizeLotto::existByLottoNumber)
                .count();
        boolean isBonusball = matchBonusball(prizeLotto);
        return PrizeInformation.findByPrizePrice(MatchStatus.of(prizeCount, isBonusball));
    }

    private boolean matchBonusball(PrizeLotto prizeLotto) {
        return lottoNumbers
                .stream()
                .anyMatch(prizeLotto::matchBonusBall);
    }

    public int size() {
        return lottoNumbers.size();
    }
}
