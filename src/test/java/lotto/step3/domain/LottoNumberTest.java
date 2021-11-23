package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void createLottoNumber() {
        LottoNumber number = new LottoNumber(1);
        assertThat(number).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("로또넘버 1~45 x -> IllegalArgumentException")
    void validation() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또넘버 정렬했을 경우, 로또넘버 객체 오름차순 정렬")
    void compareLottoNumber() {
        assertThat(new LottoNumber(2)).isGreaterThan(new LottoNumber(1));
    }

}