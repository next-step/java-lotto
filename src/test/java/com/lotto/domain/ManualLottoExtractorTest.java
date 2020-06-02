package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualLottoExtractorTest {

    @DisplayName("수동 로또 입력 테스트 : 정상")
    @ParameterizedTest
    @MethodSource("provideAvailableLottoNumbers")
    void extractLottoNumbersTest(final List<Integer> availableLottoNumbers) {
        ManualLottoExtractor extractor = new ManualLottoExtractor();
        List<Integer> extractedLottoNumbers = extractor.extractLottoNumbers(availableLottoNumbers);

        assertEquals(extractedLottoNumbers.size(), 6);
    }

    private static Stream<Arguments> provideAvailableLottoNumbers() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(7, 8, 9, 10, 11, 12)
                )
        );
    }

    @DisplayName("수동 로또 입력 테스트 : 비정상 - 중복된 값이 들어간 경우")
    @ParameterizedTest
    @MethodSource("provideDuplicateLottoNumbers")
    void extractDuplicateLottoNumbersTest(final List<Integer> availableLottoNumbers) {
        ManualLottoExtractor extractor = new ManualLottoExtractor();
        assertThatThrownBy(() -> extractor.extractLottoNumbers(availableLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideDuplicateLottoNumbers() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 3, 3, 3),
                        Arrays.asList(7, 8, 9, 11, 11, 11)
                )
        );
    }

    @DisplayName("수동 로또 입력 테스트 : 비정상 - 6자리 숫자를 입력하지 않는 경우")
    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbers")
    void extractInvalidLottoNumbersTest(final List<Integer> availableLottoNumbers) {
        ManualLottoExtractor extractor = new ManualLottoExtractor();
        assertThatThrownBy(() -> extractor.extractLottoNumbers(availableLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                        Arrays.asList(7, 8, 9, 10)
                )
        );
    }
}
