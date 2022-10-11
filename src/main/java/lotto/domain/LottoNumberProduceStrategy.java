package lotto.domain;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public interface LottoNumberProduceStrategy {
    List<Integer> getLottoNumber(Supplier<Integer> strategy, int produceCount);
}
