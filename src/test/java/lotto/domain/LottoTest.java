package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @Test
    @DisplayName("허용범위의 숫자(중복이 없고 / 1 ~ 45 사이 / 6자리)로 Lotto를 생성시 정상 생성된다.")
    void createLotto() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    @DisplayName("Lotto 객체를 다른 객체와 비교하여 동일한 숫자가 존재하는 개수 만큼 숫자를 반환한다.")
    void matchCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto baseLotto = new Lotto(numbers);

        int matchCount = baseLotto.matchCount(new Lotto(numbers));

        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("중복된 숫자로 Lotto를 생성시 오류가 발생한다.")
    void createLotto_중복숫자() {
        List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("6자리 미만의 숫자를 입력하여 Lotto를 생성시 오류가 발생한다.")
    void createLotto_6자리미만() {
        List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또의 숫자는 중복없이 6개여야 합니다.");
    }

    @Test
    @DisplayName("1 ~ 45 자리 외의 숫자로 Lotto를 생성시 오류가 발생한다.")
    void createLotto_범위초과() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 66);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또의 번호 범위를 벗어났습니다.");
    }

    @ParameterizedTest(name = "(1, 2, 3, 4, 5, 6)의 로또에 보너스 숫자 {0}의 포함여부를 확인한다. 결과 : {1}")
    @CsvSource({"1, true", "7, false"})
    @DisplayName("6자리의 로또에 보너스 숫자가 포함되어 있는지 확인한다.")
    void isContain(int bonusNumber, boolean expected) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.isContains(new LottoNumber(bonusNumber))).isEqualTo(expected);
    }
}