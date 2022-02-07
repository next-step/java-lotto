package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private final List<LottoNumber> lottoNumbers = createLottoNumbers(
            Arrays.asList("1", "2", "3", "4", "5", "6"));

    @DisplayName("숫자 리스트를 받아 객체를 생성, 숫자 리스트를 잘 가지고 있다.")
    @Test
    void Given_숫자_리스트_When_객체_생성_Then_숫자_리스트를_잘_가지고_있음() {
        // given
        List<LottoNumber> numbers = lottoNumbers;

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
        List<LottoNumber> winnigNumbers = createLottoNumbers(
                Arrays.asList("1", "2", "3", "4", "5", "7"));

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
        boolean isBonus = lotto.containsBonusNumber(new LottoNumber("5"));

        // then
        assertThat(isBonus).isEqualTo(true);
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하지 않아 false 를 반환한다.")
    @Test
    void Given_보너스_번호_When_포함하는지_비교_Then_false_반환() {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean isBonus = lotto.containsBonusNumber(new LottoNumber("7"));

        // then
        assertThat(isBonus).isEqualTo(false);
    }

    private List<LottoNumber> createLottoNumbers(List<String> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String num : numbers) {
            lottoNumbers.add(new LottoNumber(num));
        }

        return lottoNumbers;
    }
}
