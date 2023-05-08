import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArthimeticType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    // valueof은 enum의 key? 저 맨앞에있는걸 기준으로 찾는구나

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    ArthimeticType(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }

    public static ArthimeticType getArthimeticType(String symbol){

        // 그럼 람다식이 코드 depth을 줄여줄 수 있는 측면에서도 java8에서의 혁신이라고 볼 수 있는가?
        /*
        for(ArthimeticType type : ArthimeticType.values()){
            if(symbol.equals(type.getSymbol())){
                return type;
            }
        }

        return null;
         */

        return Arrays.stream(ArthimeticType.values())
                .filter(arthimeticType -> arthimeticType.hasArthimeticType(symbol))
                .findAny()
                .orElse(null);
    }

    public boolean hasArthimeticType(String symbol){
        return this.symbol.equals(symbol);
    }

    private String getSymbol(){
        return symbol;
    }
}
