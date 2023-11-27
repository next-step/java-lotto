package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBERS_DUPLICATION_EXCEPTION;
import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    void validate_lotto_size(Integer[] given) {
        // when // then
        assertThatThrownBy(() -> new Lotto(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_SIZE_EXCEPTION);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments((Object) new Integer[]{1, 2, 3, 4, 5, 6, 7}),
                arguments((Object) new Integer[]{1, 2, 3, 4, 5})
        );
    }

    @Test
    @DisplayName("로또의 숫자에 중복이 없는지 확인한다.")
    void validate_lotto_duplication() {
        // given
        Integer[] lottoNumbers = new Integer[]{1, 2, 3, 4, 5, 5};

        // when // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_DUPLICATION_EXCEPTION);
    }

    @Test
    @DisplayName("로또를 생성한다.")
    void create_lotto() {
        // given
        Integer[] lottoNumbers = new Integer[]{1, 2, 3, 4, 5, 6};

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        // then
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 로또와 자신의 로또를 비교해 몇개가 일치하는지 알려준다.")
    void compare_lotto_with_winner_lotto() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winnerLotto = new Lotto(1, 4, 13, 16, 29, 40);

        // when
        int result = lotto.countOfMatch(winnerLotto);

        // then
        assertThat(result).isEqualTo(2);
    }
}
