package auto.infrastructure;

import java.util.List;

public interface AutoLottoRepository {
    List<List<Integer>> createLottoNumbersList(int lotteryCount);
}
