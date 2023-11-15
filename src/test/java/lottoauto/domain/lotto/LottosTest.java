package lottoauto.domain.lotto;

import lottoauto.domain.WinnerBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    @DisplayName("일치하는 당첨 로또들을 일치 수에 맞도록 winnerBoard 에 추가합니다.")
    void checkLotto() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        // when
        WinnerBoard winnerBoard = lottos.checkWinnerLotto("1, 2, 3, 7, 8, 9");
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(Map.of(
                3, 1L,
                4, 0L,
                5, 0L,
                6, 0L
        )));
    }

    @Test
    @DisplayName("우승 로또가 없다면 winnerBoard 의 우승 로또 수는 모두 0이 됩니다.")
    void zeroWinningLotto() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        WinnerBoard winnerBoard = lottos.checkWinnerLotto("11, 12, 13, 14, 15, 16");
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(Map.of(
                3, 0L,
                4, 0L,
                5, 0L,
                6, 0L
        )));
    }

    @Test
    @DisplayName("당첨 로또 번호를 6개로 입력하지 않은 경우 에러가 발생합니다.")
    void invalidNumber1() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        // when
        // then
        assertThatThrownBy(() -> lottos.checkWinnerLotto("1, 2, 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 반드시 6개여야 합니다.");

    }

    @Test
    @DisplayName("당첨 로또 번호에 중복이 있으며 6개가 아니면 에러가 발생합니다.")
    void invalidNumber2() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        // when
        // then
        assertThatThrownBy(() -> lottos.checkWinnerLotto("1, 2, 3, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 반드시 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 로또 번호는 중복되면 안됩니다.")
    void duplicateNumber() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        // when
        // then
        assertThatThrownBy(() -> lottos.checkWinnerLotto("1, 2, 3, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복 없이 6개의 숫자여야 합니다.");

    }
}