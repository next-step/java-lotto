package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSplitTest {
    @Test
    public void splitTest() {
        String[] test2 = {"1", "2", "3"};
        StringSplit stringSplit = new StringSplit("1,2,3");
        assertThat(stringSplit.splitWithDelimeter()).isEqualTo(test2);
    }

    @Test
    public void splitTest2() {
        String[] test = {"1", "2", "3"};
        StringSplit stringSplit = new StringSplit("1:2,3");
        assertThat(stringSplit.splitWithDelimeter()).isEqualTo(test);
    }

}
