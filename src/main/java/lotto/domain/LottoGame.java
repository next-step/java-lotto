package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static lotto.domain.enums.LottoRank.*;

public class LottoGame {
    public LottoRank lottorank;
    public ArrayList<LottoTicket> tickets = new ArrayList<>();
    public int price;
    public int charge;
    public int gameCount;

    public ArrayList<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;
    public Map<LottoRank, Integer> result = new HashMap<>();

    public double totalRate;


    public void setGameInit(int money){
        gameCount = (int)Math.floor(money/1000);
        System.out.println( String.format("%d개를 구매했습니다.", gameCount) ); //n개를 구매했습니다.

        price = gameCount * 1000; //실제 구입금액
        charge = money - price;   //잔돈
    }

    public void setWinningNumbers(ArrayList<Integer> numbers){
        winningNumbers = numbers; //당첨번호
    }

    public void setBonusNumber(int number){
        bonusNumber = number;
    }

    public List<LottoTicket> buyLottoGame(int count){

        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
          tickets.add(new LottoTicket(getLottoNumber()));
        }

        return tickets;
    }

    public ArrayList<Integer> getLottoNumber(){
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }

        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    public Map<LottoRank, Integer> getResult(){

        for (LottoRank lottorank : lottorank.values()) {
            result.put(lottorank, 0);
        }

        for(LottoTicket lottoTicket : tickets) {
            int matchCnt = (int) lottoTicket.getNumbers().stream()
                    .filter(target -> winningNumbers.contains(target))
                    .count();
            boolean isBonusMatch = lottoTicket.getNumbers().contains(bonusNumber);
            result.put(getRanking(matchCnt, isBonusMatch), result.getOrDefault(result, 0) + 1);
        }

        return result;
    }

    //랭킹get
    public LottoRank getRanking(int matchCnt, boolean isBonusMatch){
        if(matchCnt == 6)
            return FIRST;
        if(matchCnt == 5 && isBonusMatch == true)
            return SECOND;
        if(matchCnt == 5)
            return THIRD;
        if(matchCnt == 4)
            return FOURTH;
        if(matchCnt == 3)
            return FIFTH;
        return MISS;
    }

    public double calculateRate(){
        AtomicInteger sum = new AtomicInteger();

        result.forEach((key, value)->{
            sum.set(sum.get() + key.getReward() * value);
        });

        double totalRate = (double)(sum.get()) / price * 100 ;
        totalRate = Math.round(totalRate*100)/100.0; // 소수점 둘째자리

        return totalRate;
    }
}
