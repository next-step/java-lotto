package Lotto.Model;

import Lotto.Exception.InvalidMoneyForLottoException;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE_PER = 1000;
    private final List<LottoCard> lottoCardList;

    public LottoGame(int money) {
        lottoCardList = new ArrayList<>();
        validateMoney(money);

        for (int i = 0; i < money / LOTTO_PRICE_PER; i++) {
            lottoCardList.add(new LottoCard());
        }
    }

    public LottoGame(List<LottoCard> lottoCards) {
        lottoCardList = lottoCards;
    }

    public List<LottoCard> getLottoList(){
        return lottoCardList;
    }

    public void calculate(LottoCard winningLotto, int bonus){
        for (LottoCard lottoCard: lottoCardList) {
            lottoCard.matchPrize(winningLotto, bonus);
        }
    }

    private void validateMoney(int money){
        if((money % LOTTO_PRICE_PER) != 0){
            throw new InvalidMoneyForLottoException();
        }
    }

    public double getWinningRate(){
        double money = 0;
        for (LottoCard lottoCard: lottoCardList) {
            money += lottoCard.getPrize().getWinningMoney();
        }

        return money / (lottoCardList.size() * LOTTO_PRICE_PER);
    }
}
