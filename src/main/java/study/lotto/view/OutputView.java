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
        scoreBoard.getScoreMapForDisplay()
                .forEach(entry -> displayScoreAndCount(entry.getKey(), entry.getValue()));
    }

    private static void displayScoreAndCount(ScoreType scoreType, Integer count) {
        out.println(scoreType.getStatus() + "- " + count + "개");
    }

    public static void displayRatio(BigDecimal ratio) {
        out.println("총 수익률은 " + ratio.toString() + "입니다.");
    }
}
