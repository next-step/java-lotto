package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("입력된 번호로 로또가 잘 생성되는지 확인")
    @Test
    public void lottoNewTest() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                makeNumber(1),
                makeNumber(2),
                makeNumber(3),
                makeNumber(4),
                makeNumber(5),
                makeNumber(6)
        );

        Lotto lotto = new Lotto(numbers);
        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        // when & then
        assertAll(
                () -> assertThat(lotto.getNumbers()).hasSize(6),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(1)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(2)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(3)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(4)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(5)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(6)))).isTrue(),
                () -> assertThat(lottoNumbers.stream().anyMatch(n -> n.equals(makeNumber(7)))).isFalse()
        );
    }

    @DisplayName("입력된 번호가 중복일 경우 예외 발생")
    @Test
    public void lottoNewThrownTest() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                makeNumber(1),
                makeNumber(1),
                makeNumber(3),
                makeNumber(4),
                makeNumber(5),
                makeNumber(6)
        );

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 있습니다 로또 번호는 6개여야 합니다");
    }

    @DisplayName("당첨번호와 비교했을 때 당첨 결과가 잘 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,16:5",
            "1,2,3,4,15,16:4",
            "1,2,3,14,15,16:3",
            "1,2,13,14,15,16:0"
    }, delimiter = ':')
    public void getAwardResultTest(String input, int award) {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                makeNumber(1),
                makeNumber(2),
                makeNumber(3),
                makeNumber(4),
                makeNumber(5),
                makeNumber(6)
        );

        Lotto lotto = new Lotto(numbers);

        // 2등 당첨 확인은 다른 테스트를 통해 진행합니다
        // bonus 는 45로 fix 합니다
        LottoWinningNumber winningNumber = new LottoWinningNumber(input, 45);

        // when & then
        assertThat(lotto.getAwardResult(winningNumber))
                .isEqualTo(LottoAward.valueOf(award, false));
    }

    @DisplayName("2등 담청(보너스) 확인")
    @Test
    public void getSecondAwardTest() {
        // given
        List<LottoNumber> numbers = Arrays.asList(
                makeNumber(1),
                makeNumber(2),
                makeNumber(3),
                makeNumber(4),
                makeNumber(5),
                makeNumber(6)
        );

        Lotto lotto = new Lotto(numbers);
        LottoWinningNumber winningNumber = new LottoWinningNumber("1,2,3,4,5,45", 6);

        // when & then
        assertThat(lotto.getAwardResult(winningNumber)).isEqualTo(LottoAward.SECOND);
    }

    private LottoNumber makeNumber(int num) {
        return new LottoNumber(num);
    }
}
