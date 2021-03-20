package lotto.domain;

import java.util.LinkedHashMap;

public class LottoResultDto {
    private final double yeild;
    private final LinkedHashMap<Integer, Integer> resultMap;

    public LottoResultDto(final double yeild, final LinkedHashMap<Integer, Integer> resultMap) {
        this.yeild = yeild;
        this.resultMap = resultMap;
    }

    public double yeild() {
        return yeild;
    }

    public LinkedHashMap<Integer, Integer> resultMap() {
        return resultMap;
    }
}
