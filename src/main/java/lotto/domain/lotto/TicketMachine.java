package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketMachine {

    public static List<Ticket> generateTickets(List<String> numbers, String regex) {
        List<Ticket> manualLottoNumbers = new ArrayList<>();

        for (String string : numbers) {
            Ticket ticket = new Ticket(Arrays.stream(split(string, regex))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
            manualLottoNumbers.add(ticket);
        }

        return manualLottoNumbers;
    }

    private static String[] split(String string, String regex) {
        return string.split(regex);
    }

    public static Ticket generateTicket(String string, String regex) {
        return new Ticket(Arrays.stream(string.split(regex))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }
}
