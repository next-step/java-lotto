package Lotto;

import java.util.List;

public class LottoInGame {

    private final int LOTTO_PRICE = 1000;
    private int[] winnerArray = new int[8];

    public int amountToQuantity(Amount amount) {
        return amount.getAmount() / LOTTO_PRICE;
    }

    public int[] matchNumber(LottoBundle lottoPapers, List<Integer> prizeList) {

        for (int i = 0; i < lottoPapers.getSize(); i++) {
            LottoPaper paper = lottoPapers.getLottoPaper(i);
            int prize = matchNumberPrize(paper, prizeList);
            winnerArray[prize] += 1;
            int isBonusWinFlag = isBonusWin(paper, prizeList) ? 1 : 0;
            winnerArray[7] = isBonusWinFlag;
        }

        return winnerArray;
    }

    private int matchNumberPrize(LottoPaper paper, List<Integer> prizeList) {
        int count = 0;
        prizeList = prizeList.subList(0, prizeList.size() - 1);

        for (int i = 0; i < prizeList.size(); i++) {
            count += ((List<Integer>) paper.lottoNumberMap.get("lottoNumbers")).contains(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isBonusWin(LottoPaper paper, List<Integer> prizeList) {
        boolean bonusWin = false;

        int inputBonusNumber = prizeList.get(prizeList.size() - 1);

        bonusWin = ((int) paper.lottoNumberMap.get("bonusNumber")) == inputBonusNumber;

        return bonusWin;
    }
}
