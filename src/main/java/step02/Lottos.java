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

    public LottoResultDTO compareMathNumber(LottoNumbers winnerNumbers) {
        LottoResultDTO resultDTO = new LottoResultDTO();
        for (LottoNumbers numbers : lottos) {
            int mathCount = numbers.countCompareMathNumber(winnerNumbers);
            if (mathCount == 3) {
                resultDTO.setMath3(resultDTO.getMath3() + ONE);
            }
            if (mathCount == 4) {
                resultDTO.setMath4(resultDTO.getMath4() + ONE);
            }
            if (mathCount == 5) {
                resultDTO.setMath5(resultDTO.getMath5() + ONE);
            }
            if (mathCount == 6) {
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
