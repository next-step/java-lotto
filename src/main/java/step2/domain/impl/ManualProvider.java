package step2.domain.impl;

import step2.domain.Lotto;
import step2.domain.PurchaseCount;

import java.util.List;
import java.util.stream.Collectors;

public class ManualProvider {

    private final List<String> values;

    public ManualProvider(PurchaseCount purchaseCount, List<String> manualNumbers) {
        validateNull(purchaseCount);
        validateEqualSize(purchaseCount, manualNumbers.size());
        this.values = manualNumbers;
    }

    private void validateNull(PurchaseCount purchaseCount) {
        if (purchaseCount == null) {
            throw new IllegalArgumentException("수동 구매 갯수가 널 입니다.");
        }
    }

    private void validateEqualSize(PurchaseCount purchaseCount, int size) {
        if (!purchaseCount.equals(new PurchaseCount(size))) {
            throw new IllegalArgumentException("수동 구매 갯수와 입력한 수동 구매 번호 세트 개수가 다릅니다.");
        }
    }

    public List<Lotto> generate() {
        return values.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
