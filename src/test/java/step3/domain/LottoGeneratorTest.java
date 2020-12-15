package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoNumberGenerator;

import java.util.List;

import static step3.domain.LottoNumberGenerator.LOTTO_COUNT;

class LottoGeneratorTest {

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

    public static void assertionLottoNumberTest(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        Assertions.assertEquals(lottoNumbers.size(), LOTTO_COUNT);

        for (int i = 0; i< lottoNumbers.size(); i++) {
            Assertions.assertTrue(lottoNumbers.get(i).isLotto());
        }
    }
}