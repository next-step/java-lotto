package step4.view;

import step4.domain.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {

    }

    public static void printLottoNumbers(LottoList lottoList) {
        System.out.println("수동으로 " + getLottoCountByType(lottoList, LottoType.MANUAL) + "장, "
                        + "자동으로 " + getLottoCountByType(lottoList, LottoType.AUTO) + "개를 구매했습니다.");

        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.print("[");
            printLoopLottoNumbers(lotto);
            System.out.println("]");
        }
    }

    private static long getLottoCountByType(LottoList lottoList, LottoType lottoType) {
        return lottoList.getLottoList().stream().filter(lotto -> lotto.getLottoType() == lottoType).count();
    }

    private static void printLoopLottoNumbers(Lotto lotto) {
        Iterator<LottoNumber> iterator = lotto.getLotto().iterator();

        while (iterator.hasNext()) {
            LottoNumber lottoNumber = iterator.next();
            System.out.print("" + lottoNumber.getNumber());
            checkLottoNumbersLastIterator(iterator);
        }
    }
    
    private static void checkLottoNumbersLastIterator(Iterator iterator) {
        if (iterator.hasNext()) {
            System.out.print(", ");
        }
    }

    public static void printWinCounts(LottoResult lottoResult) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (Rank rank : Rank.values()) {
            List<Rank> filterRanks = lottoResult.getRanks().stream()
                    .filter(r -> r == rank)
                    .collect(Collectors.toList());

            System.out.println(rank.getMessage() + " (" + rank.getWinningMoney() + ")원- " + filterRanks.size() + "개");
        }
    }

    public static void printTotalRevenue(BigDecimal totalRevenue) {
        System.out.println("총 수익률은 " + totalRevenue + "입니다.");
    }
}
