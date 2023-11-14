package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CharacterParserTest {

    @Test
    void 식을_받으면_리스트로_돌려준다() {
        CharacterParser characterParser = new CharacterParser();
        List<String> expected = List.of("1","+","3");
        assertEquals(expected, characterParser.parsingFormula("1 + 3"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_없는_경우_오류(String input) {
        CharacterParser characterParser = new CharacterParser();
        assertThatIllegalArgumentException().isThrownBy(()-> {
            characterParser.parsingFormula(input);
        });
    }

    @Test
    void 사칙연산기호가_아닌_경우_오류() {
        CharacterParser characterParser = new CharacterParser();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            characterParser.parsingFormula("1 ? 1");
        });
    }
}