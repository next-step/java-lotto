package lotto.service;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoRuleConfig.*;

public class LottoVendingMachine {

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = LottoNumber.toList();
    }

    private LottoVendingMachine() {}

    public static Lottos buyLottery(List<Lotto> manualLotto,int lottoPurchaseCost) {
        List<Lotto> lottoList = getLottoList(lottoPurchaseCost);
        lottoList.addAll(manualLotto);
        return new Lottos(lottoList);
    }

    public static List<LottoResult> lottoWinningResults(Lottos lottos, String winningNumber, int bonusNumber) {
        return getLottoResultList(lottos,winningNumber,bonusNumber);
    }

    private static List<LottoResult> getLottoResultList(Lottos lottos, String winningNumber, int bonusNumber) {
        return lottos.getLottos().stream()
                .map(e -> LottoResult.check(e,winningNumber,bonusNumber))
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
