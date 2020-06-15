package lotto.controller;

import lotto.model.LottoLine;
import lotto.model.LottoResult;
import lotto.model.PrizeEnum;
import lotto.view.StandardOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LottoGames implements Iterable<LottoLine> {
    List<LottoLine> lines;

    private LottoGames(LottoGamesBuilder builder) {
        this.lines = builder.lines;
    }

    public static class LottoGamesBuilder {
        List<LottoLine> lines;
        int price;

        public LottoGamesBuilder(int price) {
            lines = new ArrayList<>();
            this.price = price;
        }

        public LottoGamesBuilder manualLines(List<LottoLine> lines) {
            for (LottoLine line : lines) {
                this.lines.add(line);
            }
            return this;
        }

        public LottoGames build(StandardOutputView view) {
            if (this.lines.size() * 1000 > price) {
                throw new IllegalArgumentException("가격을 초과하여 수동 구매를 하였습니다.");
            }
            int manualSize = this.lines.size();

            for (int i = manualSize; i < price / 1000; i++) {
                this.lines.add(new LottoLine());
            }

            LottoGames games = new LottoGames(this);
            view.printBoughtLotto(manualSize, games);
            return games;
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
        return (double) getPrizes(result) / (lines.size() * 1000);
    }

    @Override
    public Iterator iterator() {
        return lines.iterator();
    }
}
