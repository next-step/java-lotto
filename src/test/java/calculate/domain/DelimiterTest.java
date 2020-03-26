package calculate.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    @DisplayName("생성자 비교 테스트")
    @Test
    public void construct() throws Exception {
        //given
        Delimiter delimiter1 = new Delimiter(";");
        Delimiter delimiter2 = new Delimiter(";");

        //then
        assertThat(delimiter1.equals(delimiter2)).isTrue();
    }
}
