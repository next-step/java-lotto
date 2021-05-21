package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    @DisplayName("6개 이상의 숫자를 담을 시 IllegalArgumentException 발생")
    void validationTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> {
                LottoNumbers lottoNumbers = new LottoNumbers();
                setLottoNumbersOverSix(lottoNumbers);
            });

        assertThat(exception.getMessage()).isEqualTo("6개의 숫자까지만 담을 수 있습니다.");
    }

    @Test
    @DisplayName("size 크기반환 테스트")
    void sizeTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addNumber(new LottoNumber(1));
        assertThat(lottoNumbers.size()).isEqualTo(1);
    }

    private void setLottoNumbersOverSix(LottoNumbers lottoNumbers) {
        for (int index = 1; index <= 10; index++) {
            lottoNumbers.addNumber(new LottoNumber(index));
        }
    }
}
