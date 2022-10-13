package lotto.domain;

public class WinningNumber {

    private final Lotto winningNumber;

    public WinningNumber(Lotto winningNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }
        this.winningNumber = winningNumber;
    }

    public Lotto winningNumber() {
        return winningNumber;
    }
}
