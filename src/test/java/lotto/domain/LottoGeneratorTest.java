package lotto.domain;

import lotto.domain.LottoFee;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoGenerator.generateLotto;
import static lotto.domain.LottoGenerator.generateLottos;
import static org.assertj.core.api.Assertions.assertThat;
public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성")
    void 로또_생성() {
        Lotto lottoGame = generateLotto();
        assertThat(lottoGame.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 금액만큼 생성")
    void 입력_금액만큼_생성() {
        LottoFee lottoFee = new LottoFee(14000);
        Lottos lottos = generateLottos(lottoFee);
        assertThat(lottos.getValue().size()).isEqualTo(14);
    }
}
