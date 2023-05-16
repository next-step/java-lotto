package autolotto.machine;

import autolotto.machine.lotto.Lotto;
import autolotto.machine.lotto.LottoGenerator;
import autolotto.machine.lotto.LottoWallet;
import autolotto.machine.winning.Winning;
import autolotto.machine.winning.WinningNumbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private final static int LOTTO_PRICE = 1000;

    private final int inputMoney;
    private final LottoWallet wallet;

    public LottoMachine(LottoGenerator lottoGenerator, int inputMoney) {
        this(inputMoney, initWallet(lottoGenerator, inputMoney));
    }

    public LottoMachine(int inputMoney, LottoWallet wallet) {
        this.inputMoney = inputMoney;
        this.wallet = wallet;
    }

    private static LottoWallet initWallet(LottoGenerator lottoGenerator, int inputMoney) {
        LottoWallet wallet = new LottoWallet();
        for (int i = 0; i < calculateLottoCount(inputMoney); i++) {
            wallet.addLotto(lottoGenerator.generateLotto());
        }
        return wallet;
    }

    private static int calculateLottoCount(int inputMoney) {
        return inputMoney / LOTTO_PRICE;
    }

    public List<Lotto> lotteries() {
        return this.wallet.allLotteries();
    }

    public BigDecimal profitRate(WinningNumbers winningNumbers) {
        int totalWinnings = this.wallet.totalWinningMoneyOf(winningNumbers);
        return BigDecimal.valueOf(totalWinnings)
                .divide(BigDecimal.valueOf(this.inputMoney), 2, RoundingMode.HALF_UP);
    }

    public Map<Integer, Integer> winningState(WinningNumbers winningNumbers) {
        Map<Integer, Integer> lottoCountPerEachMatchingCount = setZeroToAllMatchingCount();

        for (Integer matchCount : lottoCountPerEachMatchingCount.keySet()) {
            int lottoCount = wallet.countOfLottoMatchingWith(winningNumbers, matchCount);
            lottoCountPerEachMatchingCount.put(matchCount, lottoCount);
        }

        return lottoCountPerEachMatchingCount;
    }

    private Map<Integer, Integer> setZeroToAllMatchingCount() {
        Map<Integer, Integer> lottoCountPerEachMatchingCount = new HashMap<>();

        Arrays.stream(Winning.values())
                .map(Winning::matchNumber)
                .forEach(matchingCount -> lottoCountPerEachMatchingCount.put(matchingCount, 0));

        return lottoCountPerEachMatchingCount;
    }

    public int lottoCount() {
        return this.wallet.lottoSize();
    }
}
