package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int CAPACITY = 6;
    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers.stream()
                                .map(i -> LottoNumber.from(i))
                                .collect(Collectors.toSet());
    }

    public static Lotto of(Set<Integer> lottoNumbers) {
        if(lottoNumbers.size() != CAPACITY){
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
        return new Lotto(lottoNumbers);
    }

    public static Lotto createLottoNumber(LottoMachine machine){
       return machine.createLotto(CAPACITY);
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(prizeLotto::matchLottoNumber)
                .count();
        boolean isBonusball = matchBonusball(prizeLotto);
        return PrizeInformation.findByMatchStatus(MatchStatus.of(matchCount, isBonusball));
    }

    private boolean matchBonusball(PrizeLotto prizeLotto) {
        return lottoNumbers
                .stream()
                .anyMatch(prizeLotto::matchBonusBall);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}