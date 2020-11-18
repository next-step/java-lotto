package lotto.dto.input;

public class WinningConditionDto {
    private final String winningLotto;
    private final int bonus;

    public WinningConditionDto(String winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public String getWinningLotto() {
        return winningLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
