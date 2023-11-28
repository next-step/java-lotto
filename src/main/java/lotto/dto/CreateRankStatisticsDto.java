package lotto.dto;

import java.util.List;

public class CreateRankStatisticsDto {
    private final LottosDto lottosDto;
    private final List<Integer> winnerLotto;
    private final int bonusNumber;
    private final long cost;

    public CreateRankStatisticsDto(LottosDto lottosDto, List<Integer> winnerLotto, int bonusNumber, long cost) {
        this.lottosDto = lottosDto;
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
    }

    public LottosDto getLottosDto() {
        return lottosDto;
    }

    public List<Integer> getWinnerLotto() {
        return winnerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public long getCost() {
        return cost;
    }
}
