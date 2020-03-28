package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.utils.LottoConstant.*;

public class LottoPurchaseTicket {
    private List<Integer> numbers;

    private LottoPurchaseTicket(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static LottoPurchaseTicket newInstance(List<Integer> numbers) {
        if(Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("lotto numbers is null or empty");
        }

        boolean isAnyOutOfRange = numbers.stream()
                .distinct()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if(isAnyOutOfRange) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }

        int size = (int) numbers.stream()
                .distinct()
                .count();
        if(size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }

        Collections.sort(numbers);
        return new LottoPurchaseTicket(numbers);
    }

    public LottoResult check(WinningLottoTicket winningLottoTicket) {
        int count = winningLottoTicket.toArray()
                .stream()
                .filter(number -> numbers.contains(number))
                .count();
        return LottoResult.of(count);
    }
}
