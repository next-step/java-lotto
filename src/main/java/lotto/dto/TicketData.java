package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicketData {
    private final List<NumberData> numbersData;

    public TicketData(List<NumberData> numbersData) {
        this.numbersData = numbersData;
    }

    public List<Integer> getNumbersData() {
        List<Integer> numbers = new ArrayList<>();
        for (NumberData lottoNumber : numbersData) {
            numbers.add(
                lottoNumber.getNumber()
            );
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketData that = (TicketData) o;
        return Objects.equals(numbersData, that.numbersData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersData);
    }
}
