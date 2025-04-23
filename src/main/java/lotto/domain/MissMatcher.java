package lotto.domain;

public class MissMatcher implements RankMatcher {
    @Override
    public boolean match(int matchCount, boolean matchBonus) {
        return matchCount < 3;  // 모든 다른 조건에 맞지 않으면 MISS로 처리
    }
}
