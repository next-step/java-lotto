package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.LottoException.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers();
    }

    @Test
    @DisplayName("로또 번호가 총 45개인지 확인")
    void lottoNumberSizeCheck() {
        assertThat(lottoNumbers.count()).isEqualTo(45);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 개수가 맞지 않은 번호 확인")
    @ValueSource(ints = {1, -1, 100, 50})
    void invalidLottoNumbersSize(int lottoNumberSize) {
        assertThat(lottoNumbers.count()).isNotEqualTo(lottoNumberSize);
    }

    @Test
    @DisplayName("로또 번호들이 1 ~ 45이내의 숫자인지 확인")
    void lottoNumberCheck() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    lottoNumbers.lottoNumberRangeException(lottoNumbers);
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }

}
