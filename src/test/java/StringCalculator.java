import java.util.function.Function;

public class StringCalculator {

    private String symbol = null;
    
    // 1차 리뷰 보완에 의한 추가
    public void isNullOrBlank(String value){
        if(value == null || value.equals("")){
            throw new IllegalArgumentException();
        }
    }

    private String isOnlyOne(String value){
        String[] strList = value.split(" ");
        if(strList.length == 1){
            return strList[0];
        }

        return value;
    }

    public String isFirstNumber(String value) {
        String firstChar = value.split(" ")[0];
        if(validateNumber(firstChar).equals("0")) {
            return "0";
        }

        return value;
    }

    // 두번째가 숫자로 시작하는지 체크 (두번째는 기호어야 되기 때문에 만든 것)
    public String isSecondCharacterNumber(String value) {
        String[] valueList = value.split(" ");
        char secondChar = valueList[1].charAt(0);
        if(!isSymbol(secondChar)){
            return "0";
        }

        return value;
    }

    public String validateNumber(String value){
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException e){
            return "0";
        }

        return value;
    }

    public boolean isSymbol(char value){
        if(41 < value && value < 48){
            return true;
        }

        return false;
    }

    // 1차 리뷰 보완에 의한 추가
    public void validateSymbol(char value){
        if(value < 41 || value > 48){
            throw new IllegalArgumentException();
        }
    }

    public int calculateOneSet(String data, int index, int result) {
        result = calculateSet(data, index, result, 3);
        return result;
    }

    public int calculateNSet(String data, int index, int result) {
        result = calculateSet(data, index, result, 2);
        return result;
    }

    private int calculateSet(String data, int index, int result, int seq){
        String[] strList = data.split(" ");
        for(int i=index;i<index+seq;i++){
            result = doOneSetCircle(result, i, strList[i]);
        }

        initializeSymbol();
        return result;
    }

    private void initializeSymbol(){
        symbol = null;
    }

    private int doOneSetCircle(int result, int seq, String data){
        if(seq%2 == 0){
            result = doNumberArithmetic(result, data);
        }

        if (seq%2 == 1){
            result = doSymbolArithmetic(result, data);
        }

        return result;
    }

    private int doNumberArithmetic(int result, String data){
        if(isSymbol(data.charAt(0))){
            return result;
        }

        int num = Integer.parseInt(data);
        result = doArithmetic(result, num, symbol);

        return result;
    }

    private int doSymbolArithmetic(int result, String data){
        validateSymbol(data.charAt(0));

        if(symbol == null) {
            symbol = data;
        }

        return result;
    }

    // 1차 리뷰 보완에 의한 수정
    private int doArithmetic(int result, int num, String symbol){
        if(symbol == null)
            return num;

        ArthimeticType arthimeticType = ArthimeticType.getArthimeticType(symbol); // 저 메소드를 static으로 선언하지 않으면 인스턴스를 생성하지 않고 들고올 방법이 없다. 이건 enum쪽 공부도 같이 필요할 듯
        result = arthimeticType.calculate(result, num);

        return result;
    }

    private int inputValidate(String data){

        String onlyOneValidation = isOnlyOne(data);
        if(!onlyOneValidation.equals(data))
            return Integer.parseInt(onlyOneValidation);

        String firstValidation = isFirstNumber(data);
        if(!firstValidation.equals(data))
            return Integer.parseInt(firstValidation);

        String thirdValidation = isSecondCharacterNumber(data);
        if(!thirdValidation.equals(data))
            return Integer.parseInt(thirdValidation);

        return -1;
    }

    public int doStringCalculator(String data) {
        int result = 0;

        int validateNum = inputValidate(data);
        if(validateNum != -1)
            return validateNum;

        result = calculate(data);

        return result;
    }

    private int calculate(String data){
        int index = 0;

        int inputSize = data.split(" ").length;
        int result = calculateOneSet(data, index, index);
        index += 3;

        while(index < inputSize){
            result = calculateNSet(data, index, result);
            index += 2;
        }

        return result;
    }
}
