package lotto.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TicketData {
    private final List<NumberData> numbersData;

    public TicketData(List<NumberData> numbersData) {
        this.numbersData = numbersData;
    }

    public List<Integer> getNumbersData() {
        return numbersData.stream().map(
            numberData -> numberData.getNumber()
        ).collect(
            Collectors.toList()
        );
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
