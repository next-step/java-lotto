package calculator.factory;

import calculator.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AccountFactory {

    private static final Map<String, Supplier<Account>> ACCOUNT_MAP = new HashMap<>();

    static {
        ACCOUNT_MAP.put("+", AddtionAccount::new);
        ACCOUNT_MAP.put("-", SubtractAccount::new);
        ACCOUNT_MAP.put("*", MultiplyAccount::new);
        ACCOUNT_MAP.put("/", DivideAccount::new);
    }

    public static Account getAccountInstance(String accountName) {
        return ACCOUNT_MAP.get(accountName).get();
    }
}
