package lotto.Domain;


public class WinningLotto {

    Lotto lotto;
    int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        lottoNumberOverException(bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto init(Lotto lotto, int bonus) {
        return new WinningLotto(lotto, bonus);
    }

    private void lottoNumberOverException(int bonus) {
        if(0 >= bonus || bonus > 45) {
            throw new IllegalArgumentException("로또 번호" + bonus + "가 정합성을 위배하였습니다.");
        }
    }

    public int matchLotto(Lotto targetLotto) {
        int matchCount = 0;
        for (Integer number : lotto.toList()) {
            matchCount += targetLotto.isNumberMatch(number) ? 1 : 0;
        }
        return matchCount;
    }

    public boolean matchBonus(Lotto targetLotto) {
        return targetLotto.isNumberMatch(bonus);
    }
}
