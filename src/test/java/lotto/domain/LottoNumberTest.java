package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName(value = "정수로 LottoNumber 인스턴스 생성시, LottoNumber는 주어진 정수와 동일하다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 45})
    void GivenIntType_WhenCreateInstance_ThenGetNumberEqualToGivenIntType(
        int number) {
        final LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber.getLottoNumber())
            .isEqualTo(number);
    }

    @DisplayName(value = "범위를 벗어난 LottoNumber 인스턴스 생성시, RuntimeException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, -1, -10})
    void GivenOutOfLottoNumberRange_WhenCreateInstance_ThenRuntimeException(
        int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName(value = "동일한 정수를 갖는 lottoNumber에 대해 IsEqualTo 수행시, True 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 45})
    void GivenTwoLottoNumberWithTwoSameIntType_WhenIsEqualTo_ThenTrue(
        int number) {
        final LottoNumber lottoNumber = LottoNumber.from(number);
        final LottoNumber lottoNumber2 = LottoNumber.from(number);

        assertThat(lottoNumber.isEqualTo(lottoNumber2))
            .isEqualTo(true);
    }

    @DisplayName(value = "LottoNumber가 정수로된 리스트에 포함될 때 isInList() 수행시, True 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 45})
    void GivenLottoNumberWithIntTypeInListWithIntType_WhenIsInList_ThenTrue(
        int number) {
        final LottoNumber lottoNumber = LottoNumber.from(number);
        List<Integer> IntegerList = Arrays.asList(1, 2, 3, 10, 45);

        assertThat(lottoNumber.isInList(IntegerList))
            .isEqualTo(true);
    }
}