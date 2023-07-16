package lotto.response;

import lotto.domain.Count;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatusResponse {

    private final List<List<Integer>> lottoStatus;
    private final long manualCount;

    public LottoStatusResponse(Lottos lottos, Count manualCount) {
        this.lottoStatus = lottos.getLottos().stream()
                .map(this::parseLotto)
                .collect(Collectors.toList());
        this.manualCount = manualCount.getValue();
    }

    private List<Integer> parseLotto(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoStatus() {
        return lottoStatus;
    }

    public long getManualCount() {
        return manualCount;
    }
}
