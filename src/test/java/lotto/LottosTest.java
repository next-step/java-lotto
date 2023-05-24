package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;
    private static final int LOTTO_PRICE = 1000;

    @BeforeEach
    public void init() {
        lottos = new Lottos(10, new LottoBallPolicy(), LOTTO_PRICE);
    }

    @Test
    void makeLottos() {
        var actualList = lottos.getLottoList();
        var expectSize = 10;

        assertThat(actualList).hasSize(expectSize);
    }
}
