package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class NumbersTest {

    @DisplayName("Numbers 컬렉션 정상 생성 테스트")
    @ParameterizedTest
    @CsvSource({"1:2:3:4:5, 5", "//!\n1!3!4", "3"})
    public void makeNumbersObject(String input, int size) {
        List<Integer> parsedNumbers = StringParser.parseString(input);
        assertThatCode(() -> {
            Numbers numbers = new Numbers(parsedNumbers);
        }).doesNotThrowAnyException();
    }
}
