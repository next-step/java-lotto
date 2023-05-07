package calculator;

public class StringCalculator {

    public int calculate(String input){
        validateInput(input);
        return 0;
    }

    private void validateInput(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("input은 null이거나 blank일 수 없습니다");
        }
    }
}
