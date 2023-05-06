package lotto.domian;

public class WinNumber {

    private final Lotto winnNumber;

    public WinNumber(Lotto winnNumber) {
        this.winnNumber = winnNumber;
    }

    public int distinguish(Lotto lotto) {
        return Long.valueOf(lotto.getLottoNumber()
                .stream()
                .filter(lottoNumber -> winnNumber.getLottoNumber().contains(lottoNumber))
                .count())
                .intValue();
    }

}
