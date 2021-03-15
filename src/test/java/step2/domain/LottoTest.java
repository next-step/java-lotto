package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("1~45번 숫자를 생성한다.")
    @Test
    void createNumber() {
        //given
        Lotto lotto = new Lotto();

        //when
        List<Integer> numbers = lotto.createNumber();
        Integer max = numbers.stream().max(comparing(number -> number)).orElse(0);
        Integer min = numbers.stream().min(comparing(number -> number)).orElse(0);

        //then
        assertThat(max).isEqualTo(45);
        assertThat(min).isEqualTo(1);
    }

    @DisplayName("6번째 번호까지 잘라 로또를 생성한다.")
    @Test
    void createLotto() {
        //given
        Lotto lotto = new Lotto();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //when
        List<LottoNumber> lottoNumbers = lotto.pickNumber(numbers);

        //then
        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @DisplayName("1등일 경우 테스트")
    @Test
    void match_1등() {
        //given
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        Rank match = lotto.match(winNumber);

        //then
        assertThat(match).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등일 경우 테스트")
    @Test
    void match_2등() {
        //given
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 7);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        Rank match = lotto.match(winNumber);

        //then
        assertThat(match).isEqualTo(Rank.SECOND);
    }

    @DisplayName("하나도 당청안됬을 경우 테스트")
    @Test
    void match_미스() {
        //given
        Lotto lotto = createLotto(11, 23, 42, 32, 11, 7);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        Rank match = lotto.match(winNumber);

        //then
        assertThat(match).isEqualTo(Rank.MISS);
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(new LottoNumber(one), new LottoNumber(two), new LottoNumber(three), new LottoNumber(four), new LottoNumber(five), new LottoNumber(six)));
    }

    Lottos createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        lottoList.add(new Lotto(List.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));
        lottoList.add(new Lotto(List.of(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(11), new LottoNumber(24))));
        return new Lottos(lottoList);
    }
}

