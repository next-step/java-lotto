package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    public void 당첨결과_보너스번호없음() {
        final Lotto anyLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto, // 6개 일치
                new Lotto(Arrays.asList( // 4개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList( // 4개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList( // 3개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        final WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        assertThat(winningResults.get(Prize.FIRST)).isEqualTo(new WinningResult(Prize.FIRST, 1));
        assertThat(winningResults.get(Prize.SECOND)).isEqualTo(new WinningResult(Prize.SECOND, 0));
        assertThat(winningResults.get(Prize.THIRD)).isEqualTo(new WinningResult(Prize.THIRD, 0));
        assertThat(winningResults.get(Prize.FOURTH)).isEqualTo(new WinningResult(Prize.FOURTH, 2));
        assertThat(winningResults.get(Prize.FIFTH)).isEqualTo(new WinningResult(Prize.FIFTH, 1));
    }

    @Test
    public void 당첨결과_보너스번호있음() {
        final Lotto anyLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto, new LottoNumber(43));

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto, // 6개 일치
                new Lotto(Arrays.asList( // 5개 일치 + 보너스 번호 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(43))),
                new Lotto(Arrays.asList( // 4개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList( // 3개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        final WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        assertThat(winningResults.get(Prize.FIRST)).isEqualTo(new WinningResult(Prize.FIRST, 1));
        assertThat(winningResults.get(Prize.SECOND)).isEqualTo(new WinningResult(Prize.SECOND, 1));
        assertThat(winningResults.get(Prize.THIRD)).isEqualTo(new WinningResult(Prize.THIRD, 0));
        assertThat(winningResults.get(Prize.FOURTH)).isEqualTo(new WinningResult(Prize.FOURTH, 1));
        assertThat(winningResults.get(Prize.FIFTH)).isEqualTo(new WinningResult(Prize.FIFTH, 1));
    }
}