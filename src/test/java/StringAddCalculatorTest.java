import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertTaht(result).isEqualTo(6);
    }
}
