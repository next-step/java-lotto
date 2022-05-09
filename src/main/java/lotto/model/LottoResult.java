package lotto.model;


public class LottoResult {

    public int addCoincidenceCnt(int coincidenceCnt){
        return CoincidenceNumber
                .of(coincidenceCnt)
                .addRes();
    }

    public int getResult(int coincidenceCnt){
        return CoincidenceNumber.of(coincidenceCnt).getRes();
    }

    public int getPrice(int coincidenceCnt) {
        return CoincidenceNumber.of(coincidenceCnt).getPrice();
    }

    public double getProfitRate(int buyPrice){
        return (double) getProfit() / buyPrice;
    }

    public int getProfit(){
        int profit = 0;
        for(int i=3; i<=6; i++){
            CoincidenceNumber num = CoincidenceNumber.of(i);
            profit += num.getPrice() * num.getRes();
        }
        return profit;
    }
}
