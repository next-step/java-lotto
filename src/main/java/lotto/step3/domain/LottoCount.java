package lotto.step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCount {
    // 원시값을 포장
    private final int lottoCount;
    private static final int DIVISOR = 1_000;

    public LottoCount(int price) {
        int lottoCount = (price / DIVISOR);
        int thousandUnit = price % DIVISOR;
        System.out.println(lottoCount);
        if (lottoCount < 0 || thousandUnit != 0) {
            throw new IllegalArgumentException(price + "원으로는 로또를 구매할 수 없습니다.(" + DIVISOR + "원 단위로 입력해주세요.)");
        }
        this.lottoCount = lottoCount;
    }

    public List<Lotto> play(LottoStrategy lottoStrategy) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoStrategy.createLotto())
                .collect(Collectors.toList());
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPrice() {
        return lottoCount * DIVISOR;
    }
}
