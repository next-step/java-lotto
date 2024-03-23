package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void initGenerator() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("로또 생성")
    void 로또_생성() {
        List<Integer> lottoGame = lottoGenerator.generateLotto();
        assertThat(lottoGame.size()).isEqualTo(6);
    }
}
