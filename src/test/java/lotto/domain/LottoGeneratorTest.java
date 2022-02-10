package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.strategy.RandomGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    @DisplayName(value = "로또 램덤 전략으로 인스턴스 생성시, 1에서 45 사이에 숫자들로 구성된다.")
    @Test
    void GivenRandomGenerateStrategy_WhenCreateInstance_ThenLottoRangeBetween1And45(
    ) {
        Lotto lotto = LottoGenerator.of(RandomGenerateStrategy.getInstance()).getLotto();

        boolean isAllMatch = lotto.getLotto().stream()
            .allMatch(x -> IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList())
                .contains(x)
            );

        assertThat(isAllMatch)
            .isEqualTo(true);
    }
}