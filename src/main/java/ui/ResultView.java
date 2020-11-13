package ui;

import domain.LottoResult;
import domain.Lottos;

import java.util.List;

public class ResultView {
    private static final String BUYING_AMOUNT_IS = "개를 구매했습니다.";

    public static void printBuyingLottos(List<List<Integer>> lottoNumbers) {
        System.out.print(lottoNumbers.size());
        System.out.println(BUYING_AMOUNT_IS);

        lottoNumbers.stream().forEach(System.out::println);
    }
}
