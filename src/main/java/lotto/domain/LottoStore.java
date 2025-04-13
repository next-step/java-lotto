package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    private LottoStore() {
    }

    public static PurchasedLottoNumbers sellLotto(final LottoPaper paper, List<Set<Integer>> slips) {
        int lottoCount = paper.possibleTotalLottoCount();

        int slipsCount = Math.min(slips.size(), lottoCount);
        List<LottoNumbers> lottoNumbers = new ArrayList<>(sellLotto(slips.subList(0, slipsCount)));
        int slipsSize = lottoNumbers.size();
        lottoNumbers.addAll(sellLotto(lottoCount - slipsCount));
        int autoSize = lottoNumbers.size() - slipsSize;

        return new PurchasedLottoNumbers(lottoNumbers, autoSize, slipsSize);
    }

    public static List<LottoNumbers> sellLotto(final int count) {

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
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
