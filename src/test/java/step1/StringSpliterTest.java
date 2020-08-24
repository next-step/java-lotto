package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSpliterTest {

    @ParameterizedTest
    @ValueSource(strings={"//=\n1=2=3","//;\n2;2;5"})
    void findCustomDelimiterTest(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        assertThat(m.find()).isEqualTo(true);

    }
}
