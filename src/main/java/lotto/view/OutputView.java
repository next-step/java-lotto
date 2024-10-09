package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;

public class OutputView {

    public static void lottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void lottoView(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        String result = lottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);
    }
}
