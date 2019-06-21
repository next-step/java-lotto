import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormulaTest {
    //    - 쉼표만으로 구분된 문자열이 들어온 경우 : 분리 가능
//    - 콜론만으로 구분된 문자열이 들어온 경우 : 분리 가능
//    - 쉼표와 콜론이 섞여있는 경우 : 분리 가능
//    - 쉼표와 콜론과 숫자가 아닌 문자열이 포함된 경우 : 불가능
    private static final String[] RESULT_NUMBERS = {"1", "2", "3"};;
    
    @Test
    @DisplayName("쉼표만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void splitCommaSeparateStringTest() {
        //Given
        Formula formula = new Formula("1,2,3");
        //When
        String[] separatedNumbers = formula.getSeparatedNumber();
        //Then
        assertThat(separatedNumbers).containsExactly(RESULT_NUMBERS);
    }
    
    @Test
    @DisplayName("콜론만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void splitColonSeparateStringTest() {
        //Given
        Formula formula = new Formula("1:2:3");
        //When
        String[] separatedNumbers = formula.getSeparatedNumber();
        //Then
        assertThat(separatedNumbers).containsExactly(RESULT_NUMBERS);
    }
    
    @Test
    @DisplayName("쉼표와 콜론이 섞여있는 경우 : 분리 가능")
    void splitMixSeparateStringTest() {
        //Given
        Formula formula = new Formula("1,2:3");
        //When
        String[] separatedNumbers = formula.getSeparatedNumber();
        //Then
        assertThat(separatedNumbers).containsExactly(RESULT_NUMBERS);
    }
    
    @Test
    @DisplayName("커스텀 구분자를 구분해낸다.")
    void getCustomSeparatorTest() {
        //Given
        Formula colonFormula = new Formula("//;\\n1;2;3");
        //When
        String colonSeparator = colonFormula.getCustomSeparator();
        //Then
        assertThat(colonSeparator).isEqualTo(";");
    
        //Given
        Formula starFormula = new Formula("//*\\n1*2*3");
        //When
        String starSeparator = starFormula.getCustomSeparator();
        //Then
        assertThat(starSeparator).isEqualTo("*");
    }
}
