package lotto.domain;

import lombok.Getter;

import java.util.List;

public class WinningNumber {
    @Getter
    private List<Integer> winningNumber;

    private WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber from(List<Integer> winningNumber) {
        return new WinningNumber(winningNumber);
    }
}
