package AutoLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<List<Integer>> lottos = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public Lottos(int chances, LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottos = buyLottos(chances, lottoGeneratorStrategy);
    }

    private List<List<Integer>> buyLottos(int chances, LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < chances; i++) {
            lottos.add(getAutoLotto(lottoGeneratorStrategy));
        }

        return lottos;
    }

    private List<Integer> getAutoLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        List<Integer> randomLotto = lottoGenerator.generateLottoNumbers(lottoGeneratorStrategy);
        Collections.sort(randomLotto);
        return randomLotto;
    }

    public List<Integer> retrieveStringLotto(int index) {
        return lottos.get(index);
    }

}
