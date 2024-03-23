package controller.lotto.view;

import domain.lotto.Lotto;

import java.util.List;

public class LottoResultView {

    public static void createUserLottoListView(List<Lotto> lottoList) {

        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.stream()
                .forEach(item -> System.out.println(item));
    }
}
