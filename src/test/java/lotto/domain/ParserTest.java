package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserTest {
    @Test
    @DisplayName("문자열을 ,을 기준으로 split하고 정수 리스트로 반환한다.")
    void splitAndParseToIntegerListTest() {
        String input = "1, 2,  3,  4";
        List<Integer> expected = List.of(1, 2, 3, 4);
        Parser parser = new Parser();

        List<Integer> result = parser.splitAndParseToIntegerList(input);

        Assertions.assertEquals(result, expected);
    }

    @Test
    @DisplayName("정수가 아니면 예외를 반환한다.")
    void splitAndParseToIntegerListTest_notInteger() {
        String input = "1, 2,  3,  A";
        Parser parser = new Parser();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.splitAndParseToIntegerList(input));
    }

}
