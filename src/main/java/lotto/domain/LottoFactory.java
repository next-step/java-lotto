package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {

    private final List<Integer> allLottoNumbers = new ArrayList<>();

    public LottoFactory() {
        for (int i = 1; i <= 45; i++) {
            allLottoNumbers.add(i);
        }
    }

    public Lotto createLotto() {
        List<Integer> allLottoNumbers = new ArrayList<>(this.allLottoNumbers);
        Collections.shuffle(allLottoNumbers);

        List<Integer> lottoNumbers = allLottoNumbers
            .stream()
            .limit(6)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

}
