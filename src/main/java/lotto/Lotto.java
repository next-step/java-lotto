package lotto;

import java.util.List;

public class LottoDomain {
    static int lottoPrice = 1000;
    static int lottoCount;
    private List<LottoNumber> lottoNumberList;

    public LottoDomain() {
    }

    public LottoDomain(int inputMoney) {
        if (inputMoney % lottoPrice != 0) {
            throw new IllegalArgumentException("로또 구매금액은 " + lottoPrice + "원 단위로 입력해야 합니다.");
        }
        this.lottoCount = inputMoney / lottoPrice;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public int getLottoCount() {
        return lottoCount;
    }

    protected boolean addLottoSet(String str) {
        return false;
    }
}
