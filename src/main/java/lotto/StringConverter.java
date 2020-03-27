package lotto;

public class StringConverter {
    public static PositiveNumber convertStringToPositiveNumber(String input) {
        PositiveNumber positiveNumber = validateNonNumber(input);
        return positiveNumber;
    }

    private static PositiveNumber validateNonNumber(String input){
        try{
            return new PositiveNumber(Integer.parseInt(input));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자 형태의 값만 입력할 수 있습니다.");
        }
    }
}
