package stringCalculator;

public class StringCalculator {
    public int plusCalculate(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            checkNegativeNumberOrNotNumber(number);
            result += Integer.parseInt(number);
        }
        return result;
    }

    public void checkNegativeNumberOrNotNumber(String inCorrectNumber) {
        if(Integer.parseInt(inCorrectNumber)<0){
            throw new IllegalArgumentException("0 이상의 수를 입력하세요.");
        }
    }

    public int calculate(String inputString) {
        if(isEmptyOrNull(inputString)){
            return 0;
        }
        Numbers numbers = new Numbers(inputString);
        return plusCalculate(numbers.getNumbers());
    }

    public boolean isEmptyOrNull(String inputString) {
        return inputString == null || "".equals(inputString);
    }
}
