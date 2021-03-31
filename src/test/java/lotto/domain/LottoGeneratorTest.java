package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void init() {
        lottoGenerator = LottoGenerator.getInstance();
    }

    @DisplayName("로또 난수 6개 생성")
    @ParameterizedTest
    @ValueSource(ints = {6, 6, 6})
    void getShuffledLottoNumbers(int expected) {
        LottoNumbers lottoNumbers = lottoGenerator.generateShuffledLotto();
        assertThat(lottoNumbers.getSize()).isEqualTo(expected);
    }

    @DisplayName("지정번호 6개 생성")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void getSixLottoNumbers(String lottoNumberArray, int[] expected) {
        LottoNumbers lottoNumbers = lottoGenerator.generateAppointedLotto(lottoNumberArray);
        LottoNumbers expectedNumbers = LottoNumbers.of(new TreeSet(
                Arrays.stream(expected)
                        .boxed()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
        ));
        assertThat(lottoNumbers).isEqualTo(expectedNumbers);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of("1, 3, 5, 7, 9, 11", new int[] {1, 3, 5, 7, 9, 11}),
                Arguments.of("1, 3, 5, 7, 9, 45", new int[] {1, 3, 5, 7, 9, 45}),
                Arguments.of("1, 3, 5, 7, 10, 43", new int[] {1, 3, 5, 7, 10, 43})
        );
    }
}
