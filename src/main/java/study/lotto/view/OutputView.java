package study.lotto.view;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoBundle;
import study.lotto.domain.ScoreType;
import study.lotto.domain.ScoreBoard;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;
import static study.lotto.domain.ScoreType.BONUS;

public class OutputView {

    public static String combineWithComma(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "";
        }

        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < numbers.size(); i++) {
            joiner.add(numbers.get(i).toString());
        }

        return joiner.toString();
    }

    public static void displayNumbers(List<Integer> numbers) {
        out.print("[");
        out.print(combineWithComma(numbers));
        out.println("]");
    }

    public static void displayLottoBundle(LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();
        for (Lotto lotto : lottos) {
            displayLotto(lotto);
        }
    }

    public static void displayLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        displayNumbers(numbers);
    }

    public static void displayLottoScore(ScoreBoard scoreBoard) {
        Map<ScoreType, Integer> scoreMap = scoreBoard.getScoreMap();

        // 정렬
        List<Map.Entry<ScoreType, Integer>> entryList = new ArrayList<>(scoreMap.entrySet())
                .stream()
                .filter(entry -> entry.getKey().canDisplay())
                .sorted(Comparator.comparing(entry -> entry.getKey().getScore()))
                .sorted(Comparator.comparing(entry -> entry.getKey().getReward()))
                .collect(Collectors.toList());

        for (Map.Entry<ScoreType, Integer> entry : entryList) {
            displayScoreAndCount(entry.getKey(), entry.getValue());
        }
    }

    public static final void displayScoreAndCount(ScoreType scoreType, Integer count) {
        String result = "";
        if (scoreType == BONUS) {
            result = scoreType.getScore() + "개 일치, 보너스 볼 일치 (" + scoreType.getReward() + ")- " + count + "개";
            out.println(result);
            return;
        }
        result = scoreType.getScore() + "개 일치 (" + scoreType.getReward() + ")- " + count + "개";
        out.println(result);
    }

    public static void displayRatio(BigDecimal ratio) {
        out.println("총 수익률은 " + ratio.toString() + "입니다.");
    }
}
