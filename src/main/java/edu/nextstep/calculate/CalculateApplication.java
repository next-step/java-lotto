package edu.nextstep.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-22 03:10
 */
public class CalculateApplication {
    private List<String> inputData;

    public CalculateApplication() {
        this.inputData = new ArrayList<>();
    }

    public static void main(String[] args) {
        CalculateApplication app = new CalculateApplication();
        app.inputData.add("1,2,3");
        app.inputData.add("1:2:3");
        app.inputData.add("1,2:3");
        app.inputData.add("//;\n1;2;3");
        app.inputData.add("");
        app.inputData.add(null);

        app.run();
    }

    public void run() {
        for (String inputCalculateData : inputData) {
            List<String> calculateData = SplitUtils.inputDataSplit(inputCalculateData).stream()
                    .peek(splitData -> ValidationUtils.validationNumber(splitData))
                    .collect(Collectors.toList());

            List<Integer> convertedList = Calculate.convertToInteger(calculateData);
            System.out.println("합계 : " + Calculate.sum(convertedList));
        }
    }
}
