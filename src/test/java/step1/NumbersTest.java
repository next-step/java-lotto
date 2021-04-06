package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @ParameterizedTest(name = "음수또는 숫자 타입 검증하는 테스트")
    @ValueSource(strings = {"-1", "$","a"})
    void isNotNumberOrNegativeNumber(String given) {

        assertThrows(RuntimeException.class, () -> {
            if(Integer.parseInt(given)<0){
                throw new RuntimeException();
            }
        });
    }

    @Test
    @DisplayName("number getter 테스트")
    void getNumbers(){
        // given
        String given = "1,3,5";

        // when
        Numbers numbers = new Numbers(given, new StringSplitter());
        List<Integer> actual = numbers.getNumbers();

        // then
        assertThat(actual).containsExactly(1,3,5);
    }
}
