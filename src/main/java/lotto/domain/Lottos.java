package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    public Lottos(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = lottos;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void buyLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }


    public void buyLotto(List<String> lottos) {
        lottos.stream()
                .map(lotto -> Arrays.stream(lotto.split(",\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .forEach(numbers -> this.lottos.add(new Lotto(numbers)));
    }

    public void buyLotto(Lotto lotto) {
        //이쪽으로 로직을 옮겨보자.
        lottos.add(lotto);
    }

    public List<LottoMatcher> matchResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(winningNumbers::match)
                .collect(Collectors.toList());
    }

    public int quantity() {
        return lottos.size();
    }

    public List<List<Integer>> result() {
        return lottos.stream()
                .map(lotto -> lotto.lottoNumbers()
                        .stream().map(LottoNumber::intValue)
                        .collect(Collectors.toList())).collect(Collectors.toList());

    }
}
