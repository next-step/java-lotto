package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.*;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;

    public Lottos(int count) {
        lottoCount = new LottoCount(count);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public void makeLotto(NumberRule numberRule) throws Exception {
        for (int i = ZERO; i < lottoCount.getCount(); i++) {
            lottos.add(new LottoNumbers(numberRule));
        }
    }

    public LottoResultDTO compareMatchNumber(LottoNumbers winnerNumbers) {
        LottoResultDTO resultDTO = new LottoResultDTO();
        for (LottoNumbers numbers : lottos) {
            int matchCount = numbers.countCompareMatchNumber(winnerNumbers);
            if (matchCount == RANK.FOURTH.getMatchCount()) {
                resultDTO.setMath3(resultDTO.getMath3() + ONE);
            }
            if (matchCount == RANK.THIRD.getMatchCount()) {
                resultDTO.setMath4(resultDTO.getMath4() + ONE);
            }
            if (matchCount == RANK.SECOND.getMatchCount()) {
                resultDTO.setMath5(resultDTO.getMath5() + ONE);
            }
            if (matchCount == RANK.FIRST.getMatchCount()) {
                resultDTO.setMath6(resultDTO.getMath6() + ONE);
            }
        }
        return resultDTO;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoNumbers lottoNumbers : lottos) {
            stringBuilder.append(START_LOTTO_SYMBOL)
                    .append(lottoNumbers.toString())
                    .append(END_LOTTO_SYMBOL)
                    .append(LINE_BRAKE);
        }
        return stringBuilder.toString();
    }
}
