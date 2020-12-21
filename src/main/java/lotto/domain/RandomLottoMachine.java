package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomLottoMachine implements LottoMachine{
    private static final String PRICE_ERROR_MESSAGE = "자동 로또를 발급하기 위한 최소 금액은 1000원 입니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";
    private static final List<LottoNumber> lottoNumbers;
    private final int count;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket generate() {
        lottoNumbersShuffle();
        List<LottoNumber> lottoNumbers = RandomLottoMachine.lottoNumbers.subList(BASE_INDEX, NUMBER_COUNT);
        lottoNumbers.sort(LottoNumber::ascendingSort);
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    @Override
    public LottoTickets generates() {
        List<LottoTicket> lottoTickets = Stream.generate(this::generate)
                .limit(count)
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    public RandomLottoMachine(int price, int manualLottoCount) {
        count = purchaseQuantity(calculateRemainingMoney(price, manualLottoCount));
    }

    public LottoNumber CreateBonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if (winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        };
        return lottoNumber;
    }

    protected int purchaseQuantity(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return price / ONE_LOTTO_PRICE;
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private int calculateRemainingMoney(int price, int manualPurchaseLottoCount) {
        return price - (manualPurchaseLottoCount * 1000);
    }

    private LottoNumber stringToLottoNumber(String string) {
        int number = 0;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
        return new LottoNumber(number);
    }
}
