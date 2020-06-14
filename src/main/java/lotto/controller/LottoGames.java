package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.PrizeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LottoGames implements Iterable<LottoGame> {
    List<LottoGame> games;

    public LottoGames(int price) {
        this.games = new ArrayList<>();
        for (int i = 0; i < price / 1000; i ++) {
            games.add(new LottoGame());
        }
    }

    public int getSize() {
        return games.size();
    }

    public int getPrizes(int[] winnerNumber, int bonusNumber) {
        return games.stream().mapToInt(page -> Arrays.stream(PrizeEnum.values())
                .filter(
                        prizeEnum -> page.LottoCompare(winnerNumber, bonusNumber) == prizeEnum.getMatch()
                ).findAny().orElse(PrizeEnum.FAIL).getPrize()
        ).reduce(0, Integer::sum);
    }

    public String getPrizesContentByEnum(PrizeEnum prizeEnum, int[] winnerNumber, int bonusNumber) {
        if (prizeEnum == PrizeEnum.FAIL) {
            return "";
        }
        if (prizeEnum == PrizeEnum.FIVE_BONUS) {
            StringBuilder builder = new StringBuilder();
            builder.append("5개 일치 - 보너스 볼 일치(30000000원)- ");
            builder.append(games.stream().filter(
                    page -> page.LottoCompare(winnerNumber, bonusNumber) == prizeEnum.getMatch()
            ).count());
            builder.append("개\n");
            return builder.toString();
        }

        StringBuilder builder = new StringBuilder();
        builder.append(prizeEnum.getMatch());
        builder.append("개 일치 (");
        builder.append(prizeEnum.getPrize());
        builder.append("원) - ");
        builder.append(
                (int) games.stream().filter(
                        page -> page.LottoCompare(winnerNumber, bonusNumber) == prizeEnum.getMatch()
                ).count());
        builder.append("\n");
        return builder.toString();
    }

    public double getExpectation(int[] winnerNumber, int bonusNumber) {
        return (double)getPrizes(winnerNumber, bonusNumber) / (games.size() * 1000);
    }

    @Override
    public Iterator iterator() {
        return games.iterator();
    }
}
