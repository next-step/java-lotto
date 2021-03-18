package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("6개의 로또번호를 생성한다.")
    @Test
    void createLotto() {
        Lotto createLotto = new Lotto();

        //then
        assertThat(createLotto.toNumberList().size()).isEqualTo(6);
    }

    @DisplayName("1등일 경우 테스트")
    @Test
    void match_1등() {
        //given
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        int countOfMatch = lotto.match(winNumber);

        //then
        assertThat(countOfMatch).isEqualTo(6);
    }

    @DisplayName("2등일 경우 테스트")
    @Test
    void match_2등() {
        //given
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 7);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        int countOfMatch = lotto.match(winNumber);

        //then
        assertThat(countOfMatch).isEqualTo(5);
    }

    @DisplayName("하나도 당청안됬을 경우 테스트")
    @Test
    void match_미스() {
        //given
        Lotto lotto = createLotto(11, 23, 42, 32, 11, 7);
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();

        //when
        int countOfMatch = lotto.match(winNumber);

        //then
        assertThat(countOfMatch).isEqualTo(0);
    }

    @DisplayName("보너스 볼을 맞췄을 경우")
    @Test
    void match_Bonus() {
        //given
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
        LottoNumber BonusNumber = LottoNumber.of(6);

        //when
        boolean matchBonus = lotto.matchBonus(BonusNumber);

        //then
        assertThat(matchBonus).isTrue();
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(LottoNumber.of(one), LottoNumber.of(two), LottoNumber.of(three), LottoNumber.of(four), LottoNumber.of(five), LottoNumber.of(six)));
    }
}

