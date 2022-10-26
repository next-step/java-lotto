package domain;

import java.util.ArrayList;
import java.util.List;

import service.RandomLottoGenerator;

public class Lottos {

    private List<Lotto> lottoNumbers = new ArrayList<>();

    public void buyRandomLottos(RandomLottoGenerator randomLottoGenerator, int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(randomLottoGenerator.createRandomLotto());
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
