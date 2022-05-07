package step2.view.dto;

import step2.domain.GameResult;
import step2.domain.LottoRank;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResultDto {

    private static final String LINE_BREAK = "\n";

    Map<LottoRank, Integer> rankCountMap;

    public GameResultDto(GameResult gameResult) {
        this.rankCountMap = initBaseMap();
        this.rankCountMap.putAll(gameResult.getResult());
    }

    private EnumMap<LottoRank, Integer> initBaseMap() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public String toString() {
        return this.rankCountMap.entrySet()
                .stream()
                .map(this::createString)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private String createString(Map.Entry<LottoRank, Integer> entry) {
        LottoRank rank = entry.getKey();
        Integer count = entry.getValue();
        return rank.toString() + " - " + count + "개";
    }
}
