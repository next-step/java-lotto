package step1stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
         InputView inputView = new InputView();
    }

    @ParameterizedTest()
    @CsvSource(value = {"1,1,2","1,2,3","2,2,4"})
    public void 덧셈_테스트(int firstNumber, int secondNumber, int resultNumber) {

       // assertThat().isEqualTo(resultNumber);
    }




}






