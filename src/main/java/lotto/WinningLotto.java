package lotto;

public class WinningLotto {
    private Lotto numbers;
    private LottoNumber bonus;

    public WinningLotto(Lotto numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningLotto(String[] numbers, String bonus){
        this(Lotto.of(numbers), new LottoNumber(bonus));
    }

    public LottoResult getWinningResult(Lottos lottos) {
        return lottos.getWinningResult(numbers, bonus);
    }

}
