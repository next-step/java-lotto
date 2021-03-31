package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void init() {
        lottoGenerator = LottoGenerator.getInstance();
    }

    @DisplayName("자동으로 생성 - LottoNumber 6개로 구성된건지 체크")
    @ParameterizedTest
    @ValueSource(ints = {6, 6, 6})
    void lottoNumberOfAuto(int expected) {
        LottoNumbers lottoNumbers = lottoGenerator.generateShuffledLotto();
        assertThat(lottoNumbers.getSize()).isEqualTo(expected);
    }

    @DisplayName("수동으로 생성 - LottoNumber 6개로 구성된건지 체크")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void lottoNumberOfManual(String lottoStringNumber, int expected) {
        LottoNumbers lottoNumbers = lottoGenerator.generateAppointedLotto(lottoStringNumber);
        assertThat(lottoNumbers.getSize()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of("1, 3, 5, 7, 9, 11", 6),
                Arguments.of("1, 3, 5, 7, 9, 45", 6),
                Arguments.of("1, 3, 5, 7, 10, 43", 6)
        );
    }

    @DisplayName("LottoNumber contain 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 11})
    void lottoNumberContain(int number) {
        String lottoStringNumber = "1, 3, 5, 7, 9, 11";
        LottoNumbers lottoNumbers = lottoGenerator.generateAppointedLotto(lottoStringNumber);
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumbers.contains(lottoNumber)).isTrue();
    }
}