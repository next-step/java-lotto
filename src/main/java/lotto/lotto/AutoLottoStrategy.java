package lotto.lotto;

import lotto.system.Const;

import java.util.*;

public class AutoLottoStrategy implements LottoGeneratorStrategy {

    public AutoLottoStrategy() {
    }

    @Override
    public Lottos generateLotto(LottoParameters lottoParameters) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoParameters.getAutoCount(); i++) {
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            addLottos(lottoNumbers);
            shuffleLotto(lottoNumbers);
            SortedSet<LottoNumber> resultNumbers = answerLotto(lottoNumbers);
            Lotto lotto = new Lotto(resultNumbers);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public void addLottos(List<LottoNumber> lottoNumbers) {
        for (int i = 1; i <= Const.MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }
    }

    private void shuffleLotto(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    public SortedSet<LottoNumber> answerLotto(List<LottoNumber> lottoNumbers) {
        return new TreeSet<>(lottoNumbers.subList(0, Const.LOTTO_CNT));
    }

}
