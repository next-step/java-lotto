package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningNumber, int bonusNumber) {
        this.winningLotto = generateWinningLotto(splitNumber(winningNumber));
        validateBonusNumber(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private Lotto generateWinningLotto(List<Integer> winningNumbers){
        Lotto lotto = winningLotto.generateLotto(winningNumbers);
        return lotto;
    }

    private List<Integer> splitNumber(String winningNumber) {
        String[] strings = winningNumber.split(",");

        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validateBonusNumber(int bonusNumber) {
        long count = winningLotto.getLotto().stream()
                .filter(lottoNumber -> lottoNumber.getLottoNumber() == bonusNumber)
                .count();
        if(count > 0) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호랑 중복될 수 없습니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
