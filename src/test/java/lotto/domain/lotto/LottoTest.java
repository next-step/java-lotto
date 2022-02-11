package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.correctnumber.CorrectNumbers;
import lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private final Set<LottoNumber> lottoNumbers = createLottoNumbers(1,2,3,4,5,6);

    @DisplayName("숫자 리스트를 받아 객체를 생성, 숫자 리스트를 잘 가지고 있다.")
    @Test
    void Given_숫자_리스트_When_객체_생성_Then_숫자_리스트를_잘_가지고_있음() {
        // given
        Set<LottoNumber> numbers = lottoNumbers;

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.get()).isEqualTo(numbers);
    }

    @DisplayName("정답 번호와 비교해서 맞은 수를 반환한다.")
    @Test
    void Given_정답_번호_When_로또_번호와_비교_Then_맞은_수_반환() {
        // given
        Lotto lotto = new Lotto(lottoNumbers);
        Set<LottoNumber> winnigNumbers = createLottoNumbers(1,2,3,4,5,7);

        // when
        int matchNumber = lotto.matchNumber(winnigNumbers);

        // then
        assertThat(matchNumber).isEqualTo(5);
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하여 true 를 반환한다.")
    @Test
    void Given_보너스_번호_When_포함하는지_비교_Then_true_반환() {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean isBonus = lotto.contains(new LottoNumber(5));

        // then
        assertThat(isBonus).isEqualTo(true);
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하지 않아 false 를 반환한다.")
    @Test
    void Given_보너스_번호_When_포함하는지_비교_Then_false_반환() {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean isBonus = lotto.contains(new LottoNumber(7));

        // then
        assertThat(isBonus).isEqualTo(false);
    }

    @DisplayName("정상적인 입력을 가지고 객체를 생성할 때 예외가 발생하지 않는다.")
    @Test
    void Given_정상_입력_When_객체_생성_Then_예외가_발생하지_않음() {
        // given
        final String input = "1,2,3,4,5,6";

        // then
        assertDoesNotThrow(() -> new CorrectNumbers(input, "7"));
    }

    @DisplayName("입력형식 (숫자 + 구분자) 이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1;2;3;4;5;6", "123456", "1,2,3,4,5,a"})
    @ParameterizedTest
    void Given_유효하지_않은_입력형식_When_객체_생성_Then_예외_발생(final String input) {
        // then
        assertThrows(IllegalArgumentException.class,
                () -> new CorrectNumbers(input, "7"));
    }

    @DisplayName("숫자 개수가 6개가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @ParameterizedTest
    void Given_숫자가_6개가_아닌_입력_When_객체_생성_Then_예외_발생(final String input) {
        // then
        assertThrows(IllegalArgumentException.class,
                () -> new CorrectNumbers(input, "7"));
    }

    private Set<LottoNumber> createLottoNumbers(int... numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int num : numbers) {
            lottoNumbers.add(new LottoNumber(num));
        }

        return lottoNumbers;
    }
}
