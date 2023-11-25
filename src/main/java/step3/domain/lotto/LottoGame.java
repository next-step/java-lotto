package step3.domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public List<LottoNumber> createUserLottoNumbers(int totalCount) {
        return IntStream.range(0, totalCount)
                .mapToObj(i -> new LottoNumber())
                .collect(Collectors.toList());
    }

    public LottoNumber createWinningLottoNumber(Set<Integer> winningLottoNumbers) {
        return new LottoNumber(winningLottoNumbers);
    }

    public LottoResult playLottoGame(List<LottoNumber> userLottoNumbers, LottoNumber winningLottoNumber,
                                     int bonusNumber) {
        UserLotto userLotto = createUserLotto(userLottoNumbers);
        WinningLotto winningLotto = createWinningLotto(winningLottoNumber, bonusNumber);
        return userLotto.match(winningLotto, bonusNumber);
    }

    private UserLotto createUserLotto(List<LottoNumber> lottoNumbers) {
        return UserLotto.from(lottoNumbers);
    }

    private WinningLotto createWinningLotto(LottoNumber winningLottoNumbers, int bonusNumber) {
        return WinningLotto.of(winningLottoNumbers, bonusNumber);
    }
}
