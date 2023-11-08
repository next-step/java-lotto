package step1;

import step1.domain.Seperator;
import step1.view.InputView;

public class Runner {

    public static void main(String[] args) {
        String text = InputView.inputText();
        Seperator.validate(text);
    }

}
