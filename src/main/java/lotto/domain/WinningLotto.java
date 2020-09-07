package lotto.domain;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class WinningLotto {

    private LottoNumbers winningNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(LottoNumbers.of(numbers));
    }

    // 테스트 코드에서 사용
   public static WinningLotto of(Integer ... numbers) {
        return new WinningLotto(LottoNumbers.of(numbers));
    }

    public Map<Prize, List<LottoNumbers>> matching(List<LottoNumbers> tickets) {
        return tickets.stream()
                .collect(groupingBy(ticket -> ticket.matchNumbers(winningNumbers)));
    }
}
