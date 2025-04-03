package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    void 요청한_개수만큼_Lotto_객체를_생성한다() {
        int quantity = 5;
        List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(quantity);
        assertThat(lottos.size()).isEqualTo(quantity);
    }

}
