package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitorTest {

    @DisplayName(", | ; 구분 자르기")
    @Test
    void split() {
        StringSplitor splitor = new StringSplitor("1,2,3,4,5");
        String[] result = splitor.splitSeparator();
    }

}
