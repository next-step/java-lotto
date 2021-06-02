package study.ascii92der.lotto.step3n4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoTest {

    @Test
    @DisplayName("6개의 로또 숫자와 보너스 숫자 1개를 이용한 WinningLotto 객체 생성 확인")
    void create() {
        assertThat(
                new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7))
        ).isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("로또와 동일한 valid check")
    void validWinningLotto() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5)), new LottoNumber(7)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Lotto.ERROR_MASSAGE_WRONG_NUMBER_COUNT),
                () -> assertThatThrownBy(() ->
                        new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 4)), new LottoNumber(7)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Lotto.ERROR_MASSAGE_DUPLICATE_NUMBER)
        );

    }

    @Test
    @DisplayName("보너스 숫자가 1-45 범위 내, 기존 로또 번호와 중복되지 않는지 확인")
    void validBonus() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(1)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WinningLotto.ERROR_MASSAGE_DUPLICATE_NUMBER_WITH_WINNING_LOTTO),
                () -> assertThatThrownBy(() ->
                        new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(-1)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(LottoNumber.ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER)
        );
    }

    @Test
    @DisplayName("당첨 번호와 로또의 맞는 숫자 갯수 확인")
    void match() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.match(lotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("보너스 숫자가 로또 번호 중 있는지 확인")
    void matchBonus() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.isMatchedBonus(lotto)).isTrue();
    }
}