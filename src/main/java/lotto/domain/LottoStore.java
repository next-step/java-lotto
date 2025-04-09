package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    private LottoStore() {
    }

    public static List<LottoNumbers> sellLotto(final int price) {
        int lottoCount = LottoPrice.possibleTotalLottoCount(price);

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumber = LottoMachine.generateLottoNumber();
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }

    public static List<LottoNumbers> sellLotto(List<Set<Integer>> slips) {
        if (slips == null) {
            return List.of();
        }

        return slips.stream()
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
                )
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }
}
