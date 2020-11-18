package lotto;

import lotto.model.Hit;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.strategy.ManualDrawing;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoesTest {
    @Test
    public void 가진_금액_보다_구입_개수가_많은_경우() {
        Lotto test1 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto test2 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottoes(100, Arrays.asList(test1, test2)));
    }

    @Test
    public void 정상_수동_구입() {
        Lotto test1 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto test2 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lottoes lottoes = new Lottoes(Lotto.PRICE * 2, Arrays.asList(test1, test2));
        assertThat(lottoes.getLottoCount()).isEqualTo(2);
    }

    @Test
    public void 추첨_결과_테스트() {
        Lotto winnerNumbers = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lotto testHit3 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 45, 35, 36)));
        Lotto testHit32 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 45, 35, 36)));
        Lotto testHit4 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 35, 36)));
        Lotto testHit5 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 36)));
        Lotto testHit6 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lottoes lottoes = new Lottoes(Lotto.PRICE * 5, Arrays.asList(testHit3, testHit32, testHit4, testHit5, testHit6));

        Map<Hit, Integer> result = lottoes.getResult(winnerNumbers.getNumbers());

        assertThat(result.get(Hit.HIT_3)).isEqualTo(2);
        assertThat(result.get(Hit.HIT_4)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_5)).isEqualTo(1);
        assertThat(result.get(Hit.HIT_6)).isEqualTo(1);
    }

    @Test
    public void 수익률_테스트() {
        Lotto winnerNumbers = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lotto testHit3 = new Lotto(new ManualDrawing(Arrays.asList(1, 2, 3, 45, 35, 36)));
        Lotto testHitNone = new Lotto(new ManualDrawing(Arrays.asList(21, 22, 23, 24, 35, 36)));

        Lottoes lottoes = new Lottoes(14000, Arrays.asList(testHit3, testHitNone));

        double result = lottoes.getEarningRate(winnerNumbers.getNumbers());

        assertThat(result).isEqualTo(0.35);
    }
}
