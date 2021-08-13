package lotto.domain;

import lotto.domain.generationStrategy.AutoNumberGenerationStrategy;
import lotto.domain.generationStrategy.NumberGenerationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class LottoMachineTest {

    private LottoMachine lottoMachine;
    private NumberGenerationStrategy numberGenerationStrategy = new AutoNumberGenerationStrategy();

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("지불금액이 천원 이하일때 예외 throw")
    @Test
    void buyLotto_1000원_이하() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoMachine.buyLotto(999, numberGenerationStrategy);
        }).withMessageMatching("최소 1000원 이상 지불하셔야 합니다.");
    }

}
