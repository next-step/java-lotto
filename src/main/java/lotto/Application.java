package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static final LottoNumbersSupplier autoLottoNumbersSupplier = new UniqueLottoNumbersSupplier();

    public static void main(final String[] args) {
        final LottoCustomer customer = new LottoCustomer(getValidLottoPurchaseMoney());
        final int maxCount = customer.getPurchasableCount(DEFAULT_LOTTO_FEE);
        final int manualCount = getValidManualLottoCount(maxCount);
        final List<LottoTicket> manualTickets = getValidManualLottoTickets(manualCount);
        final List<LottoTicket> autoTickets = createAutoLottoTickets(maxCount - manualCount);

        final LottoStore lottoStore = new LottoStore(mergeTickets(manualTickets, autoTickets));
        lottoStore.sellAllTo(customer);

        ResultView.printPurchasedCount(manualTickets.size(), autoTickets.size());
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

    private static int getValidManualLottoCount(final int maxCount) {
        return getValueUntilValid(() -> getManualLottoCount(maxCount));
    }

    private static int getManualLottoCount(final int maxCount) {
        final int manualLottoCount = getManualLottoCountFromInput();
        if (manualLottoCount > maxCount) {
            throw new LottoException("해당 개수만큼 로또 구입이 불가능합니다");
        }
        return manualLottoCount;
    }

    private static int getManualLottoCountFromInput() {
        return parseInt(InputView.getManualLottoCount());
    }

    private static List<LottoTicket> getValidManualLottoTickets(final int count) {
        return mapToTickets(getValidManualLottoNumbers(count));
    }

    private static List<LottoNumbers> getValidManualLottoNumbers(final int count) {
        return getValueUntilValid(() -> getManualLottoNumbersFromInput(count));
    }

    private static List<LottoNumbers> getManualLottoNumbersFromInput(final int count) {
        return InputView.getManualLottoNumbers(count).stream()
            .map(Application::mapToLottoNumbers)
            .collect(Collectors.toList());
    }

    private static List<LottoTicket> createAutoLottoTickets(final int count) {
        return mapToTickets(createAutoLottoNumbers(count));
    }

    private static List<LottoNumbers> createAutoLottoNumbers(final int count) {
        final List<LottoNumbers> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(autoLottoNumbersSupplier.get());
        }
        return result;
    }

    private static List<LottoTicket> mergeTickets(
        final List<LottoTicket> manualTickets,
        final List<LottoTicket> autoTickets
    ) {
        final List<LottoTicket> merged = new ArrayList<>(manualTickets);
        merged.addAll(autoTickets);
        return Collections.unmodifiableList(merged);
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
        return new WiningLotto(getValidWiningLottoNumbers(), getValidBonusLottoNumber());
    }

    private static LottoNumber getValidBonusLottoNumber() {
        return getValueUntilValid(Application::getBonusLottoNumberFromInput);
    }

    private static LottoNumber getBonusLottoNumberFromInput() {
        return mapToLottoNumber(InputView.getBonusLottoNumber());
    }

    private static LottoNumbers getValidWiningLottoNumbers() {
        return getValueUntilValid(Application::getWiningLottoNumbersFromInput);
    }

    private static LottoNumbers getWiningLottoNumbersFromInput() {
        return mapToLottoNumbers(InputView.getWiningLottoNumbers());
    }

    private static LottoNumber mapToLottoNumber(final String lottoNumber) {
        return LottoNumber.valueOf(parseInt(lottoNumber));
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
