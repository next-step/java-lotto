package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentCalculationResultTest {

    public static final int TEST_CURRENT_NUMBER = 5;
    public static final int TEST_CURRENT_ZERO_NUMBER = 0;
    CurrentCalculationResult currentCalculationResult;

    @ParameterizedTest()
    @CsvSource(value = {"5+1,6","5-1,4","2*2,4","2/2,1"})
    void calculate_테스트(String mathExpression, int resultNumber) {
        CurrentCalculationResult currentCalculationResult = new CurrentCalculationResult(TEST_CURRENT_ZERO_NUMBER);
        currentCalculationResult.calculate(mathExpression);
        assertThat(currentCalculationResult).isEqualTo(new CurrentCalculationResult(resultNumber));
    }


    @ParameterizedTest()
    @CsvSource(value = {"5,5+1,1,6","5,5-1,1,4","2,2*2,1,4","2,2/2,1,1"})
    void runCalculate_테스트(int firstResult, String mathExpression, int MathExpressionIndex, int resultNumber) {
        currentCalculationResult = new CurrentCalculationResult(firstResult);
        currentCalculationResult.runCalculate(mathExpression,MathExpressionIndex);
        assertThat(currentCalculationResult).isEqualTo(new CurrentCalculationResult(resultNumber));
    }

    @ParameterizedTest()
    @CsvSource(value = {"+,1,6","-,2,3","*,1,5","/,2,2"})
    void choiceCalculate_테스트(String currentOperator, int nextNumber, int resultNumber) {
        currentCalculationResult = new CurrentCalculationResult(TEST_CURRENT_NUMBER);
        currentCalculationResult.choiceCalculate(currentOperator,nextNumber);
        assertThat(currentCalculationResult).isEqualTo(new CurrentCalculationResult(resultNumber));
    }




}
