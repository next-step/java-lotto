package step3;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class MatchGroups {
    private final Map<Match, LottoBucket> lottoBucketByMatch = new EnumMap<Match, LottoBucket>(Match.class) {{
        Arrays.stream(Match.values())
                .forEach(w -> put(w, new LottoBucket()));
    }};

    public void addLottoOnMatchGroup(Match matchGroup, LottoEntry lottoEntry) {
        this.lottoBucketByMatch.get(matchGroup).add(lottoEntry);
    }

    public int countLottoEntriesByMatch(Match match) {
        return this.lottoBucketByMatch.get(match).size();
    }

    public int countAllLottoEntries() {
        return this.lottoBucketByMatch.values().stream()
                .map(LottoBucket::size)
                .reduce(Integer::sum).orElse(0);
    }

    public Set<Match> keySet() {
        return this.lottoBucketByMatch.keySet();
    }

    public LottoBucket getBucket(Match match) {
        return this.lottoBucketByMatch.get(match);
    }
}
