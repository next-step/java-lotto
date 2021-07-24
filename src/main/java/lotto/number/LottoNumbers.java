package lotto.number;

import lotto.prize.MatchInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    protected final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = new HashSet<>(lottoNumbers);

        checkDuplication();
    }

    private void checkDuplication() {
        if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("Lotto numbers duplicated");
        }
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("Input lotto numbers are null");
        }

        if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(
                    "Number of lotto numbers is " + lottoNumbers.size() + " number must equal to " + NUMBER_OF_LOTTO_NUMBERS
            );
        }
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    protected boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber::equals);
    }

    public List<Integer> toInts() {
        return lottoNumbers.stream()
                .map(LottoNumber::toInt)
                .collect(Collectors.toList());
    }
}
