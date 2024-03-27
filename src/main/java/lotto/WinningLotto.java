package lotto;

public class WinningLotto {
    private Lotto numbers;
    private LottoNumber bonus;

    public WinningLotto(Lotto numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningLotto(String[] numbers, String bonus){
        this(new Lotto(numbers), new LottoNumber(bonus));
    }

    public int countMatch(Lotto lotto) {
        return numbers.countMatch(lotto);
    }

    public boolean matchBonus(Lotto lotto){
        return lotto.contains(bonus);
    }

}
