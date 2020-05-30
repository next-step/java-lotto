package stringAddCalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitTest {

    @Test
    @DisplayName(", : 구분자가 잘 쪼개지는지 체크")
    void commaOrColonSplit() {
        String[] result = StringSplit.split("2,3:4");
        String[] expect = {"2", "3", "4"};

        assertThat(result).hasSize(expect.length).containsOnly(expect);
    }

    @Test
    @DisplayName("CUSTOM_DELIMITER 체크")
    void customSplit() {
        String[] result = StringSplit.split("//@\n9@8@7");
        String[] expect = {"9", "8", "7"};

        assertThat(result).hasSize(expect.length).containsExactly(expect)
                .containsOnly(expect);
    }
}
