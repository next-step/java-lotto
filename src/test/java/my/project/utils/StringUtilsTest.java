package my.project.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-20 오전 11:57
 * Developer : Seo
 */
class StringUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("@ValueSource 학습")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("@NullSource 학습")
    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("@EmptySource 학습")
    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("@NullAndEmptySource 학습")
    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("@NullAndEmptySource + @ValueSource 학습")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    @DisplayName("@MethodSource 학습")
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertThat(StringUtils.isBlank(input)).isTrue();
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true)
        );
    }

}