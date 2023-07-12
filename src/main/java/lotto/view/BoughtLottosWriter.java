package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;

public class BoughtLottosWriter {

    private static final String DELIMITER = ", ";

    public void printBoughtLottos(final BoughtLottos boughtLottos) {
        System.out.println(boughtLottos.getCount() + "개를 구매했습니다.");
        String collect = boughtLottos.getLottos()
                .stream()
                .map(BoughtLottosWriter::formatLottos)
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    private static String formatLottos(final Lotto lotto) {
        String result = "[";
        result += lotto.getBalls()
                .stream()
                .map(b -> String.valueOf(b.getValue()))
                .collect(Collectors.joining(DELIMITER));
        return result + "]";
    }
}
