package step3;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class LottoWinGroups {
    private final Map<LottoWin, LottoBucket> lottoBucketByLottoWin = new EnumMap<LottoWin, LottoBucket>(LottoWin.class) {{
        Arrays.stream(LottoWin.values())
                .forEach(w -> put(w, new LottoBucket()));
    }};

    public void addLottoOnLottoWinGroup(LottoWin lottoWinGroup, LottoEntry lottoEntry) {
        LottoBucket lottoBucket = this.lottoBucketByLottoWin.get(lottoWinGroup);
        lottoBucket.add(lottoEntry);
    }

    public int countLottoEntriesByLottoWin(LottoWin lottoWin) {
        return this.lottoBucketByLottoWin.get(lottoWin).size();
    }

    public int countAllLottoEntries() {
        return this.lottoBucketByLottoWin.values().stream()
                .map(LottoBucket::size)
                .reduce(Integer::sum).orElse(0);
    }

    public Set<LottoWin> keySet() {
        return this.lottoBucketByLottoWin.keySet();
    }

    public LottoBucket get(LottoWin lottoWin) {
        return this.lottoBucketByLottoWin.get(lottoWin);
    }
}
