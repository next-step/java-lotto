package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_BOUND = 45;

    @Test
    public void 로또생성기() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int bound = 1; bound <= LOTTO_NUMBER_BOUND; bound++) {
            numbers.add(bound);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_NUMBER_COUNT);

        Collections.sort(numbers);
        assertThat(numbers).hasSize(6);
    }

    @Test
    public void 로또생성기_메소드() {
        ILottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createLottoNumbers()).hasSize(6);

        lottoGenerator = new LottoGeneratorFixture();
        assertThat(lottoGenerator.createLottoNumbers()).hasSize(6);
        assertThat(lottoGenerator.createLottoNumbers().stream().max(Comparator.comparing(Integer::valueOf)).get()).isEqualTo(6);
    }
}