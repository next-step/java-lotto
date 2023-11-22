package lottosecond.domain.lotto;

import lottosecond.domain.StringToLottoConvertor;

import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    private final TotalLottoCount lottoCount;

    public LottoMaker(TotalLottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public Lottos makeTotalLottos(CustomShuffle shuffle, List<String> manualLottoString) {
        int totalLottoCount = lottoCount.totalLottoCount();

        if (lottoCount.manualLottoCount() != manualLottoString.size()) {
            throw new IllegalArgumentException("수동 로또 개수 입력과 실제 로또 번호 입력 개수가 다릅니다.");
        }

        Lottos lottos = makeManualLottos(manualLottoString);

        for (int i = 0; i < totalLottoCount-manualLottoString.size(); i++) {
            lottos.addLotto(new Lotto(new HashSet<>(shuffle.makeShuffle())));
        }

        return lottos;
    }

    public Lotto makeLotto(String winNumbersString) {
        return StringToLottoConvertor.lottoConvert(winNumbersString);
    }

    private Lottos makeManualLottos(List<String> lottoNumbers) {
        List<Lotto> lottoList = StringToLottoConvertor.lottoListConvert(lottoNumbers);

        return new Lottos(lottoList);
    }
}
