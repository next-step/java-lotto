package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {
    public static void showLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.getLottoQuantity());
        stringBuilder.append("개를 구매했습니다.");

        System.out.println(stringBuilder);

        lottos.getLottoList()
                .forEach(ResultView::showLotto);
        System.out.println();
    }

    private static void showLotto(Lotto lotto) {
        int[] lottoNumbers = lotto.getLottoNumbers();
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < Lotto.LOTTO_NUMBER_SIZE - 1; i++) {
            stringBuilder.append(lottoNumbers[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(lottoNumbers[Lotto.LOTTO_NUMBER_SIZE - 1]);
        stringBuilder.append(']');

        System.out.println(stringBuilder);
    }
}
