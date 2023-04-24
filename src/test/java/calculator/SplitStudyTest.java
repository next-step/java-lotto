package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitStudyTest {

    @Test
    void split_학습테스트() {
        //given
        String s = "1   + 2 * 3 / 4";

        //when
        String[] arr = s.split(" ");

        //then
        assertThat(arr[0]).isEqualTo("1");
        assertThat(arr[1]).isEqualTo("");
        assertThat(arr[3]).isEqualTo("+");
    }
}
