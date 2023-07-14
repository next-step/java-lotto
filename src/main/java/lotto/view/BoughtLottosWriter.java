package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;

public class BoughtLottosWriter {

    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = "\n";

    public void printBoughtLottos(final BoughtLottos boughtLottos) {
        System.out.println(boughtLottos.getAutoCount() + "개를 구매했습니다.");
        String collect = boughtLottos.getAutoLottos()
                .stream()
                .map(BoughtLottosWriter::formatLottos)
                .collect(Collectors.joining(NEW_LINE));
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
