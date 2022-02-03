package lotto.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    @Test
    public void 로또번호비교_6개_일치_1등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(16));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 로또번호비교_5개_일치_보너스볼_포함_2등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(16));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 로또번호비교_5개_일치_보너스볼_미포함_3등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 로또번호비교_4개_일치_4등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 15, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 로또번호비교_3개_일치_5등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 14, 15, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또번호비교_2개_일치_5등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 13, 14, 15, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.NONE);
    }

    @Test
    public void 로또번호비교_1개_일치_5등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(1, 12, 13, 14, 15, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.NONE);
    }

    @Test
    public void 로또번호비교_0개_일치_5등() {
        //given
        Lotto prevLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(prevLotto.getNumbers(), new LottoNumber(26));

        Lotto lotto = Lotto.from(Arrays.asList(11, 12, 13, 14, 15, 16));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        Assertions.assertThat(LottoMatcher.compare(winningNumber, integers)).isEqualTo(Rank.NONE);
    }
}