package step02.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoList {

    private final List<Lotto> value = new ArrayList<>();

    public LottoList(List<Lotto> value) {
        validateIsEmpty(value);
        this.value.addAll(value);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(value);
    }

    public int size() {
        return value.size();
    }

    public LottoResult generateLottoResult(WinningLottoNumbers winningLottoNumbers) {
        var lottoGradeResultMap = value.stream()
            .map(lottoNumber -> lottoNumber.getGradeByComparison(winningLottoNumbers))
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(
                lottoGrade -> lottoGrade,
                () -> new EnumMap<>(LottoGrade.class),
                Collectors.summingInt(lottoGrade -> 1)
            ));

        return new LottoResult(lottoGradeResultMap);
    }

    private void validateIsEmpty(List<Lotto> value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("LottoList에는 최소 하나 이상의 로또가 필요합니다.");
        }
    }
}
