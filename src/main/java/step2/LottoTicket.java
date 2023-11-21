package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Lotto> lottos;

    public LottoTicket(Set<Lotto> lottos) {
        checkLottoCount(lottos);
        this.lottos = lottos;
    }

    public LottoTicket(String lottoNumbers) {
        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Lotto> newLottos = numbers.stream().map(Lotto::new).collect(Collectors.toSet());
        checkLottoCount(newLottos);
        this.lottos = newLottos;
    }

    private void checkLottoCount(Set<Lotto> lottos) {
        if (lottos.size() != 6) {
            throw new IllegalArgumentException("로또는 6개여야 합니다.");
        }
    }

    public int winningCount(LottoTicket winningTicket) {
        return (int) lottos.stream()
                .filter(winningTicket::contains)
                .count();
    }

    private boolean contains(Lotto lotto) {
        return lottos.contains(lotto);
    }

    public Set<Lotto> lottos() {
        return lottos;
    }

}
