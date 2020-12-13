package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    @DisplayName("로또 숫자인지 기능 테스트 - (6개의 숫자이고, 각 숫자는 1~45이다)")
    void generate_size() {
        assertionLottoNumberTest(lottoNumberGenerator.generate());

    }

    public static void assertionLottoNumberTest(LottoNumber lottoNumber) {
        List<Number> numbers = lottoNumber.getNumbers();
        Assertions.assertEquals(numbers.size(), 6);

        for (int i=0; i<numbers.size(); i++) {
            Assertions.assertTrue(numbers.get(i).isLotto());
        }
    }
}