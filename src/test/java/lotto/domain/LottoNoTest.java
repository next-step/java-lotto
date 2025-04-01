package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {
    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자일 경우 생성 성공 테스트")
    void createLottoNoWithValidNumber() {
        LottoNo lottoNo = new LottoNo(10);

        assertThat(lottoNo.getNumber()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 번호가 1 미만일 경우 예외 발생 테스트")
    void createLottoNoWithNumberLessThanOne() {
        assertThatThrownBy(() -> new LottoNo(0))
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과일 경우 예외 발생 테스트")
    void createLottoNoWithNumberGreaterThanFortyFive() {
        assertThatThrownBy(() -> new LottoNo(46))
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("equals 메서드 테스트")
    void testEquals() {
        LottoNo lottoNo1 = new LottoNo(10);
        LottoNo lottoNo2 = new LottoNo(10);
        LottoNo lottoNo3 = new LottoNo(20);

        assertThat(lottoNo1).isEqualTo(lottoNo2);
        assertThat(lottoNo1).isNotEqualTo(lottoNo3);
    }

    @Test
    @DisplayName("hashCode 메서드 테스트")
    void testHashCode() {
        LottoNo lottoNo1 = new LottoNo(10);
        LottoNo lottoNo2 = new LottoNo(10);
        LottoNo lottoNo3 = new LottoNo(20);

        assertThat(lottoNo1.hashCode()).isEqualTo(lottoNo2.hashCode());
        assertThat(lottoNo1.hashCode()).isNotEqualTo(lottoNo3.hashCode());
    }

    @Test
    @DisplayName("compareTo 메서드 테스트")
    void testCompareTo() {
        LottoNo lottoNo1 = new LottoNo(10);
        LottoNo lottoNo2 = new LottoNo(10);
        LottoNo lottoNo3 = new LottoNo(20);

        assertThat(lottoNo1.compareTo(lottoNo2)).isEqualTo(0);
        assertThat(lottoNo1.compareTo(lottoNo3)).isLessThan(0);
        assertThat(lottoNo3.compareTo(lottoNo1)).isGreaterThan(0);
    }
}
