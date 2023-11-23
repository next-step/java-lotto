//package lotto.domain;
//
//import java.util.Arrays;
//
//public class PrizeSelector {
//    public Rank selectByCount(int matchingCount) {
//        return Arrays.stream(Rank.values())
//                .filter(prize -> prize.isSameCount(matchingCount))
//                .findFirst()
//                .orElse(Rank.MISS);
//    }
//}
