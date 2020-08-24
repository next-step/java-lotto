package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    final static int LOTTO_PRICE = 1000;

    public Lotto makeLotto(String money) {
        List<LottoNumber> lottoNumberList = getLottoNumberListByLottoCount(moneyToCount(money));
        return new Lotto(lottoNumberList);
    }

    private List<LottoNumber> getLottoNumberListByLottoCount(int lottoCount) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumber.creatLottoNumber();
            lottoNumberList.add(lottoNumber);
        }
        return lottoNumberList;
    }

    private int moneyToCount(String money) {
        return invalidAndToInt(money) / LOTTO_PRICE;
    }

    private int invalidAndToInt(String money) {
        try {
            if(money.trim().isEmpty() || money == null) {
                throw new IllegalArgumentException("금액을 입력해주세요.");
            }
            return Integer.parseInt(money);
        } catch(Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
