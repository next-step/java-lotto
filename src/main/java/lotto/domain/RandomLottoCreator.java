package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoCreator {

    public static final int LOTTO_PRICE = 1000;
    private static final Random RANDOM_INSTANCE = new Random();

    private static final List<Integer> ORIGINAL_LOTTO_NUMBERS =
            Stream.iterate(Ticket.LOTTO_MINIMUM_NUMBER, i -> i + 1)
                    .limit(Ticket.LOTTO_MAXIMUM_NUMBER)
                    .collect(Collectors.toList());

    public static Ticket createTicket() {

        Collections.shuffle(ORIGINAL_LOTTO_NUMBERS, RANDOM_INSTANCE);
        return new Ticket(
                ORIGINAL_LOTTO_NUMBERS.subList(0, Ticket.LOTTO_NUMBERS_SIZE),
                ORIGINAL_LOTTO_NUMBERS.get(Ticket.LOTTO_NUMBERS_SIZE));
    }

    public static List<LottoNumber> createLottoList(int money) {

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            Collections.shuffle(ORIGINAL_LOTTO_NUMBERS, RANDOM_INSTANCE);
            lottoNumberList.add(new LottoNumber(createTicket()));
        }

        return lottoNumberList;
    }
}
