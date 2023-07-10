package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoGeneratorTest {

    @Test
    @DisplayName("로또 자동 생성기는 올바른 로또를 생성한다.")
    void 자동_로또_생성() {

        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        Assertions.assertThatCode(autoLottoGenerator::generate)
                .doesNotThrowAnyException();
    }

}
