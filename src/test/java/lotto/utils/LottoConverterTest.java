package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoConverterTest {

    @ValueSource(strings = {"1,2,3,4,5,6"})
    @ParameterizedTest
    @DisplayName(", 포함된 string을 LottoNumberSet으로 변환하고 크기를 검증한다.")
    void LottoNumberSet_변환_테스트(String input) {
        Set<LottoNumber> lottoNumberSet = LottoConverter.convertToLottoNumber(input);
        assertThat(lottoNumberSet).hasSize(6);
    }

    @MethodSource("generate_string_lotto_list")
    @ParameterizedTest
    @DisplayName(", 포함된 string List를 LottoNumber List로 변환하고 크기를 검증한다.")
    void convertToLottoNumbers_변환_테스트(List<String> manualLottoNumbers, int expectedSize) {
        List<LottoNumbers> lottoNumbers = LottoConverter.convertToLottoNumbers(manualLottoNumbers);
        assertThat(lottoNumbers).hasSize(expectedSize);
    }

    private static Stream<Arguments> generate_string_lotto_list() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"), 2)
        );
    }


}
