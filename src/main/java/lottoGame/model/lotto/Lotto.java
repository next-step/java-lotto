package lottoGame.model.lotto;

import java.util.Collections;
import java.util.List;
import lottoGame.model.winner.BeforeWinNums;

public class Lotto {

    public static final int LOTTO_NUM_COUNT = 6;

    private final List<LottoNum> lottoNums;

    public Lotto(List<LottoNum> lottoNums) {
        if (lottoNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 갯수가 유효하지 않습니다");
        }

        Collections.sort(lottoNums);

        this.lottoNums = lottoNums;
    }

    public int compareWith(BeforeWinNums beforeWinNums) {
        long result = this.lottoNums.stream()
                .mapToInt(LottoNum::value)
                .filter(beforeWinNums::isContain)
                .count();

        return Long.valueOf(result).intValue();
    }
}
