package autoLotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    void printLotto(List<Integer> lotto) {
        String result = lotto.stream()
                             .map(String::valueOf)
                             .collect(Collectors.joining(", "));

        System.out.println(String.format("[%s]", result));
    }

    void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n" + "---------\n" + lottoResult);
    }
}
