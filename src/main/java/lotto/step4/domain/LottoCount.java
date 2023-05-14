package lotto.step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class /**/LottoCount {
    // 원시값을 포장
    private final int lottoCount;
    private static final int DIVISOR = 1_000;

    public LottoCount(int price) {
        int lottoCount = (price / DIVISOR);
        int thousandUnit = price % DIVISOR;
        if (lottoCount < 0 || thousandUnit != 0) {
            throw new IllegalArgumentException(price + "원으로는 로또를 구매할 수 없습니다.(" + DIVISOR + "원 단위로 입력해주세요.)");
        }
        this.lottoCount = lottoCount;
    }

    public List<Lotto> play(LottoStrategy lottoStrategy, int manualLottoCount) {
        int count = lottoCount - manualLottoCount;
        valiateLottoCount(count);
        return IntStream.range(0, count)
                .mapToObj(i -> lottoStrategy.createLotto())
                .collect(Collectors.toList());
    }

    private void valiateLottoCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("입력한 금액을 초과해서 구매할 수 없습니다. (금액: " + getPrice() + ", 초과 구매 개수: " + Math.abs(count));
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }


    public int getPrice() {
        return lottoCount * DIVISOR;
    }
}
