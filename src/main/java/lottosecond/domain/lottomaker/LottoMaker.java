package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoCount;
import lottosecond.domain.lotto.Lottos;
import lottosecond.domain.lottomaker.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    private final LottoNumberGenerator lottoMaker;

    public LottoMaker(LottoNumberGenerator lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    public Lottos makeLottos(LottoCount lottoCount) {

        int count = lottoCount.getLottoCount();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(new HashSet<>(lottoMaker.makeLottoNumberList())));
        }

        return new Lottos(lottoList);
    }

    public Lotto makeLotto() {
        return new Lotto(new HashSet<>(lottoMaker.makeLottoNumberList()));
    }


    //    private final TotalLottoCount lottoCount;
//
//    public LottoMaker(TotalLottoCount lottoCount) {
//        this.lottoCount = lottoCount;
//    }
//
//    public Lottos makeTotalLottos(CustomLottoMaker shuffle, List<String> manualLottoString) {
//        int totalLottoCount = lottoCount.totalLottoCount();
//
//        if (lottoCount.manualLottoCount() != manualLottoString.size()) {
//            throw new IllegalArgumentException("수동 로또 개수 입력과 실제 로또 번호 입력 개수가 다릅니다.");
//        }
//
//        Lottos lottos = makeManualLottos(manualLottoString);
//
//        for (int i = 0; i < totalLottoCount-manualLottoString.size(); i++) {
//            lottos.addLotto(new Lotto(new HashSet<>(shuffle.makeLottoNumberList())));
//        }
//
//        return lottos;
//    }
//
//    public Lotto makeLotto(String winNumbersString) {
//        return StringToLottoConvertor.lottoConvert(winNumbersString);
//    }
//
//    private Lottos makeManualLottos(List<String> lottoNumbers) {
//        List<Lotto> lottoList = StringToLottoConvertor.lottoListConvert(lottoNumbers);
//
//        return new Lottos(lottoList);
//    }
}
