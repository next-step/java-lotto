package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Ticket> tickets = new ArrayList<>();


    public Lotto(Amount amount, LottosGenerator lottosGenerator) {
        tickets = lottosGenerator.generate(amount);
    }



    public List<Ticket> getTickets() {
        return tickets;
    }
}
