package step2.domain;

public class Bonus {
    private int bonus;

    public Bonus(int bonus) {
        LottoTicket.checkNumRange(bonus);

        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonus);
    }
}
