/*
* 로또를 구매한 개수를 의미하는 클래스
* */
package lotto.domain;

import java.util.Objects;

public class BuyNumber {

    private final int totalNumber;
    private final int manualNumber;

    public BuyNumber(int total, int manual) {
        this.totalNumber = total;
        this.manualNumber = manual;
    }

    public boolean hasManual() {
        if (manualNumber > 0) {
            return true;
        }
        return false;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public int getManualNumber() {
        return manualNumber;
    }

    public int getAutoNumber() {
        return totalNumber - manualNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyNumber buyNumber = (BuyNumber) o;
        return totalNumber == buyNumber.totalNumber && manualNumber == buyNumber.manualNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumber, manualNumber);
    }

}
