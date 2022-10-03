package step02.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LottoResultGenerator {

    public static LottoResult generate(List<Lotto> lottoNumbers, Lotto winners) {
        HashMap<LottoGrade, Integer> lottoGradeResultMap = new HashMap<>();
        lottoNumbers.stream()
            .map(lottoNumber -> lottoNumber.getGradeByComparison(winners))
            .filter(Objects::nonNull)
            .forEach(lottoGrade -> lottoGradeResultMap.put(
                lottoGrade, lottoGradeResultMap.getOrDefault(lottoGrade, 0) + 1)
            );

        return new LottoResult(lottoGradeResultMap);
    }
}
