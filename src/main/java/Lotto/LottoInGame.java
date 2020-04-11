package Lotto;

import java.util.List;

public class LottoInGame {

    private final int LOTTO_PRICE = 1000;
    private int[] winnerArray = new int[7];

    public int amountToQuantity(Amount amount) {
        return amount.getAmount() / LOTTO_PRICE;
    }

    public int[] matchNumber(LottoBundle lottoBundle, List<Integer> prizeList) {

        for (int i = 0; i < lottoBundle.getSize(); i++) {
            LottoPaper paper = lottoBundle.getLottoPaper(i);
            int prize = matchNumberPrize(paper, prizeList);
            winnerArray[prize] += 1;
        }

        return winnerArray;
    }

    private int matchNumberPrize(LottoPaper paper, List<Integer> prizeList) {
        int count = 0;
        for (Integer i : prizeList) {
           count += paper.contains(i) ? 1 : 0;
        }
        return count;
    }

}
