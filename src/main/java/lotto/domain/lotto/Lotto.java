package lotto.domain.lotto;

import lotto.constants.Winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_COUNT = 6;

    private static final String NUMBER_COUNT_ERROR_MESSAGE = String.format("로또 번호는 총 %s자리 입니다", NUMBER_COUNT);

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(validate(lottoNumbers));
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(Integer... lottoNumbers) {
        return new Lotto(Arrays.asList(lottoNumbers));
    }

    private List<LottoNumber> validate(List<Integer> lottoNumbers) {
        validateCount(lottoNumbers);
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private void validateCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    public Winning match(Lotto jackpot, LottoNumber bonusNumber) {
        return Winning.of(match(jackpot), bonusMatch(bonusNumber));
    }

    public long match(Lotto jackpot) {
        return jackpot.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean bonusMatch(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
