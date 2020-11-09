package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parseNumStr() {
        Assertions.assertAll(
                () -> {
                    assertThatExceptionOfType(RuntimeException.class)
                            .isThrownBy(() -> {
                                Parser.parseNumStr("-1");
                            }).withMessageMatching(Parser.LESS_THAN_ZERO_EXCEPTION_MSG);
                },
                () -> {
                    assertThat(Parser.parseNumStr("1"))
                            .isEqualTo(1);
                }
        );
    }

    @Test
    void parseNumStrArr() {
        Assertions.assertAll(
                () -> {
                    String[] numStrArr = new String[] { "-1", "1" };
                    assertThatExceptionOfType(RuntimeException.class)
                            .isThrownBy(() -> {
                                Parser.parseNumStrArr(numStrArr);
                            }).withMessageMatching(Parser.LESS_THAN_ZERO_EXCEPTION_MSG);
                },
                () -> {
                    String[] numStrArr = new String[] { "1", "2" };
                    int[] expected = new int[] { 1,2 };
                    assertThat(Parser.parseNumStrArr(numStrArr))
                            .isEqualTo(expected);
                }
        );
    }
}
