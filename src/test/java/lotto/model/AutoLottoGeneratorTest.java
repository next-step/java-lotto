package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class AutoLottoGeneratorTest {

    @DisplayName("1에서 45 사이의 숫자 6개를 만든다")
    @RepeatedTest(100)
    void generateLotto() {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        List<LottoNumber> autoLotto = autoLottoGenerator.generateLotto();
        assertThat(autoLotto.size()).isEqualTo(6);
        for (LottoNumber lottoNumber : autoLotto) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

}
