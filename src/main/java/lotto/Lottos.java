package lotto;

import java.util.*;

public class Lottos {
    private static final int PRICE = 1000;

    List<Lotto> lottos;

    public Lottos(){
        this.lottos = new ArrayList<>();
    }

    public Lottos(int count){
       this.lottos = new ArrayList<>();
        generateLottos(count);
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    private void generateLottos(int count){
        for(int i = 0 ; i < count; i++){
            lottos.add(new Lotto());
        }
    }

    public int countByAmount(int paidAmount){
        if(paidAmount < PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 금액보다 적습니다.");
        }
        return paidAmount / PRICE;
    }

    public Map<Integer, Integer> getWinningLottoCount(){
        Map<Integer, Integer> winningLottoMap = new HashMap<>();
        winningLottoMap.put(3, 0);
        winningLottoMap.put(4, 0);
        winningLottoMap.put(5, 0);
        winningLottoMap.put(6, 0);

        //todo
        for(Lotto lotto : this.lottos){
            if(lotto.isWinningLotto()){
                winningLottoMap.put(lotto.getMatchCount(), winningLottoMap.get(lotto.getMatchCount()) + 1);
            }
        }
        return winningLottoMap;
    }

    private int calculateTotalWinningAmount(){
        int winningAmount = 0;
        for(Lotto lotto : this.lottos){
            winningAmount += lotto.getWinningAmount();
        }
        return winningAmount;
    }

    public double calculateRateOfReturn(int winningAmount, int paidAmount){
        return Math.floor(((double) winningAmount / paidAmount) * 100) / 100;
    }


}
