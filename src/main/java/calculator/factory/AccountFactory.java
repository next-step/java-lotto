package calculator.factory;

import calculator.strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AccountFactory {

    private static final Map<String, Supplier<Account>> accountMap = new HashMap<>();

    static {
        accountMap.put("+", AddtionAccount::new);
        accountMap.put("-", SubtractAccount::new);
        accountMap.put("*", MultiplyAccount::new);
        accountMap.put("/", DivideAccount::new);
    }

    public static Account getAccountInstance(String accountName) {
        return accountMap.get(accountName).get();
    }
}
