package step2.domain;

import java.util.Set;

@FunctionalInterface
public interface PurchaseStrategy {

    Set<String> getNumbers(Integer count);
}
