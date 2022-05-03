package lotto;

import lotto.model.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 클래스 테스트")
public class LottoNumberTest {

    public static final LottoNumber ONE = LottoNumber.valueOf(1);
    public static final LottoNumber TWO = LottoNumber.valueOf(2);
    public static final LottoNumber THREE = LottoNumber.valueOf(3);
    public static final LottoNumber FOUR = LottoNumber.valueOf(4);
    public static final LottoNumber FIVE = LottoNumber.valueOf(5);
    public static final LottoNumber SIX = LottoNumber.valueOf(6);

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("범위에 맞지 않는 숫자로 로또 번호를 생성하면 예외가 발생한다.")
    void invalidRangeTest(int number) {
        Assertions.assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1에서 45사이의 값만 가질 수 있습니다.");
    }

    @Test
    @DisplayName("로또 번호 값이 같으면 equals 가 true 이다")
    void lottoNumberEqualsTest() {
        LottoNumber one = LottoNumber.valueOf(1);
        LottoNumber oneCompare = LottoNumber.valueOf(1);

        assertThat(one).isEqualTo(oneCompare);
    }

    @Test
    @DisplayName("로또 번호 값이 다르면 equals 가 false 이다")
    void lottoNumberNotEqualsTest() {
        LottoNumber one = LottoNumber.valueOf(1);
        LottoNumber two = LottoNumber.valueOf(2);

        assertThat(one).isNotEqualTo(two);
    }
}
