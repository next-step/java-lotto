package step2.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rank {

    private Map<LottoPrize, List<Lotto>> rank;

    public Rank(Map<LottoPrize, List<Lotto>> rank) {
        this.rank = rank;
    }

    public int size(LottoPrize lottoPrize) {
        if (rank.get(lottoPrize) == null) {
            return 0;
        }
        return rank.get(lottoPrize).size();
    }

    public Map<LottoPrize, List<Lotto>> getRank() {
        return rank;
    }

    public Rank merge(Rank anotherRank){
        return new Rank(Stream.of(this.rank, anotherRank.getRank())
                .flatMap(mergedMap -> mergedMap.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> new ArrayList<>(v.getValue()),
                        (left, right) -> {left.addAll(right); return left;}
                )));
    }
}
