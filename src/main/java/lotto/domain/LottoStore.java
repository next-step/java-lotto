package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int MINIMUM_ISSUE_COUNT = 1;
    private static final String NOT_VALID_ISSUE_COUNT = "로또 발급은 %d개 이상 가능합니다.";

    public Lottos issueLotto(final int count) {
        validate(count);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new AutoLottoGenerator().generate());
        }
        return Lottos.of(lottos);
    }

    private void validate(int count) {
        if (count < MINIMUM_ISSUE_COUNT) {
            throw new IllegalArgumentException(String.format(NOT_VALID_ISSUE_COUNT, MINIMUM_ISSUE_COUNT));
        }
    }
}
