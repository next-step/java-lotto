package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    @Test
    public void 로또번호가_한개만_맞은_경우() {

        final List<Lotto> lottos = Arrays.asList(
                new Lotto("11,22,33,14,34,29"),
                new Lotto("11,2,23,14,25,26"),
                new Lotto("1,12,3,14,5,16"),
                new Lotto("11,28,13,4,9,6"),
                new Lotto("29,2,31,34,5,16"),
                new Lotto("31,32,3,34,5,36")
        );

        assertThat(Lottos.findWinningNumbers(new WinningNumber(lottos, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 1)).hasSize(1);
    }

    @Test
    public void 로또번호를_전부_맞춘_경우() {

        final List<Lotto> lottos = Arrays.asList(
                new Lotto("11,30,33,32,34,29"),
                new Lotto("29,30,31,32,33,26"),
                new Lotto("1,12,3,14,5,16"),
                new Lotto("11,28,13,4,9,6"),
                new Lotto("29,30,31,32,33,34"),
                new Lotto("34,33,32,31,30,29")
        );

        assertThat(Lottos.findWinningNumbers(new WinningNumber(lottos, new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34))), 6)).hasSize(2);
    }

    @Test
    public void 로또번호_3개가_맞았을떄_수익률_계산() {
        assertThat(Lottos.getRate(
                new WinningNumber(Collections.singletonList(new Lotto("1,2,3,30,31,32")), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                , 100000)
        ).isEqualTo(0.05);
    }

    @Test
    public void 로또번호_6개가_맞았을떄_수익률_계산() {
        assertThat(Lottos.getRate(
                new WinningNumber(Collections.singletonList(new Lotto("1,2,3,4,5,6")), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                , 100000)
        ).isEqualTo(20000);
    }

}