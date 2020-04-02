package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoIssuer;
import study.lotto.domain.Lottos;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomAndRandomLottoIssuer implements LottoIssuer {
    private int index = 0;
    private RandomLottoIssuer randomLottoIssuer;
    private Lottos lottos;

    public static CustomAndRandomLottoIssuer valueOf(List<List<Integer>> customNumbers) {
        if(Objects.isNull(customNumbers)) {
            return new CustomAndRandomLottoIssuer(null);
        }

        List<Lotto> lottos = customNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new CustomAndRandomLottoIssuer(new Lottos(lottos));
    }

    CustomAndRandomLottoIssuer(Lottos lottos) {
        this.lottos = Lottos.valueOf(Optional.ofNullable(lottos));
        randomLottoIssuer = new RandomLottoIssuer();
    }

    @Override public Lotto issue() {
        if (index < lottos.size()) {
            return lottos.get(index++);
        }
        return randomLottoIssuer.issue();
    }
}
