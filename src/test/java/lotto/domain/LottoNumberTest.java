package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("기본 생성 로또 번호 조회")
    void checkLottoNumbers() {
        assertThat(LottoNumber.lottoNumbers())
                .hasSize(45);
    }

    @Test
    @DisplayName("로또 번호 검증 - 불변성")
    void checkImmutableLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers();
        assertThatThrownBy(() -> lottoNumbers.remove(10))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 검증 - 인덱스 범위를 벗어난 로또 번호 조회")
    @ValueSource(ints = {0, 46})
    void getLottoNumbersException(int number) {
        assertThatThrownBy(() -> LottoNumber.lottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
