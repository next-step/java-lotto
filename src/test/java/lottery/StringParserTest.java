package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.StringParser;
import lottery.view.ViewMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
/*
    @DisplayName("지난주 당첨번호 입력값을 List<LotteryNumber>로 파싱하는 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryNumbersBuilder")
    public void parseStringIntoLotteryNumberList(String userInput) {
        List<Integer> lotteryNumbers = StringParser.parseString(userInput)
                .stream()
                .map(LotteryNumber::getLotteryNumber)
                .collect(Collectors.toList());
        List<Integer> originNumbersList = Arrays.stream(userInput.split(ViewMessages.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThat(lotteryNumbers).hasSameElementsAs(originNumbersList);
    }

    private static Stream<Arguments> mockLotteryNumbersBuilder() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6"),
                Arguments.of("11, 22, 33, 44, 15, 16"),
                Arguments.of("4, 6, 2, 3, 1, 8")
        );
    }*/
}
