package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private Map<Prize, Integer> dummy;

    @BeforeEach
    void setUp() {
        dummy = new HashMap<>();
        dummy.put(FIRST, 1);
        dummy.put(SECOND, 1);
        dummy.put(THIRD, 1);
        dummy.put(FOURTH, 1);
        dummy.put(FIFTH, 1);
        dummy.put(NONE, 5);
    }

    @Test
    void create() {
        // given
        LottoResult self = new LottoResult(dummy);

        // when
        LottoResult other = new LottoResult(dummy);

        // then
        assertThat(self).isEqualTo(other);
    }

    @ParameterizedTest
    @MethodSource("countByPrizeSource")
    @DisplayName("LottoResult 는 임의의 Prize 에 협력하여 matchCount 를 반환할 수 있다.")
    void countByPrize(Prize prize, int count) {
        // given
        LottoResult self = new LottoResult(dummy);

        // then
        assertThat(self.countByPrize(prize)).isEqualTo(count);
    }

    static Stream<Arguments> countByPrizeSource() {
        return Stream.of(
                Arguments.of(FIRST, 1),
                Arguments.of(SECOND, 1),
                Arguments.of(THIRD, 1),
                Arguments.of(FOURTH, 1),
                Arguments.of(FIFTH, 1),
                Arguments.of(NONE, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("rateSource")
    @DisplayName("LottoResult 는 Money(unitPrice) 와 협력하여 수익률을 구할 수 있다.")
    void rate(int money, double result) {
        // given
        LottoResult self = new LottoResult(dummy);

        // when
        Money unitPrice = new Money(money);

        // then
        assertThat(self.rate(unitPrice)).isEqualTo(result);
    }

    static Stream<Arguments> rateSource() {
        return Stream.of(
                Arguments.of(1000, 203155.5)
        );
    }
}
