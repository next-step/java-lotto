package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.LottoGenerator.LOTTO_FIRST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_LAST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;

import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomGenerableStrategyTest {

    RandomGenerableStrategy randomGenerableStrategy;

    @BeforeEach
    void before() {
        this.randomGenerableStrategy = new RandomGenerableStrategy();
    }

    @Test
    void generate() {
        //given&when
        UserLotto generatedNumbers = new UserLotto(
            randomGenerableStrategy
                .generate(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER, LOTTO_SELECTION_COUNT));

        //then
        assertThat(generatedNumbers.getLottoNumbers()).hasSize(6);
        assertThat(generatedNumbers.getLottoNumbers())
            .hasSizeBetween(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);
        assertThat(generatedNumbers.getLottoNumbers()).isSortedAccordingTo(
            Comparator.comparingInt(LottoNumber::getNumber));
    }
}