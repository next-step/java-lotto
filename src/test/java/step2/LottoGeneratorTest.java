package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void 서로_같지_않은_로또_숫자_6개_생성() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        // Lotto, LottoNumber 생성자에서 검증 실패 시 throw
        assertThatCode(lottoGenerator::generate)
                .doesNotThrowAnyException();
    }

    @Test
    void 문자열을_로또로_변환() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lotto lotto = lottoGenerator.generateFromString("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(Lotto.of(List.of(1,2,3,4,5,6)));
    }
}
