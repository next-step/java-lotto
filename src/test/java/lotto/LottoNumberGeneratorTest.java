package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static lotto.Lotto.LOTTO_NUM_COUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    void 요청한_개수만큼_Lotto_객체를_생성한다() {
        int quantity = 5;
        List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(quantity);
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    void 각_Lotto는_6개의_서로_다른_숫자를_가진다() {
        List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(1);
        List<Integer> numbers = lottos.get(0).getLottoNumbers();

        assertThat(numbers.size()).isEqualTo(LOTTO_NUM_COUNT);
        assertThat(new HashSet<>(numbers).size()).isEqualTo(numbers.size());
    }

}
