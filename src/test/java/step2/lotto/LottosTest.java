package step2.lotto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lottos")
class LottosTest {
    @Test
    @DisplayName("can be shown using toString()")
    void canBeShownUsingToString() {
        final List<Integer> lottoNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);
        final Lottos lottos = new Lottos(new Lotto(lottoNumbers), new Lotto(lottoNumbers));
        final String expected = "" +
                "[8, 21, 23, 41, 42, 43]\n" +
                "[8, 21, 23, 41, 42, 43]";

        assertThat(lottos.toString()).isEqualTo(expected);
    }


    @Test
    @DisplayName("can count win lotto")
    void test2() {
        final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Lotto winLotto = new Lotto(winNumbers);
        final Lotto loseLotto = new Lotto(7, 8, 9, 10, 11, 12);

        final Lottos lottos = new Lottos(winLotto, loseLotto);
        assertThat(lottos.countMatchesLotto(winNumbers)).isEqualTo(1);
    }
}