package ch02.stringsum.domain;

public class StringAddCalculator {

    public static int splitAndSum(final String inputText) {

        if(inputText == null || inputText.equals("")){
            return 0;
        }

        String[] splitNumbers = inputText.split(",|:");
        int sum = 0;

        for(String numStr : splitNumbers ){
            int number = Integer.parseInt(numStr);
            if(number <0){
                throw new IllegalArgumentException("음수가 나왔습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
