package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoGenerator.generateLotto;
import static org.assertj.core.api.Assertions.assertThat;
public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성")
    void 로또_생성() {
        Lotto lottoGame = generateLotto();
        assertThat(lottoGame.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 갯수만큼 자동로또 생성")
    void 입력_갯수만큼_자동로또_생성() {
        List<Lotto> lottos = LottoGenerator.auto(3);
        assertThat(lottos).hasSize(3);
    }
}
