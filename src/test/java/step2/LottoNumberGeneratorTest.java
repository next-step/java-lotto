package step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @Test
    void 서로_같지_않은_로또_숫자_6개_생성() {
        LottoGenerator lottoNumberGenerator = new LottoGenerator();

        // Lotto, LottoNumber 생성자에서 검증 실패 시 throw
        Assertions.assertDoesNotThrow(lottoNumberGenerator::generate);
    }
}
