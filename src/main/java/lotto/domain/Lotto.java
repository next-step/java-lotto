package lotto.domain;

import lotto.LottoConfig;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_NULL_MESSAGE);
        }
        validateLottoNumbers(lottoNumbers);
        this.lotto = lottoNumbers.stream()
                .map(number -> new LottoNumber(number))
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Integer> getValue() {
        return lotto.stream()
                .mapToInt(LottoNumber::getLottoNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean containNumber(LottoNumber number) {
        return lotto.contains(number);
    }

    public int sameLottoNumberCount(Lotto winningLottery) {
        return (int) lotto.stream()
                .filter(number -> winningLottery.containNumber(number))
                .count();
    }
}
