import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternFormulaTest {
    @Test
    @DisplayName("커스텀 구분자를 구분해낸다.")
    void separateCustomSeparatorTest() {
        //Given
        PatternFormula formula = new PatternFormula("//;\n1;2;3");
        //When`
        boolean hasCustomSeparator = formula.hasCustomSeparator(";");
        //Then
        Assertions.assertThat(hasCustomSeparator).isTrue();
    }
    
    @Test
    @DisplayName("커스텀 구분자를 구분해낼 수 없는 문자열이면 IllegalArgumentsException")
    void separateCustomSeparatorExceptionTest() {
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula("//\n1;2;3"))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("커스텀 구분자가 2자리 이상인 경우 : 불가")
    void test() {
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula("//aa\n1;2;3"))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("구분자 부분이 제외된 나머지 문자열을 구분해낸다.")
    void getFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula("//;\n1;2;3");
        //When
        //Then
        Assertions.assertThat(formula.equalsNumberFormula("1;2;3")).isTrue();
    }
    
    @Test
    @DisplayName("쉼표만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void separateCommaFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula("1,2,3");
        //When
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
        
    @Test
    @DisplayName("콜론만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void catSplitColonTest() {
        //Given
        PatternFormula formula = new PatternFormula("1:2:3");
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표와 콜론이 섞여있는 경우 : 분리 가능")
    void canSplitCommaAndColonTest() {
        //Given
        PatternFormula formula = new PatternFormula("1,2:3");
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표, 콜론 외의 커스텀 구분자가 함께 들어온 경우 : 분리 가능")
    void canSplitMixedFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula("//;\n1;2;3");
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("정확하지 않은 임의의 문자열이 들어온 경우")
    void separateNon() {
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula("asdgasf"))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
}
