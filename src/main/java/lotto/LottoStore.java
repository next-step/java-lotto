package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTOPRICE = 1000;

    public Lottos sell(int amount) {
        int lottoCount = this.calculateLottoCount(amount);
        return LottoMachine.make(lottoCount);
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTOPRICE;
    }

    public LottoResult result(Lottos lottos, String resultLottoNumbers){
        String[] split = resultLottoNumbers.split(",");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number: split) {
            LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(number));
            lottoNumbers.add(lottoNumber);
        }
        Lotto resultLotto = Lotto.defaultOf(lottoNumbers);

        return LottoMachine.match(resultLotto, lottos);
    }


}
