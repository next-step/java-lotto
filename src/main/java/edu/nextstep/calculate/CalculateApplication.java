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
    private Calculate calculate;
    private List<String> inputData;

    public CalculateApplication() {
        this.calculate = new Calculate();
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
                    .peek(s -> ValidationUtils.validationNumber(s))
                    .collect(Collectors.toList());

            List<Integer> convertedList = calculate.convertToInteger(calculateData);
            System.out.println("합계 : " + calculate.sum(convertedList));
        }
    }
}
