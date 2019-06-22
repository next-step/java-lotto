public class Number {

    private int number;

    public Number(String number){
        try {
            this.number = validateNumber(number);
        }catch (NumberFormatException e){
            throw new RuntimeException("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
        }
    }

    private int validateNumber(String number){
        int convertInt = Integer.parseInt(number);
        if(Integer.parseInt(number) < 0){
            throw new RuntimeException("입력 값에 음수가 포함 되어 있습니다.");
        }
        return convertInt;
    }

    public int getNumber(){
        return this.number;
    }

}
