package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.ManualLottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 총_6개의_중복되지_않은_난수를_만든다() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();
        int count = (int) lotto.values()
            .stream()
            .map(LottoNumber::value)
            .filter(this::inRange)
            .count();
        assertThat(lotto.count()).isEqualTo(6);
        assertThat(count).isEqualTo(6);
    }

    @Test
    void 입력한_수를_생성한다() {
        String lottoNumber = "1,2,3,4,5,6";
        LottoGenerator lottoGenerator = new ManualLottoGenerator(lottoNumber);
        Lotto lotto = lottoGenerator.generateLotto();
        assertThat(lotto.count()).isEqualTo(6);
    }

    private boolean inRange(Integer i) {
        return 1 <= i && i <= 45;
    }
}
