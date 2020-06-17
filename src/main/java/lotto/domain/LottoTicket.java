package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket getAutoLotto() {
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
        return new LottoTicket(lottos);
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
