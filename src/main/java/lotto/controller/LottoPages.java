package lotto.controller;

import lotto.model.LottoSinglePage;
import lotto.model.WinnerEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LottoPages implements Iterable<LottoSinglePage> {
    List<LottoSinglePage> pages;

    public LottoPages(int price) {
        pages = new ArrayList<>();
        for (int i = 0; i < price / 1000; i ++) {
            pages.add(new LottoSinglePage());
        }
    }

    public int getSize() {
        return pages.size();
    }

    public int getPrizes(int[] winnerNumber) {
        return pages.stream().mapToInt(page -> Arrays.stream(WinnerEnum.values())
                .filter(
                        winnerEnum -> page.LottoCompare(winnerNumber) == winnerEnum.getMatch()).findAny()
                .orElse(WinnerEnum.FAIL).getPrize()
        ).reduce(0, Integer::sum);
    }

    public int getPrizesByEnum(WinnerEnum winnerEnum, int[] winnerNumber) {
        return (int) pages.stream().filter(page -> page.LottoCompare(winnerNumber) == winnerEnum.getMatch()).count();
    }

    public double getExpectation(int[] winnerNumber) {
        return (double)getPrizes(winnerNumber) / (pages.size() * 1000);
    }

    @Override
    public Iterator iterator() {
        return pages.iterator();
    }
}
