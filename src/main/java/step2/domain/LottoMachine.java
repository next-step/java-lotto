package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final static int LOTTO_PRICE = 1_000;

    public LottoTicket makeLotto(String money) {
        int lottoCount = getCount(money);
        List<LottoNumbers> lottoNumbersList = getLottoNumberListByLottoCount(lottoCount);
        return new LottoTicket(lottoNumbersList);
    }

    private List<LottoNumbers> getLottoNumberListByLottoCount(int lottoCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }

    private int getCount(String money) {
        int moneyToInt = invalidAndToInt(money);
        if (moneyToInt % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
        return moneyToInt / LOTTO_PRICE;
    }

    private int invalidAndToInt(String money) {
        try {
            if (money == null || money.trim().isEmpty()) {
                throw new IllegalArgumentException("금액을 입력해주세요.");
            }
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
