package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

public class LottoGame {

    private static final int MAXIMUM_NUMBER = 45;
    private static final int DEFAULT_DIGIT = 6;
    private static final int DEFAULT_PURCHASE = 1000;

    final int gameCount;
    final int purchasePrice;

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

    public ArrayList<Integer> getLottoNumber(){
        ArrayList<Integer> lottoNumbers = (ArrayList<Integer>) new Random()
                .ints(1, (MAXIMUM_NUMBER + 1))
                .distinct()
                .limit(DEFAULT_DIGIT)
                .sorted()
                .boxed()
                .collect(toList());

        System.out.println(lottoNumbers.toString());
        return lottoNumbers;
    }

    public double calculateRate(Map<LottoRank, Integer> result){
        AtomicInteger sum = new AtomicInteger();
        result.forEach((key, value)->{
            sum.set(sum.get() + key.getReward() * value);
        });
        return (double)(sum.get()) / purchasePrice;
    }
}