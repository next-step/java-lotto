package lotto.domain;

import lotto.domain.LottoNumbers.LottoNumbers;
import lotto.domain.enums.LottoRank;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoGame {
    private static final int DEFAULT_PURCHASE = 1000;

    private int gameCount;
    private int purchasePrice;

    public LottoGame(int money) {
        gameCount = (int)Math.floor(money/DEFAULT_PURCHASE);    //게임회차
        purchasePrice = gameCount * DEFAULT_PURCHASE; //실제 구입금액
    }

    public int getGameCount(){
        return gameCount;
    }

    public int getPurchasePrice(){
        return purchasePrice;
    }

    public ArrayList<LottoTicket> buyLotto(){

        ArrayList<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            tickets.add(new LottoTicket(getLottoNumber()));
        }
        return tickets;
    }


    public ArrayList<Integer> getLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> buyLottoNumber = lottoNumbers.LottoNumbers();

        /*ResultView에게 출력역할 위임*/
        ResultView resultView2 = new ResultView();
        resultView2.printTicket(buyLottoNumber);

        return buyLottoNumber;
    }

    public double calculateRate(Map<LottoRank, Integer> result){
        AtomicInteger sum = new AtomicInteger();
        result.forEach((key, value)->{
            sum.set(sum.get() + key.getReward() * value);
        });
        return (double)(sum.get()) / purchasePrice;
    }
}