package stringaddcalculator.calculator;

import stringaddcalculator.view.InputView;
import stringaddcalculator.view.ResultView;

public class StringAddCalculator {

    private InputView inputView;
    private ResultView ResultView;

    public StringAddCalculator(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.ResultView = resultView;
    }

    public void operator(){
        String input = inputView.input();

    }


    
}