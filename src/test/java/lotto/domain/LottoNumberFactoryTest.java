package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberFactoryTest {

    @DisplayName("로또 번호 객체를 생성할 수 있다.")
    @Test
    void canCreateAutoLottoNumbers() {
        LottoNumber lottoNumber = LottoNumberFactory.createAutoLottoNumbers();
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
        assertThat(lottoNumber.getCreationType()).isEqualTo(CreationType.AUTO);
    }

    @DisplayName("수동 번호로 객체를 생성할 수 있다.")
    @Test
    void canCreateManualLottoNumbers() {
        LottoNumber lottoNumber = LottoNumberFactory.createManualLottoNumbers("1, 2, 3, 4, 5, 6");
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
        assertThat(lottoNumber.getCreationType()).isEqualTo(CreationType.MANUAL);
    }
}
