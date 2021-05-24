package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또를 생성하면 번호가 6개인 로또가 생성된다")
    @Test
    void create() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        int lottoSize = lotto.getLotto().size();

        // then
        assertThat(lottoSize).isEqualTo(Lotto.NUMBER_SIZE);
    }

    @DisplayName("당첨 번호 6자리를 입력하면 로또가 생성된다")
    @Test
    void create_winner_lotto() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        Lotto winningLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto).isEqualTo(winningLotto);
    }

    @DisplayName("6자리 숫자를 입력하지 않으면 예외가 발생한다")
    @Test
    void validate_size() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리 이어야 합니다.");
    }

    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다")
    @Test
    void validate_redundancy() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 로또 번호는 입력할 수 없습니다.");
    }

    @DisplayName("당첨 로또를 입력하면 일치하는 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3"}, delimiter = ':')
    void match_count(String lottoNumbers, int expectedCount) {
        // given
        Lotto winningLotto = Lotto.from(new TestLottoNumberGenerator());
        Lotto lotto = Lotto.from(Arrays.asList(lottoNumbers.split(","))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(toList()));

        // when
        int matchCount = lotto.getMatchCount(winningLotto);

        // then
        assertThat(matchCount).isEqualTo(expectedCount);
    }

    @DisplayName("보너스 번호가 포함되면 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"6,true", "7,false"})
    void match_bonus(int number, boolean expected) {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        LottoNumber bonusNumber = LottoNumber.from(number);

        // when
        boolean matchBonus = lotto.matchBonus(bonusNumber);

        // then
        assertThat(matchBonus).isEqualTo(expected);
    }
}
