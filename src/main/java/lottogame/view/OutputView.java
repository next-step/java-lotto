package lottogame.view;

import lottogame.model.Lottos;

import java.util.stream.Collectors;

public class OutputView {

    public void resultBuyPrice(int buyCount, int manualBuyCount) {
        System.out.println("수동으로 " + manualBuyCount + "장, 자동으로 " + buyCount + "개를 구매했습니다.");
    }

    public void resultLottoList(Lottos lottos) {
        lottos.getLottos().stream().forEach(
                lotto -> System.out.println(lotto.getNumbers().stream()
                        .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                        .collect(Collectors.joining(",", "[", "]"))
                ));
    }
}
