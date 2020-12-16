package step3.domain.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static step2.domain.LottoNumberGenerator.LOTTO_COUNT;
import static step3.domain.generator.LottoGenerator.START_NUMBER;

class LottoManualGeneratorTest {

    LottoGenerator lottoGenerator;
    List<LottoNumber> lotto;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoManualGenerator();
        lotto = new ArrayList<>();
    }

    @Test
    @DisplayName("수동으로 로또를 생성하는 테스트")
    void generate() {
        for (int i=START_NUMBER; i<=LOTTO_COUNT ;i++) {
            lotto.add(new LottoNumber(i));
        }

        Assertions.assertEquals(lottoGenerator.generate("1,2,3,4,5,6"),new Lotto(lotto));
    }

    @Test
    @DisplayName("가변인수가 1개가 아니면 IllegalArgumentException 발생")
    void generate_exception() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoGenerator.generate());
    }
}