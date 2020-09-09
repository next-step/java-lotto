package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private LottoNumbers winningNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(LottoNumbers.of(numbers));
    }

    // 테스트 코드에서 사용
    public static WinningLotto of(Integer... numbers) {
        return new WinningLotto(LottoNumbers.of(numbers));
    }

    public LottoResult drawing(List<LottoNumbers> tickets) {
        List<Prize> prizes = tickets.stream()
                .map(ticket -> ticket.matchNumbers(winningNumbers))
                .collect(Collectors.toList());
        return new LottoResult(prizes);
    }
}
