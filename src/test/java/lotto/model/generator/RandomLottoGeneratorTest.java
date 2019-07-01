package lotto.model.generator;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoGeneratorTest {

    @DisplayName("자동으로 로또를 5개를 생성한다")
    @Test
    void createRandomLotto_inputCountOfLotto_success() {
        int countOfLotto = 5;

        LottoGenerator randomLottoGenerator = new RandomLottoGenerator(countOfLotto);
        List<Lotto> lottos = randomLottoGenerator.generator();

        assertThat(lottos).hasSize(countOfLotto);
    }
}