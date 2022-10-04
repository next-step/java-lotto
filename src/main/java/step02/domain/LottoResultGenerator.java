package step02.domain;

import java.util.HashMap;
import java.util.Objects;

public class LottoResultGenerator {

    public static LottoResult generate(LottoList lottoList, WinningLottoNumbers winningLottoNumbers) {
        HashMap<LottoGrade, Integer> lottoGradeResultMap = new HashMap<>();
        lottoList.getValue().stream()
            .map(lottoNumber -> lottoNumber.getGradeByComparison(winningLottoNumbers))
            .filter(Objects::nonNull)
            .forEach(lottoGrade -> lottoGradeResultMap.put(
                lottoGrade, lottoGradeResultMap.getOrDefault(lottoGrade, 0) + 1)
            );

        return new LottoResult(lottoGradeResultMap);
    }
}
