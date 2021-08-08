package step3;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class LottoWinGroups {
    private final Map<Match, LottoBucket> lottoBucketByLottoWin = new EnumMap<Match, LottoBucket>(Match.class) {{
        Arrays.stream(Match.values())
                .forEach(w -> put(w, new LottoBucket()));
    }};

    public void addLottoOnLottoWinGroup(Match matchGroup, LottoEntry lottoEntry) {
        LottoBucket lottoBucket = this.lottoBucketByLottoWin.get(matchGroup);
        lottoBucket.add(lottoEntry);
    }

    public int countLottoEntriesByLottoWin(Match match) {
        return this.lottoBucketByLottoWin.get(match).size();
    }

    public int countAllLottoEntries() {
        return this.lottoBucketByLottoWin.values().stream()
                .map(LottoBucket::size)
                .reduce(Integer::sum).orElse(0);
    }

    public Set<Match> keySet() {
        return this.lottoBucketByLottoWin.keySet();
    }

    public LottoBucket get(Match match) {
        return this.lottoBucketByLottoWin.get(match);
    }
}
