package step2.Domain;

public class BonusBall extends LottoNumber{

    public BonusBall(int number) {
        super(number);
    }

    public boolean isDuplicate(WinningLotto winningLotto) {
        return winningLotto.getLottoNumberList()
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.getNumber() == getNumber());
    }
}
