package step4.domain;

import step4.dto.LottoInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoPaper {
    private static final String LESS_MONEY_MANUAL = "금액이 모자랍니다.";

    private final long autoCount;
    private final List<String> manuals;

    private LottoPaper(long autoCount, List<String> manuals) {
        this.autoCount = autoCount;
        this.manuals = new ArrayList<>(manuals);
    }

    public static LottoPaper of(Money money, List<String> manualList) {
        long totalCount = money.divide(Lotto.PRICE).longValue();
        if (totalCount < manualList.size()) {
            throw new IllegalArgumentException(LESS_MONEY_MANUAL);
        }
        return of(totalCount - manualList.size(), manualList);
    }

    public static LottoPaper of(LottoInformation lottoInformation) {
        return of(lottoInformation.getMoney(), lottoInformation.getManualList());
    }

    public static LottoPaper of(long autoCount, List<String> manuals) {
        return new LottoPaper(autoCount, manuals);
    }

    public long getAutoCount() {
        return autoCount;
    }

    public List<String> getManuals() {
        return Collections.unmodifiableList(manuals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return autoCount == that.autoCount && Objects.equals(manuals, that.manuals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoCount, manuals);
    }
}
