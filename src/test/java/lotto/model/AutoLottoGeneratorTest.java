package lotto.model;

import lotto.model.util.AutoLottoGenerator;
import lotto.model.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class AutoLottoGeneratorTest {

    @Test
    @DisplayName("로또 자동 생성기는 올바른 로또를 생성한다.")
    void 자동_로또_생성() {

        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        assertThatCode(autoLottoGenerator::generate)
            .doesNotThrowAnyException();
    }

}
