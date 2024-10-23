package lotto.lotto;

import lotto.system.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoStrategy implements LottoGeneratorStrategy {

    @Override
    public Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        addLottos(lottoNumbers);
        shuffleLotto(lottoNumbers);
        List<LottoNumber> newLottoNumbers = answerLotto(lottoNumbers);
        sortLotto(newLottoNumbers);

        return new Lotto(newLottoNumbers);
    }

    public void addLottos(List<LottoNumber> lottoNumbers) {
        for (int i = 1; i <= Const.MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }
    }

    private void shuffleLotto(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    private void sortLotto(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public List<LottoNumber> answerLotto(List<LottoNumber> lottoNumbers) {
        return new ArrayList<>(lottoNumbers.subList(0, Const.LOTTO_CNT));
    }

}
