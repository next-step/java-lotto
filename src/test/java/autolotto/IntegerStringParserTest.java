package autolotto;

import calculator.parser.converter.IntegerStringConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class IntegerStringParserTest {

    @Test
    void delimiter_를_기준으로_문자열을_쪼개어_문자열_리스트를_반환한다() {
        String delimiter = ", ";
        IntegerStringParser parser = new IntegerStringParser(delimiter, new IntegerStringConverter());

        String input = "1, 2, 3, 4, 5, 6";

        Assertions.assertThat(parser.parse(input))
                .containsExactly(1,2,3,4,5,6);
    }
}
