package step1;

import step1.operater.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorSelection {
    private static Map<String, Operater> operaterMap = new HashMap<>();

    public static Operater selection(String s) {
        initMapInit();
        return operaterMap.get(s);
    }

    private static void initMapInit() {
        operaterMap.put("+", new Addition());
        operaterMap.put("-", new Subtraction());
        operaterMap.put("*", new Multiplication());
        operaterMap.put("/", new Division());
    }

}
