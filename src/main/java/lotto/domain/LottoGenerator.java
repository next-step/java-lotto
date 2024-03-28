package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.END_INCLUSIVE;
import static lotto.domain.LottoNumber.START_INCLUSIVE;

public class LottoGenerator {

    private static final int FROM_INDEX = 0;
    private static final int LAST_INDEX = 6;

    private final List<Integer> lottoNumberPool;

    public LottoGenerator() {
        this.lottoNumberPool = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lottos generateManualLottos(int lottoCount, List<Lotto> manualLottoList) {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(count -> generateManualLotto(count, manualLottoList))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Lottos generateAutoLottos(int lottoCount) {
        List<Lotto> lottos = Stream.generate(this::generateAutoLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private Lotto generateManualLotto(int count, List<Lotto> manualLottos) {
        if (count > manualLottos.size()) {
            throw new IllegalArgumentException("잘못된 수동 구매 횟수를 입력하셨습니다");
        }
        return manualLottos.get(count);
    }

    private Lotto generateAutoLotto() {
        Collections.shuffle(lottoNumberPool);
        List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberPool.subList(FROM_INDEX, LAST_INDEX));
        Collections.sort(pickLottoNumbers);
        return new Lotto(pickLottoNumbers);
    }
}