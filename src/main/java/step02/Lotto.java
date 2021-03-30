package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.Config.LOTTO_PRICE;

public class Lotto {
    private List<Numbers> lottoNumbers = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(int count, MakeNumberRule makeNumberRule) {
        makeLotto(count, makeNumberRule);
    }

    public int buyLotto(int money, MakeNumberRule makeNumberRule) {
        int lottoCount = money / LOTTO_PRICE;
        makeLotto(lottoCount, makeNumberRule);
        return lottoCount;
    }

    private void makeLotto(int count, MakeNumberRule makeNumberRule) {
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(new Numbers(makeNumberRule));
        }
    }


}
