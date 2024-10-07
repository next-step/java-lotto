package step1;

import step1.operater.*;

import java.util.HashMap;
import java.util.Map;

public class OperaterSelection {
    private static Map<String, Operater> operaterMap = new HashMap<>();

    public static Operater selection(String s) {
        initMapInit();
        if(!operaterMap.containsKey(s)) {
            throw new IllegalArgumentException("잘못된 기호");
        }
        return operaterMap.get(s);
    }

    private static void initMapInit() {
        operaterMap.put("+", new Addition());
        operaterMap.put("-", new Subtraction());
        operaterMap.put("*", new Multiplication());
        operaterMap.put("/", new Division());
    }

}
