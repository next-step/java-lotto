package lottogame.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusLottoNumberTest {

    private static LottoNumbers lottoNumbers;

    @BeforeAll
    static void setup() {
        lottoNumbers = LottoNumbers.valueOf(List.of(2, 3, 4, 5, 6, 7));
    }

    @ParameterizedTest(name = "주어진 로또 숫자들과 다른 숫자로 생성하여 검증한다: {0}")
    @ValueSource(ints = {1, 8})
    void create(int number) {
        assertThat(new BonusLottoNumber(number, lottoNumbers)).isEqualTo(new BonusLottoNumber(number, lottoNumbers));
    }

    @ParameterizedTest(name = "주어진 로또 숫자들과 같은 숫자로 생성하여 예외를 검증한다: {0}")
    @ValueSource(ints = {2, 7})
    void createWithDuplicateNumber(int number) {
        assertThatThrownBy(() -> new BonusLottoNumber(number, lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("보너스 숫자는 당첨 번호와 같을 수 없습니다");
    }

    @ParameterizedTest(name = "일반 로또 숫자와 동등성을 비교한다: {0}")
    @ValueSource(ints = {1, 8})
    void testEquals(int number) {
        assertThat(new BonusLottoNumber(number, lottoNumbers)).isEqualTo(new LottoNumber(number));
        assertThat(new LottoNumber(number)).isEqualTo(new BonusLottoNumber(number, lottoNumbers));
    }

    @ParameterizedTest(name = "일반 로또 숫자와 해쉬코드를 비교한다: {0}")
    @ValueSource(ints = {1, 8})
    void testHashCode(int number) {
        assertThat(new BonusLottoNumber(number, lottoNumbers).hashCode()).isEqualTo(new LottoNumber(number).hashCode());
    }

    @ParameterizedTest(name = "일반 로또 숫자와 대소 비교를 테스트한다. {0}, {1}")
    @CsvSource({"8,9", "9,8", "8,8"})
    void testCompareTo(int number1, int number2) {
        assertThat(new BonusLottoNumber(number1, lottoNumbers).compareTo(new LottoNumber(number2)))
            .isEqualTo(new LottoNumber(number1).compareTo(new BonusLottoNumber(number2, lottoNumbers)));
    }
}
