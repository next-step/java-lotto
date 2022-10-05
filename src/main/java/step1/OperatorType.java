package step1;

public enum OperatorType {

    PLUS{int execute(int firstNum,int secondNum){return firstNum + secondNum;}},
    MINUS{int execute(int firstNum,int secondNum){return firstNum - secondNum;}},
    TIMES{int execute(int firstNum,int secondNum){return firstNum * secondNum;}},
    DIVISION{int execute(int firstNum,int secondNum){return firstNum / secondNum;}};

    public static final String OPEATOR_EXCEPTION = "잘못된 사칙연산 기호 입니다.";

    public static OperatorType getType(String value){
        switch (value){
            case "+" : return PLUS;
            case "-" : return MINUS;
            case "*" : return TIMES;
            case "/" : return DIVISION;
            default: throw new IllegalArgumentException(OPEATOR_EXCEPTION);
        }
    }
    abstract int execute(int firstNum, int SecondNum);
}
