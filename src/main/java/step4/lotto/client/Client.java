package step4.lotto.client;

import step4.lotto.Lotto;
import step4.lotto.LottoNumber;
import step4.lotto.Lottos;
import step4.lotto.TotalLottoNumber;
import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.NotEnoughMoneyException;
import step4.lotto.result.LottoResult;
import step4.lotto.result.LottoResults;
import step4.lotto.result.ResultStatistic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    private Money money;
    private Lottos lottos = Lottos.empty();
    private List<LottoNumber> manualLottoNumbers = new ArrayList<>();

    public Client(long money) {
        this.money = new Money(money);
    }

    public Client(long money, List<LottoNumber> manualLottoNumbers) {
        validateBuyableLotto(money, manualLottoNumbers);
        this.money = new Money(money);
        this.manualLottoNumbers.addAll(manualLottoNumbers);
    }

    public void buyLotto(Lottos lottos) {
        int lottoPrice = lottos.price();
        this.lottos.addAll(lottos);
        this.money.minus(lottoPrice);
    }

    public long buyableLottoCount() {
        return money.getValue() / Lotto.PRICE;
    }

    public long remainMoney() {
        return this.money.getValue();
    }

    public ResultStatistic calculateResultStatistic(TotalLottoNumber totalLottoNumber) {
        int boughtLottoCount = lottos.count();
        LottoResults lottoResults = checkResultOfLotto(totalLottoNumber);
        long sumOfPrizeMoney = lottoResults.sumOfPrizeMoney();
        double totalRevenueRate = getTotalRevenueRate(boughtLottoCount, sumOfPrizeMoney);
        return new ResultStatistic(totalRevenueRate, lottoResults);
    }

    private double getTotalRevenueRate(long boughtLottoCount, long sumOfPrizeMoney) {
        BigDecimal totalPrizeMoney = BigDecimal.valueOf(sumOfPrizeMoney);
        BigDecimal lottoBoughtAmount = BigDecimal.valueOf(boughtLottoCount * Lotto.PRICE);

        double totalRevenueRate = totalPrizeMoney.divide(lottoBoughtAmount, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return totalRevenueRate;
    }

    private LottoResults checkResultOfLotto(TotalLottoNumber winningNumber) {
        List<LottoResult> lottoResults = lottos.stream()
                .map(lotto -> new LottoResult(winningNumber, lotto))
                .collect(Collectors.toList());

        return new LottoResults(lottoResults);
    }

    public void setManualLottoNumbers(List<LottoNumber> numbers) {
        this.manualLottoNumbers.addAll(numbers);
    }

    public List<LottoNumber> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public void addMoney(long money) {
        this.money.plus(money);
    }

    public void validateBuyableLotto(long money, List<LottoNumber> manualLottoNumbers) {
        int manualLottoPrice = manualLottoNumbers.size() * Lotto.PRICE;
        if (money - manualLottoPrice < 0)
            throw new NotEnoughMoneyException(ExceptionMessage.NOT_ENOUGH_MONEY);
    }
}
