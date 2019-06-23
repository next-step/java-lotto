import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {
    @Test
    @DisplayName("분리된 숫자의 합을 반환.")
    void accumulateTest() {
        //Given
        int[] numbers = {1, 2, 3};
        int expectedResult = 6;
        //When
        int result = Accumulator.accumulate(numbers);
        //Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
    
    @Test
    @DisplayName("숫자가 아닌 문자열이 포함된 경우 : 불가능")
    void inputNotNumberTest() {
        //Given
        String[] notNumbers = {"a", "2", "3"};
        //When
        //Then
        Assertions.assertThatThrownBy(() -> Accumulator.accumulate(notNumbers)).isInstanceOf(RuntimeException.class);
        
    }
    
    @Test
    @DisplayName("음수면 : 불가능")
    void test() {
        //Given
        int[] minus = {-1, 0, 1};
        //When
        //Then
        Assertions.assertThatThrownBy(() -> Accumulator.accumulate(minus)).isInstanceOf(RuntimeException.class);
    }
}
