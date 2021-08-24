package lotto.domain;

import lotto.domain.generationStrategy.AutoNumberGenerationStrategy;
import lotto.domain.generationStrategy.NumberGenerationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoMachineTest {

    private LottoMachine lottoMachine;
    private NumberGenerationStrategy numberGenerationStrategy = new AutoNumberGenerationStrategy();

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("Lottos 생성")
    @Test
    void buyLotto_Lottos_생성() {
        List<String> manuallyLottos = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8");
        Lottos lottos = lottoMachine.buyLotto(new Money(10000), manuallyLottos, new AutoNumberGenerationStrategy());

        assertThat(lottos).isInstanceOf(Lottos.class);
    }

}
