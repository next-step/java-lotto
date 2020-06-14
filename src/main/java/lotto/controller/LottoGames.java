package lotto.controller;

import lotto.model.LottoLine;
import lotto.model.LottoResult;
import lotto.model.PrizeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LottoGames implements Iterable<LottoLine> {
    List<LottoLine> lines;

    public LottoGames(int price) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < price / 1000; i ++) {
            lines.add(new LottoLine());
        }
    }

    public int getSize() {
        return lines.size();
    }

    public int getPrizes(LottoResult result) {
        return lines.stream().mapToInt(line -> result.lineResult(line).getPrize()
        ).reduce(0, Integer::sum);
    }

    public String getPrizesContentByEnum(PrizeEnum prizeEnum, LottoResult result) {
        if (prizeEnum == PrizeEnum.FAIL) {
            return "";
        }
        if (prizeEnum == PrizeEnum.FIVE_BONUS) {
            StringBuilder builder = new StringBuilder();
            builder.append("5개 일치 - 보너스 볼 일치(30000000원)- ");
            builder.append(lines.stream().filter(
                    line -> result.lineResult(line) == prizeEnum
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
                (int) lines.stream().filter(
                        line -> result.lineResult(line) == prizeEnum
                ).count());
        builder.append("\n");
        return builder.toString();
    }

    public double getExpectation(LottoResult result) {
        return (double)getPrizes(result) / (lines.size() * 1000);
    }

    @Override
    public Iterator iterator() {
        return lines.iterator();
    }
}
