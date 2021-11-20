package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "2,1,1", "2,3,-1", "3,2,1"})
    @DisplayName("로또 객체 크기 비교 테스트")
    void lottoCompareTest(int first, int second, int expected){
        Lotto firstObj = new Lotto(first);
        Lotto secondObj = new Lotto(second);
        assertThat(firstObj.compareTo(secondObj)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("로또 객체 크기 비교 테스트")
    void lottoEqualsTest(int number) {
        assertThat(new Lotto(number)).isEqualTo(new Lotto(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,46,47,48} )
    @DisplayName("로또 정상 범위에 속하지 않을 때 예외 발생")
    void lottoNumberRangeTest(int number){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(number))
                .withMessage("로또 숫자 범위에 속하지 않습니다.");
    }
}