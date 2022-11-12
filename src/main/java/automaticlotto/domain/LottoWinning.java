package automaticlotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinning {

    public List<Integer> discriminateLottoNumber(Lotto lotto, Lotto winningLotto, List<Integer> lottoResult) {
        int winningNumberCount = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            winningNumberCount = winningLotto.getLottoNumbers().stream().map(number -> number.getLottoNumber()).collect(Collectors.toList())
                    .contains(lottoNumber.getLottoNumber()) ? ++winningNumberCount : winningNumberCount;
        }
        lottoResult.set(winningNumberCount, lottoResult.get(winningNumberCount) + 1);
        return lottoResult;
    }

}
