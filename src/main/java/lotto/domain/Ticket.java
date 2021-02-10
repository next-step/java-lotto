package lotto.domain;

import lotto.util.NumberUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ticket {

    private static final String FORMAT_REGEX = "[0-9]+(,\\s[0-9]+)*$";
    private static final String COMMA = ", ";
    private static final int LOTTO_COUNT = 6;

    private final List<Integer> lottoNumbers;

    public Ticket(String ticket) {
        validate(ticket);
        this.lottoNumbers = NumberUtils.convertStringToIntegerList(ticket);
        Collections.sort(this.lottoNumbers);
    }

    public Ticket(List<Integer> ticket) {
        this.lottoNumbers = ticket;
        Collections.sort(this.lottoNumbers);
    }

    public Stream<Integer> lottoNumberStream() {
        return lottoNumbers.stream();
    }

    public long matchNumber(Ticket newTicket) {
        return newTicket.lottoNumberStream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private void validate(String ticket) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(FORMAT_REGEX);
        Set<String> numbers = new HashSet<>(Arrays.asList(ticket.split(COMMA)));
        if (!pattern.matcher(ticket).matches()
                || numbers.size() != LOTTO_COUNT
                || !NumberUtils.isNumberInLottoRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
