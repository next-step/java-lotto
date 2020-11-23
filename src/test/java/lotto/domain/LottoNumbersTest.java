package lotto.domain;

import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("LottoNumbers 인스턴스 생성 테스트")
    @Test
    public void createLottoNumberInstance() {
        //Given & When
        LottoNumbers lottoNumbers = new LottoNumbers((capacity) -> new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8)));

        //Then
        assertThat(lottoNumbers).isNotNull();
    }

    @DisplayName("유효하지 않는 로또 사이즈일 경우 예외처리")
    @ParameterizedTest
    @MethodSource("createNotValidLottoNumber")
    public void notValidLottoNumbersException(Set<Integer> lottoSet) {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers((capacity) -> new TreeSet<>(lottoSet));
        }).isInstanceOf(NotValidLottoNumberException.class);
    }

    static Stream<Arguments> createNotValidLottoNumber() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3))),
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5))),
                Arguments.of(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
        );
    }


    @DisplayName("유효하지 않는 로또번호일 경우 예외처리")
    @Test
    public void notValidLottoNumbersException() {
        assertThatThrownBy(() -> {

            LottoNumbers lottoNumbers = new LottoNumbers((capacity) -> new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 51, 11)));

        }).isInstanceOf(NotValidLottoNumberException.class);
    }

    @DisplayName("총 몇개의 숫자가 당첨여부와 맞는지 확인")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    public void countPrizeMatchLottoNumberTest(Set<Integer> numbers) {
        //Given
        LottoNumbers lottoNumbers = new LottoNumbers((capacity) -> new TreeSet<>(numbers));

        //When
        int result = lottoNumbers.countPrizeMatchLottoNumber(new PrizeLotto(new LottoNumbers(numbers)));

        //Then
        assertThat(result).isEqualTo(6);
    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8))),
                Arguments.of(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8))),
                Arguments.of(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8)))
        );
    }

    @DisplayName("당첨번호 숫자 크기가 로또 숫자 크기와 다를 경우 예외처리")
    @Test
    public void notValidPrizeNumber() {
        assertThatThrownBy(() ->

            new LottoNumbers((capacity) -> new TreeSet<>(Arrays.asList(1, 3, 5)))

        ).isInstanceOf(NotValidLottoNumberException.class);

    }

}
