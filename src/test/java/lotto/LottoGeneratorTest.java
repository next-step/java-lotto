package lotto;

import lotto.domain.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generate성공() {

        assertThat(lottoGenerator.generate(4).getSize()).isEqualTo(4);
    }

    @Test
    void 숫자가0보다작으면실패() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            lottoGenerator.generate(-1);
        });
    }

}
