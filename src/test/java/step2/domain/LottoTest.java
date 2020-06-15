package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.Constants;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 테스트")
class LottoTest {
    private Lotto lotto = new Lotto();

    @BeforeEach
    void generateNumber() {
        lotto.generateNumber(new TestLottoGeneratorStrategy(Constants.INIT_LOTTO_GENERATOR_STRATEGY_NUMBER));
    }

    @DisplayName("당첨번호와 일치하는 번호 갯수")
    @ParameterizedTest
    @MethodSource("winningNumbersProvider")
    void getMatchCount(Optional<WinningNumbers> winningNumbers, int expectMatchCount) {
        assertThat(lotto.getMatchCount(winningNumbers)).isEqualTo(expectMatchCount);
    }

    @DisplayName("당첨번호와 일치하는 번호 갯수")
    @Test
    void winninNumbersIsNull() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> lotto.getMatchCount(Optional.empty()))
                .withMessageContaining("당첨번호가 필요합니다.");
    }

    private static Stream<Arguments> winningNumbersProvider() {
        return Stream.of(
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), 6),
                Arguments.of(Optional.of(new WinningNumbers(Arrays.asList(4, 21, 22, 23, 24, 25))), 1));
    }
}
