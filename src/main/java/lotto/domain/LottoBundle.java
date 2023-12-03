package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBundle {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> manualLottoList;
    private final List<Lotto> automaticLottoList;

    public LottoBundle(List<Lotto> automaticLottoList, List<Lotto> manualLottoList) {
        this.manualLottoList = manualLottoList;
        this.automaticLottoList = automaticLottoList;
    }

    public LottoBundle(List<Lotto> automaticLottoList) {
        this(automaticLottoList, new ArrayList<>());
    }

    public LottoBundle(LottoGenerator lottoGenerator, int lottoPurchasedPrice, List<Lotto> manualLottoList) {
        this(
                IntStream.range(0, getAutomaticCount(lottoPurchasedPrice, manualLottoList.size()))
                        .mapToObj(i -> lottoGenerator.generate())
                        .collect(Collectors.toList()),
                manualLottoList
        );
    }

    public LottoBundle(LottoGenerator lottoGenerator, int lottoPurchasedPrice) {
        this(lottoGenerator, lottoPurchasedPrice, new ArrayList<>());
    }

    private static int getAutomaticCount(int lottoPurchasedPrice, int manualCount) {
        int totalCount = lottoPurchasedPrice / LOTTO_PRICE;
        if (totalCount < manualCount) {
            throw new IllegalArgumentException(
                    String.format("구매한 로또 개수는 %d개입니다. %d개 이하로 입력해주세요.", totalCount, totalCount)
            );
        }

        return (lottoPurchasedPrice / LOTTO_PRICE) - manualCount;
    }

    public Map<LottoResult, Integer> checkWinningResult(WinningLotto winningLotto) {
        Map<LottoResult, Integer> lottoResults = Arrays.stream(LottoResult.values())
                .collect(Collectors.toMap(key -> key, value -> 0, (x, y) -> y, () -> new EnumMap<>(LottoResult.class)));

        for (Lotto lotto : lottoList()) {
            LottoResult lottoResult = winningLotto.getLottoResult(lotto);
            lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
        }

        return lottoResults;
    }

    public List<Lotto> lottoList() {
        List<Lotto> totalLottoList = new ArrayList<>();
        totalLottoList.addAll(manualLottoList);
        totalLottoList.addAll(automaticLottoList);
        return totalLottoList;
    }

    public int totalLottoCount() {
        return manualLottoList.size() + automaticLottoList.size();
    }

    public int purchasedPrice() {
        return totalLottoCount() * LOTTO_PRICE;
    }

    public int manualCount() {
        return this.manualLottoList.size();
    }

    public int automaticCount() {
        return automaticLottoList.size();
    }
}
