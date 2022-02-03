package lotto.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMatcherTest {

    @Test
    public void 로또번호비교_6개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(6);
    }

    @Test
    public void 로또번호비교_5개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(5);
    }

    @Test
    public void 로또번호비교_4개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 8, 7));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(4);
    }
    @Test
    public void 로또번호비교_3개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 21, 30, 7));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(3);
    }

    @Test
    public void 로또번호비교_2개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 16, 14, 12, 26));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(2);
    }

    @Test
    public void 로또번호비교_1개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(1, 12, 13, 14, 15, 17));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(1);
    }

    @Test
    public void 로또번호비교_0개_일치() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(Arrays.asList(11, 12, 13, 14, 15, 17));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        //then
        System.out.println(lotto);
        Assertions.assertThat(LottoMatcher.compare(numbers, integers)).isEqualTo(0);
    }

    @Test
    void 보너스_볼_확인() {
        // given
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(lotto.getNumbers(), new LottoNumber(1));

        //when
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<Integer> integers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        // then
        Assertions.assertThat(LottoMatcher.matchBonus(winningNumber, integers)).isTrue();

    }
}