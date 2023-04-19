package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningNumbers {

    public static final int WINNING_NUMBERS_COUNT = 6;
    public static final String FIRST_GRADE = "FIRST_GRADE";
    public static final String SECOND_GRADE = "SECOND_GRADE";
    public static final String THIRD_GRADE = "THIRD_GRADE";
    public static final String FOURTH_GRADE = "FOURTH_GRADE";
    public static final Map<Integer, String> RANK_BY_MATCH_COUNT = Map.of(
        6, FIRST_GRADE,
        5, SECOND_GRADE,
        4, THIRD_GRADE,
        3, FOURTH_GRADE
    );
    public static final Map<String, Integer> DEFAULT_RANKING_COUNTS = Map.of(
        FIRST_GRADE, 0,
        SECOND_GRADE, 0,
        THIRD_GRADE, 0,
        FOURTH_GRADE, 0
    );

    private final List<Number> numbers;

    public WinningNumbers(List<Number> numbers) {
        this.numbers = validCountNumbers(unDuplicated(numbers));
    }

    private List<Number> unDuplicated(List<Number> numbers) {
        Set<Number> set = Set.copyOf(numbers);
        List<Number> ret = new ArrayList<>();
        for (Number number : set) {
            ret.add(number);
        }
        return ret;
    }

    private List<Number> validCountNumbers(List<Number> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(
                "당첨번호는 6개의 중복되지 않는 숫자로 이루어져야 합니다. : " + numbers.size());
        }
        return numbers;
    }

    public List<Number> numbers() {
        return numbers;
    }

    public Map<String, Integer> winningResult(Lottos lottos) {
        Map<String, Integer> result = new HashMap<>(DEFAULT_RANKING_COUNTS);
        matchLottos(result, lottos);
        return result;
    }

    private void matchLottos(Map<String, Integer> result, Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            matchLotto(result, lotto);
        }
    }

    private void matchLotto(Map<String, Integer> result, Lotto lotto) {
        int winningCount = 0;
        for (Number number : lotto.numbers()) {
            winningCount += match(number);
        }
        updateRanking(result, winningCount);
    }

    private void updateRanking(Map<String, Integer> result, int winningCount) {
        if (isWinning(winningCount)) {
            String rank = RANK_BY_MATCH_COUNT.get(winningCount);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private boolean isWinning(int winningCount) {
        return RANK_BY_MATCH_COUNT.containsKey(winningCount);
    }

    private int match(Number number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

}
