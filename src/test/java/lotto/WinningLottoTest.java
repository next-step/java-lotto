package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또번호 생성 테스트")
    void createWinningLottoTest() {
        assertThat(
                new WinningLotto("1, 2, 3, 4, 5, 6")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5"})
    @DisplayName("당첨 로또번호 생성 실패(6자리) 테스트")
    void validateSixNumberWinningLottoTest(String input) {
        assertThatThrownBy(
                () -> new WinningLotto(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, a, d, 5, 6", "1, 2, 3, 4, 5, r"})
    @DisplayName("당첨 로또번호 생성 실패(숫자) 테스트")
    void validateNumberWinningLottoTest(String input) {
        assertThatThrownBy(
                () -> new WinningLotto(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("로또번호 맞춘 갯수 가져오기 테스트")
    void getMatchedCountTest() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(45)
        ));

        assertThat(winningLotto.getMatchedCount(lotto)).isEqualTo(5);
    }
}
