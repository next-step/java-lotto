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
        this.rankCountMap = new EnumMap<>(LottoRank.class);
        this.rankCountMap.putAll(gameResult.getRankCount());
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
        return rank.getHitCount() + "개 일치 (" + rank.getPrizeMoney() + "원) - " + count + "개";
    }
}
