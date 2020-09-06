package AutoLotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class LottoNum {

    private final int lottoNum;

    public LottoNum(int lottoNum) {
        this.lottoNum = checkLottoNum(lottoNum);
    }

    public int getLottoNum() {
        return lottoNum;
    }

    private int checkLottoNum(int lottoNum) {
        if (lottoNum <= 45 && lottoNum > 0) {
            return lottoNum;
        }
        throw new RuntimeException();
    }

    public int countMatch(Lotto otherlotto) {
        return otherlotto.getLotto()
                .stream( ).filter(o -> isMatch(o))
                .mapToInt(o -> 1)
                .sum();
    }

    public int countMatchForTest(List<LottoNum> otherLottoNumList) {
        return otherLottoNumList
                .stream( ).filter(o -> isMatch(o))
                .mapToInt(o -> 1)
                .sum();
    }

    private boolean isMatch(LottoNum otherNum) {
        return getLottoNum() == otherNum.getLottoNum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        LottoNum lottoNum1 = (LottoNum) o;
        return lottoNum == lottoNum1.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNum);
    }
}
