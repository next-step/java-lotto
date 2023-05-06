package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lottos lottos;

    private final List<Integer> winningLotto;

    public WinningLotto(Lottos lottos, List<Integer> winningLotto) {
        winningNumberValidation(winningLotto);
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public static WinningLotto of(Lottos lottos, List<Integer> winningNumbers) {
        return new WinningLotto(lottos, winningNumbers);
    }

    public LottoResult compareWinningLottoNumber() {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.retainAll(winningLotto);
            matchCount.add(numbers.size());
        }

        return new LottoResult(
                matchCount.stream()
                        .filter(x -> x > 2 && x < 7)
                        .collect(Collectors.toList())
        );
    }

    private void winningNumberValidation(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개를 입력해야 합니다.");
        }
    }

}
