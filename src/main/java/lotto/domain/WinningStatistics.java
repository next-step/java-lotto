package lotto.domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningStatistics {
    private final List<Integer> targetNumber;

    public WinningStatistics(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    private Map<Integer, Integer> makeResultMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<=6; i++) {
            map.put(i, 0);
        }

        return map;
    }

    public Map<Integer, Integer> lottoResult(List<Lotto> lottoBundle) {
        Map<Integer, Integer> map = makeResultMap();

        for(Lotto lotto : lottoBundle) {
            map.put(lotto.matchLottoNumber(this.targetNumber), map.getOrDefault(lotto.matchLottoNumber(this.targetNumber), 0) + 1);
        }

        // 작동이 안되는 이유가 무엇인가요?
        // 위와 뭐가 다른 지 모르겠습니다...
//        lottoBundle.stream()
//                .mapToInt(lotto -> lotto.getMatchNumber())
//                .map(key -> map.put(key, map.getOrDefault(key, 0) + 1));

        return map;
    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
