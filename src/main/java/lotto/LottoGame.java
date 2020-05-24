package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoGame {

    private Map<Integer, List<Integer>> result = new HashMap<>();

    public void add(int round, int[] winningNumber) {
        result.put(round, Arrays.stream(winningNumber).boxed().collect(Collectors.toList()));
    }

    public List<Integer> get(int round) {
        return result.get(round);
    }

    public long matchingCount(int round, LottoTicket lottoTicket) {

        List<Integer> winningNumbers = get(round);

        if(winningNumbers == null) {
            throw new IllegalArgumentException("존재하지 않는 회차입니다.");
        }

        return lottoTicket.getLottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
