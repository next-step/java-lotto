package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    @DisplayName("6자리의 숫자를 생성해주는지 기능 테스트")
    void generate_size() {
        LottoNumber lotto = lottoNumberGenerator.generate();
        Assertions.assertEquals(lotto.getNumbers().size(), 6);
    }

    @Test
    @DisplayName("0~45자리의 숫자를 생성해주는지 기능 테스트")
    void generate_number() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate().getNumbers();
        for (int i=0; i<lottoNumbers.size(); i++) {
            Assertions.assertTrue(lottoNumbers.get(i)>0);
            Assertions.assertTrue(lottoNumbers.get(i)<=45);
        }
    }
}