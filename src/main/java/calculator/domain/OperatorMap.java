package calculator.domain;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorMap {

    private static final Map<String,Operator> operatorMap = new HashMap<>();
    private static final String SIGN_ERROR_MASSAGE = "올바른 기호가 아닙니다.";

    static {
        operatorMap.put("+", Operator.PLUS);
        operatorMap.put("-", Operator.MINUS);
        operatorMap.put("*", Operator.MULTIPLY);
        operatorMap.put("/", Operator.DIVIDE);
    }

    public int calculate(String sign, int a, int b){
        return Optional.ofNullable(operatorMap.get(sign))
                .orElseThrow(() -> new IllegalArgumentException(SIGN_ERROR_MASSAGE))
                .calculateFunction(a , b);
        }
    }
