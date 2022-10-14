package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by seungwoo.song on 2022-10-14
 */
public class LottoNumbers {

    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = IntStream.range(1, MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> get() {
        return lottoNumbers;
    }

    public void shuffle(Consumer<List<Integer>> shuffler) {
        shuffler.accept(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
