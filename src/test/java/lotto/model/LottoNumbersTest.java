package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    WinnerNumbers winnerNumbers;
    LottoNumbers lottoNumbers;
    List<Lotto> lottoList;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumberValidate(1),
                new LottoNumberValidate(2),
                new LottoNumberValidate(3),
                new LottoNumberValidate(4),
                new LottoNumberValidate(5),
                new LottoNumberValidate(6)));
        winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(new LottoNumberValidate(7)));
    }
    @Test
    @DisplayName("로또 번호가 6개가 아니면 에러")
    void test1() throws Exception {
        Set<LottoNumberValidate> numbers = new HashSet<>();
        numbers.add(new LottoNumberValidate(1));
        numbers.add(new LottoNumberValidate(2));
        numbers.add(new LottoNumberValidate(3));
        numbers.add(new LottoNumberValidate(4));
        numbers.add(new LottoNumberValidate(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복이면 에러")
    void test2() throws Exception {
        Set<LottoNumberValidate> numbers = new HashSet<>();
        numbers.add(new LottoNumberValidate(1));
        numbers.add(new LottoNumberValidate(2));
        numbers.add(new LottoNumberValidate(3));
        numbers.add(new LottoNumberValidate(4));
        numbers.add(new LottoNumberValidate(5));
        numbers.add(new LottoNumberValidate(5));
        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2등은 당첨번호 5개, 보너스번호를 맞아야한다.")
    void test3() throws Exception {
        Set<LottoNumberValidate> numbers = new HashSet<>();
        numbers.add(new LottoNumberValidate(1));
        numbers.add(new LottoNumberValidate(2));
        numbers.add(new LottoNumberValidate(3));
        numbers.add(new LottoNumberValidate(4));
        numbers.add(new LottoNumberValidate(5));
        numbers.add(new LottoNumberValidate(7));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.matchCountAndBonus(winnerNumbers)
                .isMatchNormalCount(5)).isTrue();
        assertThat(lottoNumbers.matchCountAndBonus(winnerNumbers)
                .isMatch(true)).isTrue();
    }

}