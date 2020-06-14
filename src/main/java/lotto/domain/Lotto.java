package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto getAutoLotto() {
        final List<Integer> lottoNumberList = new ArrayList<>();
        final List<Integer> lottos = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(i);
        }

        Collections.shuffle(lottoNumberList);

        for (int i = 0; i < 6; i++) {
            lottos.add(lottoNumberList.get(i));
        }

        Collections.sort(lottos);
        return new Lotto(lottos);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoNumberMappingCount(final List<Integer> winningNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.stream().anyMatch(v -> v == lottoNumber)) {
                count++;
            }
        }
        return count;
    }
}
