package step3;

import step3.enums.DrawResult;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class DrawResultGroups {
    private final Map<DrawResult, LottoBucket> lottoBucketByMatch = new EnumMap<DrawResult, LottoBucket>(DrawResult.class) {{
        Arrays.stream(DrawResult.values())
                .forEach(w -> put(w, new LottoBucket()));
    }};

    private LottoBucket getLottoBucket(DrawResult drawResult) {
        return lottoBucketByMatch.get(drawResult);
    }

    public void addLottoOnMatchGroup(DrawResult drawResult, LottoEntry lottoEntry) {
        getLottoBucket(drawResult).add(lottoEntry);
    }

    public int countLottoEntriesByMatch(DrawResult drawResult) {
        return getLottoBucket(drawResult).size();
    }

    public int countAllLottoEntries() {
        return lottoBucketByMatch.values().stream()
                .map(LottoBucket::size)
                .reduce(Integer::sum).orElse(0);
    }

    public Set<DrawResult> keySet() {
        return lottoBucketByMatch.keySet();
    }

    public LottoBucket getBucket(DrawResult drawResult) {
        return lottoBucketByMatch.get(drawResult);
    }
}
