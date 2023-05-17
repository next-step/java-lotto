package step1;

import step1.CalculateStratety.*;

import java.util.HashMap;
import java.util.Map;

import static step1.Sign.*;

public class Strategies {

    public static final String SIGN_REGEX = Sign.signRegexString();

    private static Map<String, CalculateStrategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put(PLUS.getSign(), new Plus());
        strategyMap.put(MINUS.getSign(), new Minus());
        strategyMap.put(MULTI.getSign(), new Multi());
        strategyMap.put(DIVIDE.getSign(), new Divide());
    }

    public CalculateStrategy getStrategy(String sign) {
        signValidationCheck(sign);
        return strategyMap.get(sign);
    }

    public void signValidationCheck(String sign) {
        System.out.println("SIGN_REGEX = " + SIGN_REGEX);
        if(!sign.matches(SIGN_REGEX)){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }
}
