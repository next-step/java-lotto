package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("정적팩토리메소드로 객체 사용")
    void createLottoNumber() {
        LottoNumber number = LottoNumber.of(1);
        assertThat(number).isEqualTo(LottoNumber.of(1));
    }

    @Test
    @DisplayName("로또넘버 1~45 x -> IllegalArgumentException")
    void validation() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또넘버 정렬했을 경우, 로또넘버 객체 오름차순 정렬")
    void compareLottoNumber() {
        assertThat(LottoNumber.of(2)).isGreaterThan(LottoNumber.of(1));
    }

}