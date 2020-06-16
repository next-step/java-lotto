package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {
    public static final String SEPARATOR = ",";

    private List<LottoNumbers> lottoTicket;

    private LottoTicket(int quantity) {
        this(quantity, Collections.emptyList());
    }

    private LottoTicket(int quantity, List<String> enteredManualNumbers) {
        checkQuantity(quantity);

        int autoSize = quantity - enteredManualNumbers.size();
        List<LottoNumbers> manualTicket = generateManualNumbers(enteredManualNumbers);
        List<LottoNumbers> autoTicket = generateAutoTicket(autoSize);

        this.lottoTicket = Stream.concat(manualTicket.stream(), autoTicket.stream())
                .collect(Collectors.toList());
    }

    public static LottoTicket create(int quantity) {
        return new LottoTicket(quantity);
    }

    public static LottoTicket create(int quantity, List<String> enteredManualNumbers) {
        return new LottoTicket(quantity, enteredManualNumbers);
    }

    public List<LottoNumbers> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    public List<LottoNumber> tellLottoNumbers(int i) {
        return lottoTicket.get(i).getLottoNumbers();
    }

    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("구매 장수가 없습니다.");
        }
    }

    private List<LottoNumbers> generateManualNumbers(List<String> enteredManualNumbers) {
        List<LottoNumbers> manualTicket = new ArrayList<>();
        for (String enteredNumber : enteredManualNumbers) {
            List<LottoNumber> manualNumber = Arrays.stream(enteredNumber.split(SEPARATOR))
                    .map(number -> LottoNumber.create(Integer.parseInt(number.trim())))
                    .collect(Collectors.toList());
            manualTicket.add(LottoNumbers.createManual(manualNumber));
        }
        return manualTicket;
    }

    private List<LottoNumbers> generateAutoTicket(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoNumbers.createAuto())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }

}
