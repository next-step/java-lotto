package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {
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
        return enteredManualNumbers.stream()
                .map(enteredNumber -> LottoNumbers.createManual(enteredNumber))
                .collect(Collectors.toList());
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
