package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void generate() {
        Lotto lotto = LottoGenerator.generate();
        Lotto expected = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isEqualTo(expected);
    }

    @Test
    void generateWithParameter() {
        Lotto lotto = LottoGenerator.generate("1, 2, 3, 4, 5, 6");
        Lotto expected = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isEqualTo(expected);
    }

    @Test
    void generateLottosByMoney() {
        Lottos lottos = LottoGenerator.generate(new Money(4_000L));
        Lottos expected = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));

        assertThat(lottos).isEqualTo(expected);
    }

    @Test
    void generateLottosByCount() {
        Lottos lottos = LottoGenerator.generate(4);
        Lottos expected = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));

        assertThat(lottos).isEqualTo(expected);
    }


    private static class LottoGenerator {
        public static Lotto generate() {
            return new Lotto(1, 2, 3, 4, 5, 6);
        }

        public static Lotto generate(String numbers) {
            return new Lotto(1, 2, 3, 4, 5, 6);
        }

        public static Lottos generate(long count) {
            return new Lottos(List.of(
                    new Lotto(1, 2, 3, 4, 5, 6),
                    new Lotto(2, 3, 4, 5, 6, 7),
                    new Lotto(3, 4, 5, 6, 7, 8),
                    new Lotto(4, 5, 6, 7, 8, 9)));
        }

        public static Lottos generate(Money buyAmount) {
            return generate((long) buyAmount.divide(Lotto.LOTTO_AMOUNT));
        }
    }
}
