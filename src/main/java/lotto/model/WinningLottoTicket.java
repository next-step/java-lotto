package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.utils.LottoConstant.*;

public class WinningLottoTicket {
    private List<Integer> numbers;

    private WinningLottoTicket(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static WinningLottoTicket newInstance(List<Integer> numbers) {
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
        return new WinningLottoTicket(numbers);
    }
}
