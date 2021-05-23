package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Lotto winnerLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto).isEqualTo(winnerLotto);
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

    @DisplayName("당첨번호가 중복된 보너스 볼을 입력하면 예외가 발생한다")
    @Test
    void validate_bonusNumber() {
        // given
        Lotto winnerLotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        LottoNumber bonusNumber = LottoNumber.from(6);

        // then
        assertThatThrownBy(() -> winnerLotto.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스번호는 당첨번호와 중복될 수 없습니다.");
    }

    @DisplayName("당첨 번호를 입력하면 당첨 결과 금액을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:7:5000", "1,2,3,4,10,11:7:50000", "1,2,3,4,5,10:7:1500000",
            "1,2,3,4,5,10:6:30000000", "1,2,3,4,5,6:7:2000000000"}, delimiter = ':')
    void getRank(String winnerLottoNumbers, int bonusNumber, int expectedPrizeMoney) {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        Lotto winnerLotto = Lotto.from(Arrays.asList(winnerLottoNumbers.split(","))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(toList()));
        LottoNumber bonusLottoNumber = LottoNumber.from(bonusNumber);

        // when
        Rank rank = lotto.getRank(winnerLotto, bonusLottoNumber);

        // then
        assertThat(rank.getPrizeMoney()).isEqualTo(expectedPrizeMoney);
    }
}
