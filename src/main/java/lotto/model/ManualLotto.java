package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManualLotto {
    private final int manualQuantity;

    public ManualLotto(int manual, int quantity) {
        validation(manual, quantity);
        this.manualQuantity = manual;
    }

    public ManualLotto(int manual) {
        this(manual, 3);
    }

    private void validation(int manual, int quantity) {
        if (manual > quantity) {
            throw new IllegalArgumentException("구매금액을 초과했습니다");
        }
    }

    public List<Lotto> make(Set<LottoNumber> lottoNumbers) {
        List<Lotto> list = new ArrayList<>();

        for (int i = 0; i < manualQuantity; i++) {
            list.add(new Lotto(lottoNumbers));
        }

        return list;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
