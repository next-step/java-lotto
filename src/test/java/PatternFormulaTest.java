import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternFormulaTest {
    private final static String REGEX = "(\\/\\/.\\\\n)?((\\d+)(,|:|,))+(\\d+)";
    private final static String COMMA_TEST_FORMULA = "1,2,3";
    private final static String COLON_TEST_FORMULA = "1:2:3";
    private final static String MIX_TEST_FORMULA = "1,2:3";
    private final static String FORMULA_WITH_CUSTOM_SEPARATOR = "//;\n1;2;3";
    private final static String INCORRECT_CUSTOM_SEPARATOR_FORMULA = "//\n1;2;3";
    private final static String INCORRECT_CUSTOM_SEPARATOR_FORMULA2 = "//aa\n1;2;3";
    private final static String CUSTOM_SEPARATOR = ";";
    private final static String NUMBER_FORMULA = "1;2;3";
    private final static String NOT_FORMULA = "asdgasf";
    
    @Test
    @DisplayName("커스텀 구분자를 구분해낸다.")
    void separateCustomSeparatorTest() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_CUSTOM_SEPARATOR);
        //When`
        boolean hasCustomSeparator = formula.hasCustomSeparator(CUSTOM_SEPARATOR);
        //Then
        Assertions.assertThat(hasCustomSeparator).isTrue();
    }
    
    @Test
    @DisplayName("커스텀 구분자를 구분해낼 수 없는 문자열이면 IllegalArgumentsException")
    void separateCustomSeparatorExceptionTest() {
        //Given
        //When
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula(INCORRECT_CUSTOM_SEPARATOR_FORMULA))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("커스텀 구분자가 2자리 이상인 경우 : 불가")
    void test() {
        //Given
        //When
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula(INCORRECT_CUSTOM_SEPARATOR_FORMULA2))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
    
    @Test
    @DisplayName("구분자 부분이 제외된 나머지 문자열을 구분해낸다.")
    void getFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_CUSTOM_SEPARATOR);
        //When
        //Then
        Assertions.assertThat(formula.equalsNumberFormula(NUMBER_FORMULA)).isTrue();
    }
    
    @Test
    @DisplayName("쉼표만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void separateCommaFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula(COMMA_TEST_FORMULA);
        //When
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
        
    @Test
    @DisplayName("콜론만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void catSplitColonTest() {
        //Given
        PatternFormula formula = new PatternFormula(COLON_TEST_FORMULA);
        //When
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표와 콜론이 섞여있는 경우 : 분리 가능")
    void canSplitCommaAndColonTest() {
        //Given
        PatternFormula formula = new PatternFormula(MIX_TEST_FORMULA);
        //When
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표, 콜론 외의 커스텀 구분자가 함께 들어온 경우 : 분리 가능")
    void canSplitMixedFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_CUSTOM_SEPARATOR);
        //When
        //Then
        Assertions.assertThat(formula).isNotNull();
    }
    
    @Test
    @DisplayName("정확하지 않은 임의의 문자열이 들어온 경우")
    void separateNon() {
        //Given
        //When
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new PatternFormula(NOT_FORMULA))
          .withMessage(ErrorMessage.INCORRECT_VALUE.getMessage());
    }
}
