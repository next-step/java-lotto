package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("기본 생성 로또 번호 조회")
    void lottoNumbers() {
        assertThat(LottoNumber.lottoNumbers().size()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또 번호 검증 - 불변성")
    void immutableLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();
        assertThatThrownBy(() -> lottoNumbers.remove(10)).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("로또 번호 검증 - 인덱스 범위를 벗어난 로또 번호 조회")
    void getLottoNumbersException() {
        assertThatThrownBy(() -> LottoNumber.lottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.lottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
