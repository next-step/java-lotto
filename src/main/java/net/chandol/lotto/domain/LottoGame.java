package net.chandol.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;

public class LottoGame {

    public static List<Lotto> buy(int price) {
        validatePrice(price);

        int size = getAvailableLottoSize(price);
        List<LottoNumber> lottoNumbers = getLottoNumbers(size);

        return createLottos(lottoNumbers);
    }

    private static void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("금액은 음수가 들어올 수 없습니다.");
        }
    }

    private static List<LottoNumber> getLottoNumbers(int size) {
        return generate(LottoNumber::auto)
                .limit(size).collect(Collectors.toList());
    }

    private static int getAvailableLottoSize(int price) {
        return price / Lotto.PRICE;
    }

    private static List<Lotto> createLottos(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(toList());
    }

    public static LottoGameResult getLottoGameResult(LottoNumber winNumber, List<Lotto> lottos) {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winNumber);
        return calculator.lottoGameResult(lottos);
    }
}
