package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void generate() {
        LottoGenerator generator = getGenerator();
        Lotto lotto = generator.generate();
        Lotto expected = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isEqualTo(expected);
    }

    @Test
    void generateWithParameter() {
        LottoGenerator generator = getGenerator();
        Lotto lotto = generator.generate("1, 2, 3, 4, 5, 6");
        Lotto expected = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto).isEqualTo(expected);
    }

    @Test
    void generateLottosByMoney() {
        LottoGenerator generator = getGenerator();
        Lottos lottos = generator.generate(new Money(4_000L));
        Lottos expected = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));

        assertThat(lottos).isEqualTo(expected);
    }
    @Test
    void generateLottosByCount() {
        LottoGenerator generator = getGenerator();
        Lottos lottos = generator.generate(4);
        Lottos expected = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));

        assertThat(lottos).isEqualTo(expected);
    }

    private LottoGenerator getGenerator() {
        return new LottoGenerator() {
            public Lotto generate() {
                return new Lotto(1, 2, 3, 4, 5, 6);
            }

            public Lotto generate(String numbers) {
                return new Lotto(1, 2, 3, 4, 5, 6);
            }

            public Lottos generate(long count) {
                return new Lottos(List.of(
                        new Lotto(1, 2, 3, 4, 5, 6),
                        new Lotto(2, 3, 4, 5, 6, 7),
                        new Lotto(3, 4, 5, 6, 7, 8),
                        new Lotto(4, 5, 6, 7, 8, 9)));
            }
        };
    }
}
