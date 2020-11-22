package step1;

public class Validator {

    public static String inputValueTest(String inputValue) {
        if(inputValue.trim().equals("")){
            return "0";
        }
        return inputValue;
    }

    public static int validateNumber(String number){
        int changedNumber = numberCheck(number);

        if (changedNumber < 0){
            throw new RuntimeException("양수만 가능합니다.");
        }
        return changedNumber;
    }

    public static int numberCheck(String number){
        try{
            return Integer.parseInt(number);
        }catch (Exception e){
            throw new RuntimeException("숫자만 가능합니다..");
        }
    }
}
