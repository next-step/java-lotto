package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static int LOTTOPRICE = 1000;
    private List<Lotto> lottos;
    private int purchaseAmount;
    private int purchaseNum;
    private LottoNumber lottoNumber;

    public Lottos() {
        this.lottos = new ArrayList<Lotto>();
        this.lottoNumber = new LottoNumber();
    }


    public int calculatePurchaseNum(int purchaseAmount){
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchaseNum = purchaseAmount / LOTTOPRICE;
        return this.purchaseNum;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if ( purchaseAmount < 1000 || (purchaseAmount%1000 != 0)) {
            throw new IllegalStateException("로또금액은 1000원 이상이며, 단위는 1000  입니다."); }
    }

    public void initializeLottoNumbers(){
        for (int i = 0 ; i < this.purchaseNum ; i++) {
            this.lottos.add(new Lotto(lottoNumber.generateAuto()));
        }
    }

    public String lottoNumbersToString(){
        return this.lottos.stream()
                .map(Lotto::getStringLottoNumber)
                .collect(Collectors.joining("\n"));
    }

    public List<Integer> winNumbers(String numbers){
        String[] stringWinNumber = numbers.split(",");
        validateWinNumbers(stringWinNumber);

        return Arrays.stream(stringWinNumber)
                .map(num -> num.trim())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinNumbers(String[] stringWinNumber) {
        if ( stringWinNumber.length != 6) {
            throw new IllegalStateException("로또의 숫자는 6자리여야 합니다");
        }
    }

    public List<Long> correctNumbers(List<Integer> winNumbers){
        return lottos.stream()
                .map(lotto -> lotto.correctNum(winNumbers))
                .collect(Collectors.toList());
    }

//    public HashMap<Integer,Integer> correctNumbersHashMap(List<Long> correctNumbersForEachLotto){
//
//    }

}
