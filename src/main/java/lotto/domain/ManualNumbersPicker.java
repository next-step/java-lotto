package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class ManualNumbersPicker implements NumberPicker {
    private final Stack<LottoTicket> lottoTickets;

    public ManualNumbersPicker() {
        lottoTickets = new Stack<>();
    }

    public ManualNumbersPicker(final List<String> manualPickedNumberLines) {
        lottoTickets = manualPickedNumberLines
                .stream()
                .map(this::makeLottoNumbers)
                .map(LottoTicket::new)
                .collect(Collectors.toCollection(Stack::new));
    }

    @Override
    public LottoTicket pick() {
        return lottoTickets.pop();
    }

    private List<LottoNumber> makeLottoNumbers(String line){
        return Arrays.stream(line.trim().split(","))
                .mapToInt(lottoNumber->Integer.parseInt(lottoNumber.trim()))
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}