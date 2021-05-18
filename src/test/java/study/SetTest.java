package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> number;

    @BeforeEach
    void setUp() {
        number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);
    }

    @Test
    @DisplayName("Set에 해당 값이 포함되어 있는지 테스트")
    void contains() {
        assertThat(number.contains(1)).isEqualTo(true);
        assertThat(number.contains(2)).isTrue();
        assertThat(number.contains(4)).isFalse();
    }

    @ParameterizedTest
    @ValueSource( ints = {1,2,3} )
    @DisplayName("int 배열을 파라미터로 받아 중복 체크 코드 제거")
    void isContain_ShouldReturnTrueContain(int i) {
        assertThat(number.contains(i)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "4:false"}, delimiter = ':')
    @DisplayName("해당 값 포함 여부에 따라 true / false 테스트")
    void isContain_ShouldGeneratedTheExceptionContain(int i, boolean yn){
        assertThat(number.contains(i)).isEqualTo(yn);
    }
}
