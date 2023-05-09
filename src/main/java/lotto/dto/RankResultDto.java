package lotto.dto;

import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RankResultDto {
    private final Map<Rank, Long> rankResultDto;

    public RankResultDto(Map<Rank, Long> rankResultDto) {
        this.rankResultDto = new HashMap<>(rankResultDto);
    }

    @Override
    public String toString() {
        return Arrays.stream(Rank.values())
                .filter(Predicate.not(Predicate.isEqual(Rank.MISS)))
                .sorted(Comparator.reverseOrder())
                .map(rank -> String.format(rank.getMessage(), rankResultDto.getOrDefault(rank, 0L)))
                .collect(Collectors.joining("\n"));
    }
}
