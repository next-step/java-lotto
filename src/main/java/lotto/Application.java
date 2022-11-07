package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lotto.domain.LottoCustomer;
import lotto.domain.LottoException;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersSupplier;
import lotto.domain.LottoResultStatsCalculator;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.UniqueLottoNumbersSupplier;
import lotto.domain.WiningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    private static final Money DEFAULT_LOTTO_FEE = Money.wons(1_000);
    private static final LottoNumbersSupplier lottoNumbersSupplier = new UniqueLottoNumbersSupplier();

    public static void main(final String[] args) {
        final LottoCustomer customer = new LottoCustomer(getValidLottoPurchaseMoney());
        final int maxCount = customer.getPurchasableCount(DEFAULT_LOTTO_FEE);

        final LottoStore store = new LottoStore(createLottoTickets(maxCount));
        store.sellAllTo(customer);

        ResultView.printPurchasedCount(customer.getPurchasedCount());
        ResultView.printPurchaseLottoNumbers(customer.getPurchasedLottoNumbers());
        ResultView.printResult(createResultCalculator(customer.getPurchasedLottoTickets()));
    }

    private static Money getValidLottoPurchaseMoney() {
        return getValueUntilValid(Application::getLottoPurchaseMoney);
    }

    private static Money getLottoPurchaseMoney() {
        final Money lottoPurchaseMoney = getLottoPurchaseMoneyFromInput();
        if (lottoPurchaseMoney.isLessThan(DEFAULT_LOTTO_FEE)) {
            throw new LottoException("해당 금액으로 로또 구입이 불가능합니다");
        }
        return lottoPurchaseMoney;
    }

    private static Money getLottoPurchaseMoneyFromInput() {
        return parseMoney(InputView.getLottoPurchaseMoney());
    }

    private static List<LottoTicket> createLottoTickets(final int count) {
        return mapToTickets(createUniqueLottoNumbers(count));
    }

    private static List<LottoNumbers> createUniqueLottoNumbers(final int count) {
        final List<LottoNumbers> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(lottoNumbersSupplier.get());
        }
        return result;
    }

    private static <T> T getValueUntilValid(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (final LottoException exception) {
            ResultView.printException(exception);
            return getValueUntilValid(supplier);
        }
    }

    private static LottoResultStatsCalculator createResultCalculator(
        final List<LottoTicket> lottoTickets
    ) {
        return new LottoResultStatsCalculator(lottoTickets, getValidWiningLotto());
    }

    private static WiningLotto getValidWiningLotto() {
        return new WiningLotto(getValidWiningLottoNumbers());
    }

    private static LottoNumbers getValidWiningLottoNumbers() {
        return getValueUntilValid(Application::getWiningLottoNumbersFromInput);
    }

    private static LottoNumbers getWiningLottoNumbersFromInput() {
        return mapToLottoNumbers(InputView.getWiningLottoNumbers());
    }

    private static LottoNumbers mapToLottoNumbers(final String[] lottoNumbers) {
        return new LottoNumbers(mapToLottoNumberList(lottoNumbers));
    }

    private static List<LottoNumber> mapToLottoNumberList(final String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
            .map(String::trim)
            .map(Application::parseInt)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }

    private static List<LottoTicket> mapToTickets(final List<LottoNumbers> lottoNumbers) {
        return lottoNumbers.stream()
            .map(numbers -> new LottoTicket(DEFAULT_LOTTO_FEE, numbers))
            .collect(Collectors.toList());
    }

    private static int parseInt(final String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber);
        } catch (final NumberFormatException numberFormatException) {
            throw new LottoException("Lotto number should be numeric", numberFormatException);
        }
    }

    private static Money parseMoney(final String money) {
        try {
            return Money.wons(Long.parseLong(money));
        } catch (final NumberFormatException numberFormatException) {
            throw new LottoException("Money should be numeric", numberFormatException);
        }
    }

}
