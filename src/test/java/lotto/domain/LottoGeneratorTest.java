package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void generate() {
        LottoGenerator lottoGenerator = new LottoGenerator(new Shuffler() {
            @Override
            public <T> void shuffle(List<T> values) {
                T value = values.get(0);
                values.remove(0);
                values.add(value);
            }
        });

        WinningLotto winningLotto = WinningLotto.from("2, 3, 4, 5, 6, 7", 1);
        Lotto lotto = lottoGenerator.generate();
        Match match = winningLotto.getMatch(lotto);

        assertThat(match).isEqualTo(Match.SIX);
    }
}
