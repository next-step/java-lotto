package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMaker {

    public Lottos makeLottos(List<List<Integer>> lottoNumberList) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoNumberList.forEach(lottoNumbers -> lottoList.add(new Lotto(lottoNumbers)));

        return new Lottos(lottoList);
    }

    public Lotto makeLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }


}
