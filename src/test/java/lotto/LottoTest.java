package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @DisplayName("보너스볼이 로또안에 있으면 true를 반환한다")
    @Test
    void 로또_보너스볼_중복_O() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lotto.hasLottoNumber(lottoNumber)).isTrue();
    }

    @DisplayName("보너스볼이 로또안에 있으면 false를 반환한다")
    @Test
    void 로또_보너스볼_중복_X() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(10);

        assertThat(lotto.hasLottoNumber(lottoNumber)).isFalse();
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_개수() {
        List<Integer> values = List.of(1, 2, 3, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values))
            .withMessage("로또 번호는 6개여야합니다. 현재 개수 : 4개");
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_중복() {
        List<Integer> values = List.of(1, 2, 3, 5, 5, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values))
            .withMessage("로또 번호는 중복되지 않아야합니다");
    }

    @DisplayName("로또객체가 정상적으로 생성된다")
    @Test
    void 로또_객체_생성_성공() {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException()
            .isThrownBy(() -> new Lotto(values));
    }

    @DisplayName("일치하는 숫자를 카운트 한다")
    @Test
    void 로또_일치_카운트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winingValue = List.of(5, 1, 10, 45, 2, 29);

        WinningNumber winningNumber = new WinningNumber(winingValue, 30);

        assertThat(lotto.countMatch(winningNumber.getWinningLotto()))
            .isEqualTo(3);
    }

}
