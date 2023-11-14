package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CharacterParserTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_없는_경우_오류(String input) {
        CharacterParser characterParser = new CharacterParser();
        assertThatIllegalArgumentException().isThrownBy(()-> {
            characterParser.parsingFormula(input);
        });

    }
}