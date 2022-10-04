package step02.domain;

import java.util.HashMap;
import java.util.Objects;

public class LottoResultGenerator {

    public static LottoResult generate(LottoList lottoList, Lotto winners) {
        HashMap<LottoGrade, Integer> lottoGradeResultMap = new HashMap<>();
        lottoList.getValue().stream()
            .map(lottoNumber -> lottoNumber.getGradeByComparison(winners))
            .filter(Objects::nonNull)
            .forEach(lottoGrade -> lottoGradeResultMap.put(
                lottoGrade, lottoGradeResultMap.getOrDefault(lottoGrade, 0) + 1)
            );

        return new LottoResult(lottoGradeResultMap);
    }
}
