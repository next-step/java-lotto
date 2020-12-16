package step3.domain.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.List;

import static step3.domain.generator.LottoAutoGenerator.LOTTO_COUNT;

public class LottoAutoGeneratorTest {

    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoAutoGenerator();
    }

    @Test
    @DisplayName("로또 숫자인지 기능 테스트 - (6개의 숫자이고, 각 숫자는 1~45이다)")
    void generate_size() {
        assertionLottoNumberTest(lottoGenerator.generate());

    }

    @Test
    @DisplayName("가변인수가 0개가 아니면 IllegalArgumentException 발생")
    void generate_exception() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoGenerator.generate("1,2,3,4,5,6"));
    }

    public static void assertionLottoNumberTest(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        Assertions.assertEquals(lottoNumbers.size(), LOTTO_COUNT);

        for (int i = 0; i< lottoNumbers.size(); i++) {
            Assertions.assertTrue(lottoNumbers.get(i).isLotto());
        }
    }
}