package lotto.domain;

import lotto.LottoConfig;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> lotto;

    public Lotto() {
        lotto = IntStream.rangeClosed(LottoConfig.LOTTO_START_NUMBER, LottoConfig.LOTTO_LAST_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lotto);

        lotto = lotto.stream().limit(LottoConfig.LOTTO_SIZE)
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Lotto(List<Integer> lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_NULL_MESSAGE);
        }
        validateLottoSize(lotto);
        validateLottoNumber(lotto);
        this.lotto = lotto.stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    private void validateLottoSize(List<Integer> lotto) {
        if (new HashSet<>(lotto).size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateLottoNumber(List<Integer> lotto) {
        boolean impossibleLottoNumber = lotto.stream()
                .anyMatch((number) -> (number < LottoConfig.LOTTO_START_NUMBER || number > LottoConfig.LOTTO_LAST_NUMBER));

        if (impossibleLottoNumber) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean containNumber(int number) {
        return lotto.contains(number);
    }

    public int sameLottoNumberCount(Lotto winningLottery) {
        return (int) lotto.stream()
                .filter(number -> winningLottery.containNumber(number))
                .count();
    }
}
