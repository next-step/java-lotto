package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또를 생성하면 번호가 6개인 로또가 생성된다")
    @Test
    void create() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        int lottoSize = lotto.getLotto().size();

        // then
        assertThat(lottoSize).isEqualTo(Lotto.NUMBER_SIZE);
    }

    @DisplayName("당첨 번호 6자리를 입력하면 로또가 생성된다")
    @Test
    void create_winner_lotto() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        Set<Integer> winnerLottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Lotto winnerLotto = Lotto.from(winnerLottoNumbers);

        // then
        assertThat(lotto).isEqualTo(winnerLotto);
    }

    @DisplayName("중복된 숫자 6자리를 입력하면 예외가 발생한다")
    @Test
    void check_numbers_size_exception() {
        assertThatThrownBy(() -> Lotto.from(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복되지 않은 6자리 이어야 합니다.");
    }
}
