package calculator;

public class StringNumber {
    String[] numbers;

    public StringNumber(String[] numbers) {
        this.numbers = numbers;
    }

    public int sumNum() {
        int sumNumber = 0;
        for (String number : numbers) {
            sumNumber += isNumber(number);
        }
        return sumNumber;
    }

    private int isNumber(String number) {
        int isNumber = Integer.parseInt(number);
        if(isNumber < 0){
            new RuntimeException();
        }
        return isNumber;
    }
}
