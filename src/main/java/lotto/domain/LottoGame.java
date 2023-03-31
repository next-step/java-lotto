package lotto.domain;

import lotto.domain.LottoNumbers.LottoNumbers;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoGame {
    private static final int DEFAULT_PURCHASE = 1000;

    private int gameCount;
    private int gameCount2;
    private int purchasePrice;
    private int purchasePrice2;


    public LottoGame(int money, int manual) {
        gameCount = (int)Math.floor(money/DEFAULT_PURCHASE);    //게임회차
        purchasePrice = gameCount * DEFAULT_PURCHASE; //실제 구입금액

        gameCount2 = (int)Math.floor(manual/DEFAULT_PURCHASE);    //게임회차
        purchasePrice2 = gameCount2 * DEFAULT_PURCHASE; //실제 구입금액
    }


    public int getGameCount(){
        return gameCount;
    }

    public int getPurchasePrice(){
        return purchasePrice;
    }

    //자동구매
    public ArrayList<LottoTicket> buyLotto(){
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            tickets.add(new LottoTicket(getLottoNumber()));
        }
        return tickets;
    }

    //수동구매
    public ArrayList<LottoTicket> buyLotto2(){
        ArrayList<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < gameCount2; i++) {
            tickets.add(new LottoTicket(getLottoNumber()));
        }
        return tickets;
        /*
        InputView inputView = new InputView();
        inputView.inputManualNum(gameCount2);

        return tickets;
        */
    }


    public ArrayList<Integer> getLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        ArrayList<Integer> buyLottoNumber = lottoNumbers.LottoNumbers();

        /*ResultView에게 출력역할 위임*/
        ResultView resultView2 = new ResultView();
        resultView2.printTicket(buyLottoNumber);

        return buyLottoNumber;
    }

    public ArrayList<Integer> getLottoNumber2() {
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