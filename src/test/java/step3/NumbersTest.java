package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("45자리 로또 번호 일급 콜렉션 테스트")
class NumbersTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        Numbers numbers = new Numbers();
        lottoNumbers = numbers.extractLottoNumber();
    }

    @Test
    @DisplayName("로또 번호 6개 확인 테스트")
    void extractLottoNumberTest() {
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }
}