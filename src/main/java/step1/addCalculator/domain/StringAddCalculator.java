package step1.addCalculator.domain;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String paramValue){
        InputTextProcessing inputTextProcessing = new InputTextProcessing(paramValue);

        if(!inputTextProcessing.isNullOrEmptyCheck()){
            return 0;
        }

        return runAddition(inputTextProcessing.runProcessing());
    }

    private static int runAddition(List<Integer> paramList){
        int returnValue = 0;

        for(Integer intValue : paramList){
            returnValue = intValue + returnValue;
        }

        return returnValue;
    }
}
