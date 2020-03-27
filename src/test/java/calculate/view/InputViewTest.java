package calculate.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3:;", "//,\\n ,2,,4:,"}, delimiter = ':')
    public void constructor(String input, String expect) throws Exception {
        //given
        InputView inputView = new InputView(input);
        assertThat(inputView.getDelimiter()).isEqualTo(expect);
    }
}
