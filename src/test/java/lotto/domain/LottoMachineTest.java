package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("같은 크기의 로또 여러장 생성")
    void createLottos(int lottoCount) {
        List<Lotto> lottos = LottoMachine.createLottos(lottoCount);
        assertThat(lottos).hasSize(lottoCount);

        List<LottoNumber> lottoNumbers = lottos.get(0).getLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }
}
