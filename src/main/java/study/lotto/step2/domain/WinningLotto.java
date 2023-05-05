package study.lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int NUMBERS_OF_WINNING = 6;
    private final Set<LottoNumber> winningLottoNumbers;

    public WinningLotto(Integer... winningLottoNumbers) {
        this(of(winningLottoNumbers));
    }

    public WinningLotto(Set<LottoNumber> winningLottoNumbers) {
        validateWinningLottoNumbers(winningLottoNumbers);
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public LottoResults lottoResultsOf(Lottos lottos) {
        return new LottoResults(lottoResultsOf(lottos.getLottos()));
    }

    public LottoResult lottoResultOf(Lotto lotto) {
        return LottoResult.of(numbersOfMatch(lotto));
    }

    private int numbersOfMatch(Lotto lotto) {
        return numbersOfMatch(lotto.getLottoNumbers());
    }

    private int numbersOfMatch(LottoNumbers lottoNumbers) {
        return numbersOfMatch(lottoNumbers.getLottoNumbers());
    }

    private List<LottoResult> lottoResultsOf(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::lottoResultOf)
                .collect(Collectors.toUnmodifiableList());
    }

    private int numbersOfMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .mapToInt(lottoNumber -> 1)
                .sum();
    }

    private void validateWinningLottoNumbers(Set<LottoNumber> winningLottoNumbers) {
        if(winningLottoNumbers.size() != NUMBERS_OF_WINNING) {
            throw new IllegalArgumentException("당첨 번호 갯수는 " + NUMBERS_OF_WINNING + "개입니다: " + winningLottoNumbers.size());
        }
    }

    private static Set<LottoNumber> of(Integer...winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }
}
