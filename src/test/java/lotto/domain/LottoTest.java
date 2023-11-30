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
    @DisplayName("당첨 로또와 보너스 숫자로 등수를 찾는다.")
    void find_rank_by_winner_lotto() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(1, 4, 6, 16, 29, 40), LottoNumber.valueOf(7));

        // when
        Rank rank = winnerLotto.findRankOf(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
}
