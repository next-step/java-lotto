package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    public static final int DECIMAL_POINT = 2;

    public List<Ticket> makeTickets(int money) {
        moneyCheck(money);
        List<Ticket> tickets = new ArrayList<>();

        int ticketCount = money / TICKET_PRICE;
        for(int i=0; i<ticketCount; i++){
            tickets.add(new Ticket());
        }

        return tickets;
    }

    private static void moneyCheck(int money) {
        if(money < TICKET_PRICE){
            throw new IllegalArgumentException("1000원 이하로 입력.");
        }
    }

    public double resultRate(int money, Map<Integer, Integer> winnerMap){
        int winningAmounts = 0;

        for(LottoMatch lottoMatch : LottoMatch.values()){
            winningAmounts += winnerMap.get(lottoMatch.getMatchCount()) * lottoMatch.getReward();
        }

        double rate = (double)winningAmounts / (double)money;
        return getDecimalPlace(rate);
    }

    private double getDecimalPlace(double rate) {
        return Math.floor(rate * (Math.pow(10, DECIMAL_POINT))) / (Math.pow(10, DECIMAL_POINT));
    }

}
