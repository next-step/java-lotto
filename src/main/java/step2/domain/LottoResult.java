package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<Integer, Long> resultMap;

    public LottoResult(Map<Integer, Long> map) {
        this.resultMap = map;
    }

    public static LottoResult of(LottoTicket lottoTicket, WinningLottoNumbers winningLottoNumbers) {
        Map<Integer, Long> map = lottoTicket.getMatching(winningLottoNumbers);
        return new LottoResult(map);
    }

    public Map<Integer, Long> getResultMap() {
        return resultMap;
    }



}
