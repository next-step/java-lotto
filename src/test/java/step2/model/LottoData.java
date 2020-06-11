package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoData {

    public static MatchResult createMatchResult(LottoRank lottoRank) {
        return MatchResult.create(Collections.singletonList(lottoRank));
    }

    public static List<Lotto> createAutoLottos(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createLottoNumbers(6))
                .map(Lotto::createAuto)
                .collect(Collectors.toList());
    }

    public static ManualLottoNumbers createManualLottoNumbers(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createLottoNumbers(6))
                .collect(collectingAndThen(toList(), ManualLottoNumbers::create));
    }

    public static List<LottoNumber> createLottoNumbers(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static MoneyAmount createMoneyAmount(int amount) {
        return MoneyAmount.create(Money.valueOf(amount));
    }
}
