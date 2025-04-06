package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    public static final Integer LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static List<LottoNumbers> sellLotto(final int price) {
        return sellLotto(price, List.of());
    }

    public static List<LottoNumbers> sellLotto(final int price, List<Set<Integer>> slips) {
        if (slips == null) {
            slips = List.of();
        }

        int lottoCount = price / LOTTO_PRICE;

        List<LottoNumbers> lottoNumbersList = slips.stream()
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
                )
                .map(LottoNumbers::new)
                .collect(Collectors.toList());

        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumber = LottoMachine.generateLottoNumber();
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }
}
