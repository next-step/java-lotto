package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

 class LottoMatchResults{
    private List<MatchResult> matchResults = new ArrayList<>();

    LottoMatchResults() {
        matchResults.add(new MatchResult(0, 0));
        matchResults.add(new MatchResult(0, 0));
        matchResults.add(new MatchResult(0, 5000));
        matchResults.add(new MatchResult(0, 50000));
        matchResults.add(new MatchResult(0, 1500000));;
        matchResults.add(new MatchResult(0, 2000000000));
    }

    void addMatchNumber(int matchNumber) {
        try {
            matchResults.get(matchNumber - 1).addMatchCount();
        } catch (IndexOutOfBoundsException exception) {
            throw new RuntimeException("로또 숫자 범위를 넘는 숫자는 입력 불가능합니다");
        }
    }

    int getLottoReward() {
        int totalReward = 0;
        for (MatchResult matchResult : matchResults) {
            totalReward += matchResult.getReward();
        }

        return totalReward;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoMatchResults lottoMatchResults = (LottoMatchResults) obj;
        return this.matchResults.equals(lottoMatchResults.matchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResults);
    }
}
