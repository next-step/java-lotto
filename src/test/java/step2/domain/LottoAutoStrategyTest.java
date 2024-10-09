package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoAutoStrategyTest {

    private LottoAutoStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new LottoAutoStrategy();
    }

    @DisplayName("6자리 로또 번호가 생성된다.")
    @Test
    void create() {
        LottoNumbers numbers = strategy.generateLottoNumbers();

        int actual = numbers.getLottoNumbers().size();

        assertEquals(6, actual);
    }

}