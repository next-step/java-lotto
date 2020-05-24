package com.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShuffleLottoExtractorTest {

    @ParameterizedTest
    @MethodSource("provideAvailableLottoNumbers")
    void extractLottoNumbersTest(final List<Integer> availableLottoNumbers) {
        ShuffleLottoExtractor extractor = new ShuffleLottoExtractor();
        List<Integer> extractedLottoNumbers = extractor.extractLottoNumbers(availableLottoNumbers);

        assertEquals(extractedLottoNumbers.size(), 6);
        checkExtractedLottoNumberSorted(extractedLottoNumbers);
    }

    private void checkExtractedLottoNumberSorted(final List<Integer> extractedLottoNumbers) {
        for (int i = 1; i < extractedLottoNumbers.size(); i++) {
            Integer compared = extractedLottoNumbers.get(i - 1);
            Integer target = extractedLottoNumbers.get(i);
            checkEachValue(compared, target);
        }
    }

    private void checkEachValue(Integer compared, Integer target) {
        assertTrue(compared < target);
    }

    private static Stream<Arguments> provideAvailableLottoNumbers() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                        Arrays.asList(11, 13, 16, 9, 5, 6, 20, 21, 34, 10)

                )
        );
    }
}
