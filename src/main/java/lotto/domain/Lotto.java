package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {

    static final String regularExpression = "^[0-9]+$";
    static final List<Integer> lottoNumber = new ArrayList<>();

    static {
        for (int i = 0; i < 45; i++) {
            lottoNumber.add(i+1);
        }
    }

    List<List<Integer>> purchasedLottery = new ArrayList<List<Integer>>();

    Boolean integerValidation(String amount){
        return amount.matches(regularExpression);
    }

    public int lottoQuantity(String amount) {
        if (integerValidation(amount)) {
            return Integer.valueOf(amount) / 1000;
        }
        return 0;
    }

     List<Integer> outputLottoNumber(){
        List<Integer> result = new ArrayList<>();
        Collections.shuffle(lottoNumber);

        for (int i = 0; i < 6; i++) {
             result.add(lottoNumber.get(i));
         }
        return result;
    }

    void buyLotto(int lottoQuantity){
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer>  lotto = outputLottoNumber();
            Collections.sort(lotto);
            purchasedLottery.add(lotto);
        }
    }
    public List<List<Integer>> getPurchasedLottery(int lottoQuantity){
        buyLotto(lottoQuantity);
        return purchasedLottery;
    }


}
