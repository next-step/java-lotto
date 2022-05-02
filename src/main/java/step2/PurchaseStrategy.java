package step2;

import java.util.Set;

@FunctionalInterface
public interface PurchaseStrategy {

    Set<String> getNumbers(Integer count);
}
