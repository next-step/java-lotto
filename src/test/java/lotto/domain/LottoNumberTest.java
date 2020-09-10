package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    public void 로또번호생성() {
        assertThat(LottoNumber.of(3)).isEqualTo(new LottoNumber(3));
    }

    @DisplayName("로또 번호 생성시 음수 Exception 발생")
    @Test
    public void 로또번호생성시_음수Exception발생() {
        assertThatThrownBy(
                () -> LottoNumber.of(-3)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 입력값입니다. 0보다 커야합니다.");
    }

    @DisplayName("로또 번호 생성시 46이상 Exception 발생ㄴ")
    @Test
    public void 로또번호생성시_46이상_Exception발생() {
        assertThatThrownBy(
                () -> LottoNumber.of(57)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 입력값입니다. 45보다 작거나 같아야 합니다.");
    }

    @DisplayName("0보다 크고 45보다 작게 체크 --> 범위에서 벗어날 시, IllegalArgumentException 발생")
    @Test
    public void 로또번호_범위체크() {
        assertThatThrownBy(
                () -> LottoNumber.validate(57)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 받아 로또 번호와 같은지 체크")
    @Test
    public void 당첨번호_맞는지_테스트() {
        int number = 3;
        assertThat(LottoNumber.of(number).isMatchNumber(number)).isTrue();
        assertThat(LottoNumber.of(number).isMatchNumber(4)).isFalse();
    }

}
