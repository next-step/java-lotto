import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private final LottoGame lottoGame = new LottoGame();

    @Test
    public void 천원당_1개씩_로또를_구매할수있다() {
        int budget = 5000;

        Lottos lottos = lottoGame.buy(budget);
        assertThat(lottos.size()).isEqualTo(budget / 1000);
    }

    @Test
    public void 로또1개_구입시_6개의_번호를_생성한다() {
        int budget = 5000;

        Lottos lottos = lottoGame.buy(budget);
        long sizeCheckCount = IntStream.range(0, lottos.size())
                .filter(i -> lottos.findByOrder(i).size() == 6)
                .count();

        assertThat(sizeCheckCount).isEqualTo(budget / 1000);
    }

    @Test
    public void 로또는_1부터_45이내의_번호를_생성한다() {
        int budget = 5000;

        Lottos lottos = lottoGame.buy(budget);
        assertThat(countValidNumbers(lottos)).isEqualTo((budget / 1000) * 6);
    }

    private int countValidNumbers(Lottos lottos) {
        return (int) lottos.get().stream()
                .flatMap(i -> i.numbers().get().stream())
                .filter(number -> number.get() >= 1 && number.get() <= 45)
                .count();
    }
}
