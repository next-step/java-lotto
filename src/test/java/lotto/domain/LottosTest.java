package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private static final int LOTTO_COUNT = 3;

    @Test
    void drawingLotto() {
        Lottos lottos = new Lottos(LOTTO_COUNT);

        lottos.drawLotto();
        List<Lotto> numberList = lottos.getLottos();

        long count = numberList.stream().filter(lottoNumber -> lottoNumber.getNumbers().size() == 6).count();
        assertThat(count).isEqualTo(3);
    }
}
