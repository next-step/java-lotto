package step02.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMaker {

    private LottoMaker() {}

    public static LottoList makeAutoLotto(int count) {
        return new LottoList(
            IntStream.range(0, count)
                .mapToObj(i -> Lotto.create())
                .collect(Collectors.toList())
        );
    }

    public static LottoList makeManualLotto(List<String> manualLottoNumbers) {
        return new LottoList(manualLottoNumbers.stream()
            .map(Lotto::of)
            .collect(Collectors.toList()));
    }

    public static LottoList makeLotto(int count, List<String> manualLottoNumbers) {
        return makeAutoLotto(count).merge(makeManualLotto(manualLottoNumbers));
    }
}
