package calculator;

import calculator.domain.Calculator;
import calculator.domain.Input;
import calculator.util.MessageConverter;
import calculator.view.InputView;

import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public class Application {

    public static void main(String[] args) {
        List<Input> convert = MessageConverter.convert(InputView.read());

        Calculator calculator = new Calculator();

        for (Input input : convert) {
            calculator.process(input);
        }

        int result = calculator.getResult();

        System.out.println(result);
    }
}
