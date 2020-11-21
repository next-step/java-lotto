package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    public int testLogic(String inputValue){
        inputValue = Validator.inputValueTest(inputValue);

        Tokenizer tokenizer = new Tokenizer();
        String[] stringValueList = tokenizer.splitValue(inputValue);

        Calculator calculator = new Calculator();

        return calculator.calculate(stringValueList);
    }

    @Test
    void mainTest(){
        String testInput = "1,2,3;4;5,6";
        int expectAnswer = 21;

        assertThat(testLogic(testInput)).isEqualTo(expectAnswer);


        testInput = "//~\n1~2~3~4";
        expectAnswer = 10;
        assertThat(testLogic(testInput)).isEqualTo(expectAnswer);

        testInput = "";
        expectAnswer = 0;
        assertThat(testLogic(testInput)).isEqualTo(expectAnswer);

        testInput = "6";
        expectAnswer = 6;
        assertThat(testLogic(testInput)).isEqualTo(expectAnswer);
    }
}
