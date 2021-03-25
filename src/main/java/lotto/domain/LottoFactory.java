package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    private static final String MANUAL_QUANTITY_AMOUNT_ERROR = "구매 금액이 부족합니다.";
    private static final int LOTTO_AMOUNT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 46;
    private static final List<Integer> DEFAULT_NUMBER_RANGE = IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
            .boxed()
            .collect(Collectors.toList());

    private LottoFactory() {
    }

    public static LottoTickets joinLottoTickets(List<LottoTicket> autoTickets, List<LottoTicket> manualTickets) {
        List<LottoTicket> result = new ArrayList<>();
        result.addAll(manualTickets);
        result.addAll(autoTickets);

        return new LottoTickets(result);
    }

    public static List<LottoTicket> createAutoLottoTickets(int buyAmount, List<List<Integer>> inputManual) {
        isBuyAmountValid(buyAmount);
        isManualQuantityOverValid(buyAmount, inputManual.size());
        return Stream.generate(LottoFactory::createAutoLotto)
                .limit(amountToAutoQuantity(buyAmount, inputManual.size()))
                .collect(Collectors.toList());
    }

    private static LottoTicket createAutoLotto() {
        return new LottoTicket(lottoNumberRandom());
    }

    public static List<LottoTicket> createManualLottoTickets(List<List<Integer>> inputManual) {
        return inputManual.stream()
                .map(LottoFactory::createManualLotto)
                .collect(Collectors.toList());
    }

    private static LottoTicket createManualLotto(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoWinners createWinners(List<Integer> numbers, int inputBonusNumber) {
        LottoNumbers winners = new LottoNumbers(numbers);
        LottoNumber bonus = LottoNumber.of(inputBonusNumber);
        return new LottoWinners(winners, bonus);
    }

    private static List<Integer> lottoNumberRandom() {
        Collections.shuffle(DEFAULT_NUMBER_RANGE);

        List<Integer> result = DEFAULT_NUMBER_RANGE.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    private static void isManualQuantityOverValid(int buyAmount, int manualQuatity) {
        int manualAmount = manualQuatity * LOTTO_AMOUNT;
        if (buyAmount < manualAmount) {
            throw new IllegalArgumentException(MANUAL_QUANTITY_AMOUNT_ERROR);
        }
    }

    private static void isBuyAmountValid(int buyAmount) {
        if (buyAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
    }

    private static int amountToAutoQuantity(int buyAmount, int manualQuantity) {
        return (buyAmount / LOTTO_AMOUNT) - manualQuantity;
    }
}
