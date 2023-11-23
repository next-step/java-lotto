package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBERS_DUPLICATION_EXCEPTION;
import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("로또의 숫자 갯수가 6개인지 확인한다.")
    @MethodSource("parametersProvider")
    void validate_lotto_size(List<Integer> given) {
        // when // then
        assertThatThrownBy(() -> new Lotto(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_EXCEPTION);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                arguments(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @Test
    @DisplayName("로또의 숫자에 중복이 없는지 확인한다.")
    void validate_lotto_duplication() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_DUPLICATION_EXCEPTION);
    }

    @Test
    @DisplayName("로또를 생성한다.")
    void create_lotto() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        // then
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }
}
