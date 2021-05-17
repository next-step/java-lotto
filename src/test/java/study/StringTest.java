package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    public void split() {
        //given
        String input = "1,2";

        //when
        String[] splitedInput = input.split(",");

        //then
        assertThat(splitedInput[0]).isEqualTo("1");
        assertThat(splitedInput[1]).isEqualTo("2");
    }
}
