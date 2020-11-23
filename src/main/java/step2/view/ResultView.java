package step2.view;

import java.util.List;

public class ResultView {
    public void showLottos(List<Object[]> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> show(lotto));
    }

    private void show(Object[] lotto) {
        StringBuilder stringBuilders = new StringBuilder();
        stringBuilders.append('[').append(lotto[0]);
        for (int index = 1; index < lotto.length; index++) {
            stringBuilders.append(',').append(" ").append(lotto[index]);
        }
        stringBuilders.append(']');
        System.out.println(stringBuilders.toString());
    }
}
