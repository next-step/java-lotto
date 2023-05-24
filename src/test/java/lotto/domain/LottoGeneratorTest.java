package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void generate() {
        LottoGenerator lottoGenerator = () -> Lotto.from("2, 3, 4, 5, 6, 7");

        WinningLotto winningLotto = WinningLotto.from("2, 3, 4, 5, 6, 7", 1);
        Lotto lotto = lottoGenerator.generate();
        Match match = winningLotto.getMatch(lotto);

        assertThat(match).isEqualTo(Match.SIX);
    }
}
