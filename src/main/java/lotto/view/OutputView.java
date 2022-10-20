package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.WinningInformation.*;

public class OutputView {

    private static final String MATCHES_COUNT_FORMAT = "%s개 일치%s (%s원)- %s개\n";
    private static final String ADDITIONAL_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final List<WinningInformation> WINNING_INFORMATIONS =
            List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, FIVE_AND_BONUS_MATCHES, SIX_MATCHES);

    private OutputView() {
        throw new AssertionError("OutputView는 생성자를 호출할 수 없습니다.");
    }

    public static void printGeneratedLottos(LottoPaper lottoPaper) {
        System.out.println(lottoPaper.countLottos() + "개를 구매했습니다.");
        List<Lotto> lottos = lottoPaper.getElements();
        lottos.stream()
                .map(Lotto::getElements)
                .map(OutputView::sortLottoNumbers)
                .forEach(OutputView::printLottoNumbers);
    }

    private static Stream<LottoNumber> sortLottoNumbers(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted(LottoNumber::compareTo);
    }

    private static void printLottoNumbers(Stream<LottoNumber> lottoNumbers) {
        System.out.print("[");
        System.out.print(
                lottoNumbers
                        .map(it -> Integer.toString(it.getValue()))
                        .collect(Collectors.joining(", "))
        );
        System.out.println("]");
    }

    public static void printLottoCountAndMoneyLeft(PlayLottoCount playLottoCount, Money money) {
        System.out.printf("%s개를 구매했습니다. 남은 금액는 %s원 입니다.\n", playLottoCount.getValue(), money.getValue());
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics, Money purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        WINNING_INFORMATIONS.forEach(it -> System.out.printf(
                MATCHES_COUNT_FORMAT,
                it.getMatchesCount(),
                additionalBonusMessage(it),
                it.findAmountValue(),
                winningStatistics.countSame(it)
        ));
        System.out.printf("총 수익률은 %s입니다.", winningStatistics.calculateYield(purchaseAmount));
    }

    private static String additionalBonusMessage(WinningInformation winningInformation) {
        if(winningInformation.equals(FIVE_AND_BONUS_MATCHES)) {
            return ADDITIONAL_BONUS_MESSAGE;
        }
        return "";
    }

    public static void printNewLine() {
        System.out.println();
    }
}
