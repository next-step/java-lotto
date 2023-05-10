package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottoauto.model.Constant.LottoMatch;

public class WinningLotto {

    private final List<Integer> winningLotto;

    public WinningLotto(List<Integer> winningLotto) {
        winningNumberValidation(winningLotto);
        this.winningLotto = winningLotto;
    }


    public LottoResult compareWinningLottoNumber(Lottos lottos) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.retainAll(winningLotto);
            matchCount.add(numbers.size());
        }

        return new LottoResult(
                matchCount.stream()
                        .filter(x -> x >= LottoMatch.MINIMUM_MATCH_COUNT && x <= LottoMatch.MAXIMUM_MATCH_COUNT)
                        .collect(Collectors.toList()), (lottos.getSize() * Constant.ONE_LOTTO_AMOUNT)
        );
    }

    private void winningNumberValidation(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개를 입력해야 합니다.");
        }
    }

}
