package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private final Lotto lotto = new Lotto(IntStream.rangeClosed(1, 6)
            .mapToObj(LottoNumber::createLottoNumber)
            .collect(Collectors.toList()));

    @Test
    @DisplayName("우승 로또의 로또가 제대로 입력되지 않으면 예외 발생")
    void 우승로또_로또가_제대로_입력되지않은경우() {

        Assertions.assertThatThrownBy(
                        () -> new WinningLotto(null, LottoNumber.createLottoNumber(7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("우승 번호가 제대로 입력되지 않음");

    }

    @Test
    @DisplayName("보너스 번호가 제대로 입력되지 않으면 예외 발생")
    void 우승로또_보너스번호가_제대로_입력되지않은경우() {

        Assertions.assertThatThrownBy(
                        () -> new WinningLotto(lotto, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 입력되지 않음");

    }

    @Test
    @DisplayName("당첨번호와 보너스 번호 중복 시 예외 발생")
    void 당첨번호와_보너스번호_중복_시_예외_발생() {

        Assertions.assertThatThrownBy(
                        () -> new WinningLotto(lotto, LottoNumber.createLottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호가 중복됩니다");

    }

}
