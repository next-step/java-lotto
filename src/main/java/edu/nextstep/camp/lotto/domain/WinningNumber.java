package edu.nextstep.camp.lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningNumber {
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    private WinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber of(Set<Integer> winningNumber, int bonusNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException("invalid input: winning number or bonus number cannot be null.");
        }

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("invalid input: winning number and bonus number must be exclusive");
        }

        return new WinningNumber(Lotto.fromIntegers(winningNumber), LottoNumber.of(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumber, that.winningNumber) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningNumber{" +
                "winningNumber=" + winningNumber +
                ", bonusNumber=" + bonusNumber +
                '}';
    }

    public Lotto numbers() {
        return winningNumber;
    }

    public LottoNumber bonus() {
        return bonusNumber;
    }
}
