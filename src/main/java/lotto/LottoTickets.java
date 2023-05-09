package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    ArrayList<List<Integer>> tickets = new ArrayList<>();

    public LottoTickets(String price) {
        int numberOfTickets = Integer.parseInt(price) / 1000;
        List<Integer> candidateNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        IntStream.range(0, numberOfTickets)
                .forEach(i -> {
                    Collections.shuffle(candidateNumbers);
                    tickets.add(candidateNumbers);
                });
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public boolean checkValidTickets() {
        return tickets.stream()
                .allMatch(ticket -> ticket.stream().allMatch(num -> num >= 1 && num <= 45));
    }
}
