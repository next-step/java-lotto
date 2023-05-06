package lotto.domian;

public class WinningNumber {

    private final Lotto winningNumber;

    public WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int distinguish(Lotto lotto) {
        return Long.valueOf(lotto.getLottoNumber()
                .stream()
                .filter(lottoNumber -> winningNumber.getLottoNumber().contains(lottoNumber))
                .count())
                .intValue();
    }
}
