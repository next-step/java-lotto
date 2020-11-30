package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.Set;

public class LottoNumber {

    private static final int LOTTO_FIX_SIZE = 6;
    private Set<Integer> lottoNumbers;

    private LottoNumber(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumber from(Set<Integer> lottoNumbers) {
        if (!isValidLottoNumber(lottoNumbers)) {
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
        return new LottoNumber(lottoNumbers);
    }

    private static boolean isValidLottoNumber(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_FIX_SIZE && !isValidRange(lottoNumbers);
    }

    private static boolean isValidRange(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                    .anyMatch(number ->  number < ProviderLottoNumbers.MIN_LOTTO_NUMBER
                                        || number > ProviderLottoNumbers.MAX_LOTTO_NUMBER );
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
