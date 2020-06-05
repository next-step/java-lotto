package step1;

import step1.domain.StringAddCalculater;
import step1.view.InputView;

public class MainApplication {


    public static void main(String[] args) {

        // input
        String inputString = InputView.inputData();

        // Calculate
        StringAddCalculater stringAddCalculater = new StringAddCalculater();

        int result = stringAddCalculater.splitAndSum(inputString);

        System.out.println(result);

    }


}
