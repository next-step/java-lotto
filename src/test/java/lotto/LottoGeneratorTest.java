package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    private LottoGenerator generator = new LottoGenerator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 수동로또구매(int input) {
        Lottos lottos = new Lottos();
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            manualLottos.add("1,2,3,4,5,6");
        }

        List<Lotto> manual = generator.manual(manualLottos);
        lottos.buyLotto(manual);

        assertThat(manual.size()).isEqualTo(input);
        assertThat(lottos.quantity()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 자동로또구매(int input) {
        Lottos lottos = new Lottos();

        List<Lotto> auto = generator.auto(input);
        lottos.buyLotto(auto);

        assertThat(auto.size()).isEqualTo(input);
        assertThat(lottos.quantity()).isEqualTo(input);
    }
}
