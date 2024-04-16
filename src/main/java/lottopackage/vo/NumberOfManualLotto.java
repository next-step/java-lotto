package lottopackage.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberOfManualLotto {
    private final int numberOfManualLotto;

    public NumberOfManualLotto(String numberOfManualLotto) {
        this(Integer.parseInt(numberOfManualLotto));
    }

    public NumberOfManualLotto(final int numberOfManualLotto) {
        if (numberOfManualLotto < 0) {
            throw new IllegalArgumentException("구매 개수가 음수일 수 없습니다.");
        }
        this.numberOfManualLotto = numberOfManualLotto;
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfManualLotto that = (NumberOfManualLotto) o;
        return numberOfManualLotto == that.numberOfManualLotto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfManualLotto);
    }
}
