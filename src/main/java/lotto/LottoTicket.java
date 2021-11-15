package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {

    private final List<LottoNumbers> lottoLines;

    public static LottoTicket publish(Dollars dollars, ShuffleStrategy shuffleStrategy) {
        checkNotNull(dollars);
        List<LottoNumbers> lottoLines = Stream.generate(() -> LottoNumbers.publish(shuffleStrategy))
                .limit(dollars.getCount())
                .collect(Collectors.toList());
        return new LottoTicket(lottoLines);
    }

    public LottoTicket(List<LottoNumbers> lottoLines) {
        checkNotNull(lottoLines);
        this.lottoLines = lottoLines;
    }

    private static void checkNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    public List<LottoNumbers> getLottoLines() {
        return Collections.unmodifiableList(lottoLines);
    }
}
