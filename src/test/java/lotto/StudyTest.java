package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudyTest {

    @Test
    @DisplayName("구분자(, ) split 테스트")
    void splitCommaBlankTest() {
        String string = "2, 4, 5, 6, 7, 8";
        for (String number : string.split(", ")) {
            System.out.println(number);
        }
    }
}
