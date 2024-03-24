package lotto;

import lotto.domain.Fee;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
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
        Lotto lottoGame = lottoGenerator.generateLotto();
        assertThat(lottoGame.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 금액만큼 생성")
    void 입력_금액만큼_생성() {
        Fee fee = new Fee(14000);
        Lottos lottos = lottoGenerator.generateLottos(fee);
        assertThat(lottos.getValue().size()).isEqualTo(14);
    }
}
