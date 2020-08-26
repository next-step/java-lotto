package step2.domain;

import java.util.Map;

public class LottoResult {

    private Map<Integer, Long> resultMap;

    public LottoResult(Map<Integer, Long> map) {
        this.resultMap = map;
    }

    public Map<Integer, Long> getResultMap() {
        return resultMap;
    }



}
