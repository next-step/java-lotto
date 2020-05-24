package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class NumbersTest {

    @DisplayName("List<String>을 가진 일급 컬렉션 Number 생성 테스트")
    @Test
    public void makeNumberCollection() {
        InputParser inputParser = new InputParser();
        List<String> parsedInput = inputParser.parseInput("1:2:3:4:5:6:7");
        assertThatCode(() -> {
            Numbers numbers = new Numbers(parsedInput);
        }).doesNotThrowAnyException();
    }
}
