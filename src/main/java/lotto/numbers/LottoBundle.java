package lotto.numbers;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(int purchaseCount) {
        this.lottoBundle = new ArrayList<>(purchaseCount);
        generateNumbers(purchaseCount);
    }

    private void generateNumbers(int purchaseCount) {
        for (int i=0 ; i<purchaseCount ; i++) {
            lottoBundle.add(new Lotto());
        }
    }

    public Lotto getLottoByIndex(int index) {
        validateIndex(index);
        return lottoBundle.get(index);
    }

    public void validateIndex(int index) {
        if(index < 0 || index >= lottoBundle.size()) {
            throw new IllegalArgumentException("잘못된 인덱스 번호입니다.");
        }
    }

    public int getBundleSize() {
        return this.lottoBundle.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        lottoBundle.forEach(lotto -> {
            result.append(lotto.toString());
            result.append("\n");
        });
        return result.toString();
    }
}
