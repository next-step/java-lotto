package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("유효한 로또 번호로 객체 생성 확인")
    void create_validLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(5);
        assertThat(lottoNumber.getNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("유효하지 않은 로또 번호로 객체 생성 확인")
    void create_invalidLottoNumber() {
        assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1과 45 사이여야 합니다.");

        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1과 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("equals() 메서드 확인")
    void equals() {
        LottoNumber lottoNumber1 = new LottoNumber(10);
        LottoNumber lottoNumber2 = new LottoNumber(10);
        LottoNumber lottoNumber3 = new LottoNumber(20);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
        assertThat(lottoNumber1).isNotEqualTo(lottoNumber3);
    }

    @Test
    @DisplayName("compareTo() 메서드 확인")
    void testCompareTo() {
        LottoNumber lottoNumber1 = new LottoNumber(10);
        LottoNumber lottoNumber2 = new LottoNumber(20);

       assertThat(lottoNumber1.compareTo(lottoNumber2)).isLessThan(0);
       assertThat(lottoNumber2.compareTo(lottoNumber1)).isGreaterThan(0);
       assertThat(lottoNumber1.compareTo(lottoNumber1)).isEqualTo(0);
    }
}
