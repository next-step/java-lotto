package step4.view;

import step4.constant.LottoWinningPrizes;
import step4.domain.Lotto;
import step4.domain.LottoNumber;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoOuputUi {
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_DELIMITER = ",";

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(LottoOuputUi::getLottosToString)
                .forEach(System.out::println);
    }

    private static String getLottosToString(Lotto lotto) {
        String lottoList = lotto.getLottos()
                .stream()
                .map(LottoNumber::getNumber)
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_DELIMITER));
        return String.format("%s%s%s", LOTTO_PREFIX, lottoList, LOTTO_SUFFIX);

    }

    public static void printLottoCount(int lottoPurchaseQty, int manualLottoQty) {
        System.out.println("수동으로" + manualLottoQty + "장, 자동으로" + lottoPurchaseQty + "개를 구매했습니다.");

    }

    public static void printStatistics(EnumMap<LottoWinningPrizes, Integer> lottoWinningPrizesMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningStatistics(lottoWinningPrizesMap);
    }

    private static void printWinningStatistics(EnumMap<LottoWinningPrizes, Integer> lottoWinningPrizesMap) {
        lottoWinningPrizesMap.forEach((key, value) -> {
            if (key.getAmount() != 0) {
                System.out.println(key.getValue() + " (" + key.getAmount() + "원) - " + value + "개");
            }
        });
    }

    public static void printTotalReturn(double yield) {
        System.out.println("총 수익률은" + yield + "입니다");
    }
}
