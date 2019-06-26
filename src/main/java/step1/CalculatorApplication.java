package step1;

import java.util.ArrayList;
import java.util.List;

public class CalculatorApplication {
    private List<String> inputData;

    private CalculatorApplication() {
        this.inputData = new ArrayList<>();
    }

    public static void main(String[] args) {
        CalculatorApplication app = new CalculatorApplication();
        app.inputData.add("1,2,3");
        app.inputData.add("1:2:3");
        app.inputData.add("1,2:3");
        app.inputData.add("//;\n1;2;3");
        app.inputData.add("");
        app.inputData.add(null);

        app.startCalculation();
    }

    private void startCalculation() {

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        SplitDomain splitDomain = new SplitDomain();

        for(String data: inputData){
            int possibleCalculateNumber = stringAddCalculator.checkInputNumber(data);
            int resultView = possibleCalculateNumber;

            if (possibleCalculateNumber != 0) {
                int[] numberToAdd = splitDomain.checkSplitInputNumber(data);
                resultView = stringAddCalculator.add(numberToAdd);
            }

            System.out.println(resultView);
        }
    }
}
