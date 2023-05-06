package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Rank.Match;

public class WinningNumbers {

    public static final int WINNING_NUMBERS_COUNT = 6;
    public static final Map<Match, Rank> RANK_BY_MATCH = Map.of(
        Rank.FIRST_GRADE.match(), Rank.FIRST_GRADE,
        Rank.SECOND_GRADE.match(), Rank.SECOND_GRADE,
        Rank.THIRD_GRADE.match(), Rank.THIRD_GRADE,
        Rank.FOURTH_GRADE.match(), Rank.FOURTH_GRADE,
        Rank.FIFTH_GRADE.match(), Rank.FIFTH_GRADE
    );

    public static final Map<Rank, Integer> DEFAULT_RANKING_COUNTS = new EnumMap<>(Rank.class) {{
        put(Rank.FIRST_GRADE, 0);
        put(Rank.SECOND_GRADE, 0);
        put(Rank.THIRD_GRADE, 0);
        put(Rank.FOURTH_GRADE, 0);
        put(Rank.FIFTH_GRADE, 0);
    }};

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        this.lottoNumbers = validCountNumbers(unDuplicated(lottoNumbers));
        this.bonus = validBonus(bonus);
    }

    private LottoNumber validBonus(LottoNumber bonus) {
        if (isEmptyBonus(bonus)) {
            throw new IllegalArgumentException("보너스번호는 필수입니다");
        }
        if (isContainBonus(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다 : " + bonus.value());
        }
        return bonus;
    }

    private boolean isContainBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    private boolean isEmptyBonus(LottoNumber bonus) {
        return bonus == null;
    }

    private List<LottoNumber> unDuplicated(List<LottoNumber> lottoNumbers) {
        return sorted(list(lottoNumbers));
    }

    private List<LottoNumber> list(List<LottoNumber> lottoNumbers) {
        return new ArrayList<>(setOf(lottoNumbers));
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
        updateRanking(result, matchOf(getWinningCount(lotto), lotto));
    }

    private Match matchOf(int winningCount, Lotto lotto) {
        return Match.of(winningCount, isBonusMatch(winningCount, lotto));
    }

    private boolean isBonusMatch(int winningCount, Lotto lotto) {
        return isBonusMatchCount(winningCount) && isContainBonus(lotto);
    }

    private boolean isContainBonus(Lotto lotto) {
        return lotto.numbers().contains(bonus);
    }

    private boolean isBonusMatchCount(int winningCount) {
        boolean result = false;
        for (Rank rank : Rank.values()) {
            result = (result || rank.isMatchCount(winningCount));
        }
        return result;
    }

    private int getWinningCount(Lotto lotto) {
        int winningCount = 0;
        for (LottoNumber lottoNumber : lotto.numbers()) {
            winningCount += match(lottoNumber);
        }
        return winningCount;
    }

    private void updateRanking(Map<Rank, Integer> result, Match match) {
        if (isWinning(match)) {
            Rank rank = RANK_BY_MATCH.get(match);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private boolean isWinning(Match match) {
        return RANK_BY_MATCH.containsKey(match);
    }

    private int match(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public LottoNumber bonus() {
        return new LottoNumber(bonus.value());
    }

}
