import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpliterTest {
    private final static String[] SPLIT_RESULT_NUMBERS = {"1", "2", "3", "4"};
    private final static String CUSTOM_SEPARATOR_FORMULA = "//;\n1;2,3:4";
    private final static String COMMA = ",";
    private final static String COLON = ":";
    
    @Test
    @DisplayName("위의 기준으로 분리가 가능하면 쉼표와 콜론으로 문자열을 분리한다.")
    void separateTest() {
        Spliter spliter = new Spliter(COMMA, COLON);
        //When
        String[] splitNumbers = spliter.split(CUSTOM_SEPARATOR_FORMULA);
        //Then
        Assertions.assertThat(splitNumbers).containsExactly(SPLIT_RESULT_NUMBERS);
    }
}
