package lotto.service;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoRuleConfig.*;

public class LottoVendingMachine {

    private static final String STRING_SPACE_REGEX = "\\s";
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = LottoNumber.toList();
    }

    private LottoVendingMachine() {}

    public static Lottos buyAutoLottery(int price) {
        return new Lottos(getLottoList(price));
    }

    public static List<LottoResult> lottoWinningResults(Lottos lottos, String winningNumbers) {
        List<Integer> winningNumberList = parseIntNumbers(noneSpaceStrings(winningNumbers));
        return getLottoResultList(lottos,winningNumberList);
    }

    private static String noneSpaceStrings(String winningNumbers) {
        return winningNumbers.replaceAll(STRING_SPACE_REGEX,"");
    }

    private static List<LottoResult> getLottoResultList(Lottos lottos, List<Integer> winningNumberList) {
        List<LottoResult> results = new LinkedList<>();
        for(Lotto lotto : lottos.getLottos()) {
            int winningCount = lotto.sameNumberOfCount(winningNumberList);
            results.add(addLottoResult(winningCount));
        }
        return results;
    }

    private static LottoResult addLottoResult(int winningCount) {
        return Arrays.stream(LottoResult.values())
                .filter(e -> e.getWinningCount() == winningCount)
                .findFirst()
                .orElse(LottoResult.NONE);
    }

    private static List<Integer> parseIntNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(LOTTO_NUMBER_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Lotto> getLottoList(int price) {
        List<Lotto> lottoList = new LinkedList<>();
        IntStream.rangeClosed(1,getCount(price))
                .forEach(i -> lottoList.add(new Lotto(getLottoNumberList())));
        return lottoList;
    }

    private static List<LottoNumber> getLottoNumberList() {
        return toShuffledList().stream()
                .limit(MAX_LOTTO_BALL_COUNT)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toShuffledList() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static int getCount(int price) {
        return price / LOTTO_PRICE;
    }
}
