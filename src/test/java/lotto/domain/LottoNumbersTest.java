package lotto.domain;

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

public class LottoNumbersTest {

    @DisplayName("LottoNumbers 인스턴스 생성 테스트")
    @Test
    public void createLottoNumberInstance() {
        //Given & When
        LottoNumbers lottoNumbers = new LottoNumbers(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8)));

        //Then
        assertThat(lottoNumbers).isNotNull();
    }

    @DisplayName("총 몇개의 숫자가 당첨여부와 맞는지 확인")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    public void countPrizeMatchLottoNumberTest(Set<Integer> numbers) {
        //Given
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

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


}
