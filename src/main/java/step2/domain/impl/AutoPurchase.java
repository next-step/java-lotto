package step2.domain.impl;

import step2.domain.PurchaseStrategy;

import java.util.*;

public class AutoPurchase implements PurchaseStrategy {

    private static final List<String> baseNumber = initBaseNumber();
    private static final int START = 1;
    private static final int END = 45;

    private static List<String> initBaseNumber() {
        List<String> result = new ArrayList<>();
        for (int i = START; i <= END; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    @Override
    public Set<String> getNumbers(Integer count) {
        Collections.shuffle(baseNumber);
        return new HashSet<>(baseNumber.subList(0, count));
    }
}
