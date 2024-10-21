package lotto;

import lotto.service.LottoGenerator;
import lotto.service.LottoSeller;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_생성() {
        List<Integer> lotto = LottoGenerator.generateLotto();

        lotto.forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        });
    }
}
