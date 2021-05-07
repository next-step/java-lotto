package lotto;

import java.util.*;

public class Lotto {
    LottoBean lottoBean = new LottoBean();

    public int buyLotto(int money) {

        return money / lottoBean.getLottoPrice();
    }

    public List<Integer> createLottoBall() {

        List<Integer> lottoBalls = new ArrayList<Integer>();

        for (int i = 1; i <= 45; i++) {
            lottoBalls.add(i);
        }
        return lottoBalls;
    }

    public List<Integer> shuffleLottoBall(){

        List<Integer> shuffleBalls = createLottoBall();
        Collections.shuffle(shuffleBalls);

        return shuffleBalls;
    }

    public List<Integer> createLottoNumber(List<Integer> shuffleBalls) {
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(shuffleBalls.get(i));
        }
        return lottoNumbers;
    }

    public List<Integer> sortLottoNumber(List<Integer> lottoNumbers){
        Collections.sort(lottoNumbers);
        List<Integer> sortNumbers = lottoNumbers;
        return sortNumbers;
    }
}


