package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<LottoTicket> manualLottoTickets;
    private final List<LottoTicket> autoLottoTickets;

    public LottoTickets(int totalCount, List<Set<Integer>> menualLottoNumbersList, NumberGenerator numberGenerator) {

        assertTotalCount(totalCount, menualLottoNumbersList);

        int autoLottoCount = totalCount -  menualLottoNumbersList.size();

        this.autoLottoTickets = createAutoLottoTickets(autoLottoCount, numberGenerator);
        this.manualLottoTickets = createManualLottoTickets(menualLottoNumbersList);
    }

    private void assertTotalCount(int totalCount, List<Set<Integer>> menualLottoIntegersList) {
        if (totalCount < menualLottoIntegersList.size()) {
            throw new IllegalArgumentException(
                    String.format("생성할 개수 %d 보다 많은 수의 수동 로또를 입력했습니다. menualLottoIntegersList.size(): \"%d\"",
                            totalCount, menualLottoIntegersList.size()));
        }
    }

    private List<LottoTicket> createAutoLottoTickets(int count, NumberGenerator numberGenerator) {
        return IntStream.range(0, count)
                .mapToObj(i -> new AutoLottoTicket(numberGenerator))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createManualLottoTickets(List<Set<Integer>> menualLottoIntegersList) {
        return menualLottoIntegersList.stream().map(ManualLottoTicket::new).collect(Collectors.toList());
    }

    public List<LottoTicket> getManualLottoTickets() {
        return Collections.unmodifiableList(manualLottoTickets);
    }

    public List<LottoTicket> getAutoLottoTickets() {
        return Collections.unmodifiableList(autoLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(combineLists(manualLottoTickets, autoLottoTickets));
    }

    private <T> List<T> combineLists(List<T> list1, List<T> list2) {
        List<T> combinedList = new ArrayList<>();
        combinedList.addAll(list1);
        combinedList.addAll(list2);
        return combinedList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTickets)) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(manualLottoTickets, that.manualLottoTickets) && Objects.equals(autoLottoTickets, that.autoLottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoTickets, autoLottoTickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "manualLottoTickets=" + manualLottoTickets +
                ", autoLottoTickets=" + autoLottoTickets +
                '}';
    }
}
