package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 10;

    @BeforeEach
    public void init() {
        lottos = new Lottos(LOTTO_COUNT, LOTTO_PRICE, new LottoBallPolicy());
    }

    @Test
    void makeLottos() {
        var actualList = lottos.getLottoList();
        var expectSize = 10;

        assertThat(actualList).hasSize(expectSize);
    }
}
