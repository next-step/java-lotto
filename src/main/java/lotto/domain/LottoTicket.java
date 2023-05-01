package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(int lottoCount) {
        this.lottoNumbers = createLotto(lottoCount);
    }

    private List<LottoNumber> createLotto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new LottoNumber())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult calculateResult(List<Integer> winningNumbers) {
        return new LottoResult(lottoNumbers, winningNumbers);
    }

    public LottoResult calculateResult(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottoNumbers, winningNumbers, bonusNumber);
    }
}
