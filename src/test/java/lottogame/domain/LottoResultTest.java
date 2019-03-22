package lottogame.domain;

import lottogame.service.LottoNumberPool;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static lottogame.domain.PurchaseAmount.LOTTO_PRICE;
import static org.junit.Assert.*;

public class LottoResultTest {

    private LottoResult lottoResult;
    private final Set<LottoNumber> winningNumbers = getSet(Arrays.asList(40, 41, 42, 43, 44, 45));
    private final int bonusNumber = 7;

    @Test
    public void test_MISS_rank() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
                getLottoGame(Arrays.asList(1, 2, 3, 4, 5, 6)),
                getLottoGame(Arrays.asList(1, 2, 3, 4, bonusNumber, 40)),
                getLottoGame(Arrays.asList(1, 2, bonusNumber, 4, 40, 41))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.MISS).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.MISS));
        assertEquals(0, lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_FIFTH() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            getLottoGame(Arrays.asList(40, 41, 42, 4, 5, 6)),
            getLottoGame(Arrays.asList(bonusNumber, 41, 42, 43, 5, 6)),
            getLottoGame(Arrays.asList(1, 2, 42, 43, 44, 6)),
            getLottoGame(Arrays.asList(1, 2, bonusNumber, 43, 44, 45))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.FIFTH).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.FIFTH));
        assertEquals(Rank.FIFTH.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_FOURTH() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            getLottoGame(Arrays.asList(40, 41, 42, 43, 5, 6)),
            getLottoGame(Arrays.asList(bonusNumber, 41, 42, 43, 44, 6)),
            getLottoGame(Arrays.asList(1, 2, 42, 43, 44, 45)),
            getLottoGame(Arrays.asList(40, 41, 3, 43, 44, bonusNumber)),
            getLottoGame(Arrays.asList(40, 41, 3, 4, 44, 45))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.FOURTH).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.FOURTH));
        assertEquals(Rank.FOURTH.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_THIRD() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            getLottoGame(Arrays.asList(1, 41, 42, 43, 44, 45)),
            getLottoGame(Arrays.asList(40, 2, 42, 43, 44, 45)),
            getLottoGame(Arrays.asList(40, 41, 3, 43, 44, 45)),
            getLottoGame(Arrays.asList(40, 41, 42, 4, 44, 45)),
            getLottoGame(Arrays.asList(40, 41, 42, 43, 5, 45)),
            getLottoGame(Arrays.asList(40, 41, 42, 43, 44, 6))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.THIRD).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.THIRD));
        assertEquals(Rank.THIRD.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_SECOND() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
                getLottoGame(Arrays.asList(bonusNumber, 41, 42, 43, 44, 45)),
                getLottoGame(Arrays.asList(40, bonusNumber, 42, 43, 44, 45)),
                getLottoGame(Arrays.asList(40, 41, bonusNumber, 43, 44, 45)),
                getLottoGame(Arrays.asList(40, 41, 42, bonusNumber, 44, 45)),
                getLottoGame(Arrays.asList(40, 41, 42, 43, bonusNumber, 45)),
                getLottoGame(Arrays.asList(40, 41, 42, 43, 44, bonusNumber))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.SECOND).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.SECOND));
        assertEquals(Rank.SECOND.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_FIRST() {
        List<LottoNumberPackage> gameNumbers = Collections.singletonList(
                getLottoGame(Arrays.asList(40, 41, 42, 43, 44, 45))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.FIRST).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.FIRST));
        assertEquals(Rank.FIRST.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    private LottoNumberPackage getLottoGame(List<Integer> integers) {
        return new LottoNumberPackage(getSet(integers));
    }

    private Set<LottoNumber> getSet(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumberPool::getLottoNumber)
                .collect(Collectors.toSet());
    }

    private LottoResult getLottoResult(long purchaseAmount,
                                       List<LottoNumberPackage> automaticNumbers,
                                       Set<LottoNumber> winningNumbers) {

        PurchaseAmount purchaseAmountObj = new PurchaseAmount(purchaseAmount);
        WinningInfo winningNumbersObj = new WinningInfo(new LottoNumberPackage(winningNumbers), new LottoNumber(7));
        return new LottoResult(new LottoTicket(new PurchaseInfo(purchaseAmountObj, new PurchaseCount(purchaseAmountObj.getLottoCount(), 0)), automaticNumbers), winningNumbersObj);
    }
}