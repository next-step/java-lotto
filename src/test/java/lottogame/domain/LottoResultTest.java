package lottogame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lottogame.domain.PurchaseAmount.LOTTO_PRICE;
import static org.junit.Assert.*;

public class LottoResultTest {

    private LottoResult lottoResult;
    private List<Integer> winningNumbers = Arrays.asList(40, 41, 42, 43, 44, 45);

    @Test
    public void test_MISS_rank() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            new LottoNumberPackage(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoNumberPackage(Arrays.asList(1, 2, 3, 4, 5, 40)),
            new LottoNumberPackage(Arrays.asList(1, 2, 3, 4, 40, 41))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.MISS).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.MISS));
        assertEquals(0, lottoResult.getTotalWinningMoney());
    }

    @Test
    public void getWinningCountPerRank_FOURTH() {
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 4, 5, 6)),
            new LottoNumberPackage(Arrays.asList(1, 41, 42, 43, 5, 6)),
            new LottoNumberPackage(Arrays.asList(1, 2, 42, 43, 44, 6)),
            new LottoNumberPackage(Arrays.asList(1, 2, 3, 43, 44, 45))
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
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 43, 5, 6)),
            new LottoNumberPackage(Arrays.asList(1, 41, 42, 43, 44, 6)),
            new LottoNumberPackage(Arrays.asList(1, 2, 42, 43, 44, 45)),
            new LottoNumberPackage(Arrays.asList(40, 41, 3, 43, 44, 6)),
            new LottoNumberPackage(Arrays.asList(40, 41, 3, 4, 44, 45))
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
            new LottoNumberPackage(Arrays.asList(1, 41, 42, 43, 44, 45)),
            new LottoNumberPackage(Arrays.asList(40, 2, 42, 43, 44, 45)),
            new LottoNumberPackage(Arrays.asList(40, 41, 3, 43, 44, 45)),
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 4, 44, 45)),
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 43, 5, 45)),
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 43, 44, 6))
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
        List<LottoNumberPackage> gameNumbers = Arrays.asList(
            new LottoNumberPackage(Arrays.asList(40, 41, 42, 43, 44, 45))
        );

        lottoResult = getLottoResult(gameNumbers.size() * LOTTO_PRICE, gameNumbers, winningNumbers);
        Map<Rank, Long> winningCountPerRank = lottoResult.getWinningCountPerRank();
        System.out.println(winningCountPerRank);

        assertEquals(gameNumbers.size(), winningCountPerRank.get(Rank.FIRST).longValue());
        assertEquals(gameNumbers.size(), lottoResult.getWinningCount(Rank.FIRST));
        assertEquals(Rank.FIRST.getWinningMoney() * gameNumbers.size(), lottoResult.getTotalWinningMoney());
    }

    private LottoResult getLottoResult(long purchaseAmount,
                                       List<LottoNumberPackage> automaticNumbers,
                                       List<Integer> winningNumbers) {

        PurchaseAmount purchaseAmountObj = new PurchaseAmount(purchaseAmount);
        WinningInfo winningNumbersObj = new WinningInfo(new LottoNumberPackage(winningNumbers));
        return new LottoResult(new LottoTicket(new PurchaseInfo(purchaseAmountObj), automaticNumbers), winningNumbersObj);
    }
}