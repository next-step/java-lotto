public class Calculator {

    public int calculate(String[] inputValue) {
        int result = 0;
        for(String number: inputValue){
            result += validateNumber(number);
        }

        return result;
    }

    public int validateNumber(String number){
        int changedNumber = numberCheck(number);

        if (changedNumber < 0){
            throw new RuntimeException("양수만 가능합니다.");
        }
        return changedNumber;
    }

    public int numberCheck(String number){
        try{
            return Integer.parseInt(number);
        }catch (Exception e){
            return 1;
        }
    }
}
