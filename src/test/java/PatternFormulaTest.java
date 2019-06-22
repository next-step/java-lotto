import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternFormulaTest {
    private final static String REGEX = "(\\/\\/;\\\\n)?((\\d+)(,|:|;))+(\\d+)";
    private final static String COMMA_TEST_FORMULA = "1,2,3";
    private final static String COLON_TEST_FORMULA = "1:2:3";
    private final static String MIX_TEST_FORMULA = "1,2:3";
    private final static String FORMULA_WITH_CUSTOM_SEPARATOR = "//;\n1;2;3";
    private final static String FORMULA_WITH_INCORRECT_SEPARATOR = "//;\n1;2;3*4";
    private final static String CUSTOM_SEPARATOR = ";";
    
    @Test
    @DisplayName("커스텀 구분자를 구분해낸다.")
    void separateCustomSeparator() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_CUSTOM_SEPARATOR);
        //When
        String customSeparator = formula.getCustomSeparator();
        //Then
        Assertions.assertThat(customSeparator).isEqualTo(CUSTOM_SEPARATOR);
    }
    
    @Test
    @DisplayName("쉼표만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void separateCommaFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula(COMMA_TEST_FORMULA);
        //When
        boolean patternMatch = formula.matchPattern(REGEX);
        //Then
        Assertions.assertThat(patternMatch).isTrue();
    }
        
    @Test
    @DisplayName("콜론만으로 구분된 문자열이 들어온 경우 : 분리 가능")
    void catSplitColonTest() {
        //Given
        PatternFormula formula = new PatternFormula(COLON_TEST_FORMULA);
        //When
        boolean patternMatch = formula.matchPattern(REGEX);
        //Then
        Assertions.assertThat(patternMatch).isTrue();
    }
    
    @Test
    @DisplayName("쉼표와 콜론이 섞여있는 경우 : 분리 가능")
    void canSplitCommaAndColonTest() {
        //Given
        PatternFormula formula = new PatternFormula(MIX_TEST_FORMULA);
        //When
        boolean patternMatch = formula.matchPattern(REGEX);
        //Then
        Assertions.assertThat(patternMatch).isTrue();
    }
    
    @Test
    @DisplayName("쉼표, 콜론 외의 커스텀 구분자가 함께 들어온 경우 : 분리 가능")
    void canSplitMixedFormulaTest() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_CUSTOM_SEPARATOR);
        //When
        boolean patternMatch = formula.matchPattern(REGEX);
        //Then
        Assertions.assertThat(patternMatch).isTrue();
    }
    
    @Test
    @DisplayName("쉼표, 콜론, 커스텀 구분자, 숫자 외 다른 문자열이 포함된 경우 : 분리 불가")
    void throwExceptionTest() {
        //Given
        PatternFormula formula = new PatternFormula(FORMULA_WITH_INCORRECT_SEPARATOR);
        //When
        boolean patternMatch = formula.matchPattern(REGEX);
        //Then
        Assertions.assertThat(patternMatch).isFalse();
    }
}
