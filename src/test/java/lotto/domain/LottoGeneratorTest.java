package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 로또는_6자리_숫자이다() {
        List<Integer> lottoNumbers = LottoGenerator.generate();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또숫자는_중복되지_않는다() {
        Set<Integer> deduplication = Set.copyOf(LottoGenerator.generate());
        assertThat(deduplication.size()).isEqualTo(6);
    }

}
