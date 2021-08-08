package step3;

import step3.enums.Match;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class MatchGroups {
    private final Map<Match, LottoBucket> lottoBucketByMatch = new EnumMap<Match, LottoBucket>(Match.class) {{
        Arrays.stream(Match.values())
                .forEach(w -> put(w, new LottoBucket()));
    }};

    private LottoBucket getLottoBucket(Match matchGroup) {
        return lottoBucketByMatch.get(matchGroup);
    }

    public void addLottoOnMatchGroup(Match match, LottoEntry lottoEntry) {
        getLottoBucket(match).add(lottoEntry);
    }

    public int countLottoEntriesByMatch(Match match) {
        return getLottoBucket(match).size();
    }

    public int countAllLottoEntries() {
        return lottoBucketByMatch.values().stream()
                .map(LottoBucket::size)
                .reduce(Integer::sum).orElse(0);
    }

    public Set<Match> keySet() {
        return lottoBucketByMatch.keySet();
    }

    public LottoBucket getBucket(Match match) {
        return lottoBucketByMatch.get(match);
    }
}
