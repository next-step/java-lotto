package lottogame.domain.lotto;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {
    @Test
    @DisplayName("6개 숫자들로 로또 숫자 콜렉션 생성 시 정렬되어서 보관")
    void orderedLottoTicket() {
        LottoNumbers lottoNumbers = new LottoNumbers(createLottoNumberList(6, 5, 3, 4, 1, 2));
        List<LottoNumber> expected = createLottoNumberList(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.getValue()).isEqualTo(expected);
    }

    @Test
    @DisplayName("중복 숫자들로 로또 숫자 콜렉션 생성 시 예외 생성")
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> new LottoNumbers(createLottoNumberList(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복이 없어야 합니다");
    }

    @ParameterizedTest(name = "6개보다 적은 숫자로 로또 숫자 콜렉션 생성 시 예외 생성: {1}개")
    @MethodSource("provideInvalidLottoNumbers")
    void createWithNotEnoughNumbers(List<LottoNumber> lottoNumbers, int numberCount) {
        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("6개여야 합니다");
    }

    @ParameterizedTest(name = "서로 다른 두 로또 숫자 콜렉션들이 주어졌을 때, 같은 숫자 갯수를 센다: {1}개")
    @MethodSource("provideLottoNumbers")
    void countSameNumbers(List<LottoNumber> numbers, int expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(createLottoNumberList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.countSameNumbers(new LottoNumbers(numbers))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "로또 숫자들이 주어졌을 때 해당 숫자가 포함되어 있는지 체크한다: {1}개")
    @CsvSource({
        "1,true",
        "6,true",
        "7,false"
    })
    void hasNumber(int number, boolean expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(createLottoNumberList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.hasNumber(new LottoNumber(number))).isEqualTo(expected);
    }

    private static List<LottoNumber> createLottoNumberList(int... numbers) {
        return Arrays.stream(numbers)
            .mapToObj(LottoNumber::new)
            .collect(toList());
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
            Arguments.of(createLottoNumberList(20, 30, 40, 7, 8, 9), 0),
            Arguments.of(createLottoNumberList(1, 2, 6, 7, 8, 9), 3),
            Arguments.of(createLottoNumberList(1, 2, 3, 4, 5, 6), 6)
        );
    }

    private static Stream<Arguments> provideInvalidLottoNumbers() {
        return Stream.of(
            Arguments.of(createLottoNumberList(1), 1),
            Arguments.of(createLottoNumberList(1, 2, 3, 4, 5), 5)
        );
    }
}
