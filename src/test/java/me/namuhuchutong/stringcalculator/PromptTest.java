package me.namuhuchutong.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PromptTest {

    private static final String NEW_LINE = "\n";
    private static final String TEST = "test";

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    private void setIn(String givenInput) {
        String input = createInputString(givenInput);
        System.setIn(convertForInputStream(input));
    }

    private String createInputString(String givenInput) {
        return givenInput + NEW_LINE;
    }

    private ByteArrayInputStream convertForInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("빈 공백을 입력할 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_input_is_blank() {
        //given
        String given = "";
        setIn(given);
        Prompt prompt = new Prompt();

        //when, then
        assertThatThrownBy(() -> prompt.showStringPrompt(TEST))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 문자열의 공백은 전부 제거된다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 2 44 32 2 1",
            "1 * 2 - 3 / 5 + 2",
            "asdfas adsfas ",
            "@#$#@ sd 234"
    })
    void given_string_should_remove_white_space(String given) {
        //given
        setIn(given);
        Prompt prompt = new Prompt();

        //when
        String trimmedString = prompt.showStringPrompt(TEST);
        boolean result = trimmedString.contains(" ");

        //then
        assertThat(result).isFalse();
    }
}
