package lotto;

public class WinningLotto {
    private Lotto numbers;
    private LottoNumber bonus;

    public WinningLotto(Lotto numbers, LottoNumber bonus) {
        validDuplicate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validDuplicate(Lotto numbers, LottoNumber bonus) {
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException("bonus번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    public static WinningLotto of(String[] numbers, String bonus){
        return new WinningLotto(Lotto.of(numbers), new LottoNumber(bonus));
    }

    public LottoResult getWinningResult(Lottos lottos) {
        return lottos.getWinningResult(numbers, bonus);
    }

}
