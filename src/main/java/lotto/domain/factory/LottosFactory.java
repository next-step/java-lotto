package lotto.domain.factory;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosFactory {

    private static final LottoGenerator manualLottoGenerator = new ManualLottoGenerator();
    private static final LottoGenerator randomLottoGenerator = new RandomLottoGenerator();

    private static final int RANGE_INITIAL = 0;

    public static Lottos create(int manualCount, int radomCount) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(issueLotto(manualCount, manualLottoGenerator));
        lottos.addAll(issueLotto(radomCount, randomLottoGenerator));

        return new Lottos(lottos);
    }

    public static List<Lotto> issueLotto(int count, LottoGenerator lottoGenerator) {
        return IntStream.range(RANGE_INITIAL, count)
                .mapToObj(v -> Lotto.of(lottoGenerator))
                .collect(Collectors.toList());
    }

}
