package autolotto.domain;

import autolotto.constant.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoNumbers> lottoNumbers;

    public Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lottos of(int autoLottoQuantity, List<LottoNumbers> manuelLottos) {
        List<LottoNumbers> lottoNumbersByQuantity = new ArrayList<>(autoLottoQuantity);
        for (int count = 0; count < autoLottoQuantity; count++) {
            lottoNumbersByQuantity.add(new LottoNumbers(LottoGenerator.generate()));
        }
        lottoNumbersByQuantity.addAll(0, manuelLottos);

        return new Lottos(lottoNumbersByQuantity);
    }

    public static int getQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    public Results confirm(WinningLotto winningLotto) {
        Results results = new Results();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            int countOfMatch = lottoNumber.match(winningLotto);
            boolean isBonus = winningLotto.checkBonus(lottoNumber);
            results.plusWinners(Rank.find(countOfMatch, isBonus));
        }
        return results;
    }

    public int cost() {
        return lottoNumbers.size() * LOTTO_PRICE;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
