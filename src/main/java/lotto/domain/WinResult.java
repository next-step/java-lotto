package lotto.domain;

import java.util.Objects;

public class WinResult {

    public int prizeUnit;
    public boolean isMatchBonusNumber;

    WinResult(int prizeUnit, boolean isMatchBonusNumber){
        this.prizeUnit = prizeUnit;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinResult winResult = (WinResult) o;
        return prizeUnit == winResult.prizeUnit &&
                isMatchBonusNumber == winResult.isMatchBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeUnit, isMatchBonusNumber);
    }
}
