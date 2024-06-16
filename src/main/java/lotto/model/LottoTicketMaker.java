package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {
    public static List<LottoTicket> purchase(int payAmount) {
        int ticketCount = payAmount / LottoTicket.LOTTO_TICKET_PRICE;
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new LottoTicket(generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumbers() {
        return IntStream.rangeClosed(LottoNumber.LOTTO_NUBER_MIN, LottoNumber.LOTTO_NUBER_MAX)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.shuffle(list, new Random());
                            return list.stream().limit(LottoTicket.LOTTO_NUBERS_SIZE).collect(Collectors.toList());
                        }));
    }


}
