package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.service.LotteryDraw;
import lotto.service.Rank;
import lotto.strategy.GenerateLottoNumber;

public class Lotteries {

  private static final int COUNT = 1;

  private static final int START_INCLUSIVE = 0;

  private final List<Lotto> lottos;

  public Lotteries(final List<Lotto> lottos) {
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public static Map<Rank, Integer> MatchLottosForRank(final Lotteries lotteries,
      final WinLottoInfo winLottoInfo, final Map<Rank, Integer> result) {
    lotteries.lottos.forEach(
        lotto -> result.computeIfPresent(winLottoInfo.getMatchCountForRank(lotto),
            (rank, integer) -> integer + COUNT));
    return result;
  }

  public static void toStringLottoInfo(final Lotteries lotteries) {
    lotteries.lottos
        .stream()
        .map(Lotto::toString)
        .forEach(System.out::println);
  }

  public static Lotteries createLottos(final PurchaseCount purchaseCount,
      final List<String> manualLottosNumbers) {
    return new Lotteries(
        Stream.of(createManualLottos(manualLottosNumbers),
                createAutoLottos(purchaseCount))
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));
  }

  private static List<Lotto> createAutoLottos(final PurchaseCount purchaseCount) {
    return IntStream.range(START_INCLUSIVE, purchaseCount.getAutoCount())
        .mapToObj(number -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .collect(Collectors.toList());
  }

  private static List<Lotto> createManualLottos(final List<String> manualLottos) {
    return manualLottos.stream()
        .map(LotteryDraw::inputWinningNumbers)
        .collect(Collectors.toList());
  }
}
