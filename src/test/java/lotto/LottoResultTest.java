package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoResultTest {

    @Test
    public void 로또번호가_3개_맞춘게_1개라면_통과() {

        final Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18")
        ));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto("1,2,3,19,20,21"), 45);

        final Lottos result = LottoResult.rankOfMatch(new LottoDto(lottos, winningLotto), Rank.FIFTH);

        assertThat(result.getLottos()).hasSize(1);
    }

    @Test
    public void 로또번호가_3개_맞춘게_0개라면_통과() {

        final Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18")
        ));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto("19,20,21,22,23,24"), 45);

        final Lottos result = LottoResult.rankOfMatch(new LottoDto(lottos, winningLotto), Rank.FIFTH);

        assertThat(result.getLottos()).hasSize(0);
    }

    @Test
    public void 로또번호가_모두_맞춘게_1개라면_통과() {

        final Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18")
        ));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto("1,2,3,4,5,6"), 45);

        final Lottos result = LottoResult.rankOfMatch(new LottoDto(lottos, winningLotto), Rank.FIRST);

        assertThat(result.getLottos()).hasSize(1);
    }

    @Test
    public void 로또번호가_모두_맞춘게_0개라면_통과() {

        final Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18")
        ));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto("19,20,21,22,23,24"), 45);

        final Lottos result = LottoResult.rankOfMatch(new LottoDto(lottos, winningLotto), Rank.FIRST);

        assertThat(result.getLottos()).hasSize(0);
    }

    @Test
    public void 로또번호가_5개_맞추고_보너스_점수까지_맞춘게_1개라면_통과() {

        final Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,4,5,45"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18")
        ));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto("1,2,3,4,5,6"), 45);

        final Lottos result = LottoResult.rankOfMatch(new LottoDto(lottos, winningLotto), Rank.SECOND);

        assertThat(result.getLottos()).hasSize(1);
    }

}