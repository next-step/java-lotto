package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningNumbers {

    public enum Rank {
        FOURTH_GRADE(3, 5_000),
        THIRD_GRADE(4, 50_000),
        SECOND_GRADE(5, 1_500_000),
        FIRST_GRADE(6, 2_000_000_000);

        private int matchCount;
        private int amount;

        Rank(int matchCount, int amount) {
            this.matchCount = matchCount;
            this.amount = amount;
        }

        public int matchCount() {
            return matchCount;
        }

        public int amount() {
            return amount;
        }

    }

    public static final int WINNING_NUMBERS_COUNT = 6;
    public static final Map<Integer, Rank> RANK_BY_MATCH_COUNT = Map.of(
        Rank.FIRST_GRADE.matchCount, Rank.FIRST_GRADE,
        Rank.SECOND_GRADE.matchCount, Rank.SECOND_GRADE,
        Rank.THIRD_GRADE.matchCount, Rank.THIRD_GRADE,
        Rank.FOURTH_GRADE.matchCount, Rank.FOURTH_GRADE
    );
    public static final Map<Rank, Integer> DEFAULT_RANKING_COUNTS = new EnumMap<>(Rank.class) {{
        put(Rank.FIRST_GRADE, 0);
        put(Rank.SECOND_GRADE, 0);
        put(Rank.THIRD_GRADE, 0);
        put(Rank.FOURTH_GRADE, 0);
    }};

    private final List<LottoNumber> lottoNumbers;

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validCountNumbers(unDuplicated(lottoNumbers));
    }

    private List<LottoNumber> unDuplicated(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> ret = new ArrayList<>();
        for (LottoNumber lottoNumber : setOf(lottoNumbers)) {
            ret.add(lottoNumber);
        }
        return sorted(ret);
    }

    private Set<LottoNumber> setOf(List<LottoNumber> lottoNumbers) {
        return Set.copyOf(lottoNumbers);
    }

    private List<LottoNumber> sorted(List<LottoNumber> ret) {
        Collections.sort(ret, LottoNumber::compare);
        return ret;
    }

    private List<LottoNumber> validCountNumbers(List<LottoNumber> lottoNumbers) {
        if (isValidCount(lottoNumbers)) {
            throw new IllegalArgumentException(
                "당첨번호의 개수가 다릅니다 : " + lottoNumbers.size());
        }
        return lottoNumbers;
    }

    private boolean isValidCount(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != WINNING_NUMBERS_COUNT;
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers;
    }

    public Map<Rank, Integer> winningResult(Lottos lottos) {
        Map<Rank, Integer> result = new EnumMap<>(DEFAULT_RANKING_COUNTS);
        matchLottos(result, lottos);
        return result;
    }

    private void matchLottos(Map<Rank, Integer> result, Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            matchLotto(result, lotto);
        }
    }

    private void matchLotto(Map<Rank, Integer> result, Lotto lotto) {
        int winningCount = 0;
        for (LottoNumber lottoNumber : lotto.numbers()) {
            winningCount += match(lottoNumber);
        }
        updateRanking(result, winningCount);
    }

    private void updateRanking(Map<Rank, Integer> result, int winningCount) {
        if (isWinning(winningCount)) {
            Rank rank = RANK_BY_MATCH_COUNT.get(winningCount);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private boolean isWinning(int winningCount) {
        return RANK_BY_MATCH_COUNT.containsKey(winningCount);
    }

    private int match(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

}
