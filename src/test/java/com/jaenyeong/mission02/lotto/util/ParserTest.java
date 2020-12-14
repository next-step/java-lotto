package com.jaenyeong.mission02.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.jaenyeong.mission02.lotto.util.Parser.parseWinningNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("입력 값을 파싱해주는 Parser 클래스 테스트")
class ParserTest {

    @ParameterizedTest
    @MethodSource("inputStringWhatIsWinningNumbers")
    @DisplayName("입력받은 당첨번호 문자열을 리스트 객체로 반환하는 테스트")
    void checkReturnWinningNumbersList(final String winningNumberString) {
        final String[] splitWinningNumbers = winningNumberString.split(", ");
        final List<Integer> winningNumbers = parseWinningNumbers(winningNumberString);

        assertEquals(splitWinningNumbers.length, winningNumbers.size());
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            assertEquals(Integer.parseInt(splitWinningNumbers[i]), winningNumbers.get(i));
        }
    }

    private static Stream<Arguments> inputStringWhatIsWinningNumbers() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6"),
            Arguments.of("7, 18, 22, 36, 44, 15"),
            Arguments.of("5, 12, 41, 13, 35, 11"),
            Arguments.of("2, 4, 5, 10, 32, 27"),
            Arguments.of("1, 9, 7, 43, 14, 28")
        );
    }
}
