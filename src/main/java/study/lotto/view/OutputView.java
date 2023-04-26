package study.lotto.view;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoBundle;
import study.lotto.domain.ScoreType;
import study.lotto.domain.ScoreBoard;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
        System.out.print("[");
        System.out.print(combineWithComma(numbers));
        System.out.println("]");
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
                .collect(Collectors.toList());
        for (Map.Entry<ScoreType, Integer> entry : entryList) {
            System.out.println(entry.getKey().getScore() + "개 일치 (" + entry.getKey().getReward() + ")- " + entry.getValue() + "개");
        }
    }

    public static void displayRatio(BigDecimal ratio) {
        System.out.println("총 수익률은 " + ratio.toString() + "입니다.");
    }
}
