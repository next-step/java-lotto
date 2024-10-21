package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(Integer... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                   .map(LottoNumber::new)
                   .collect(Collectors.toList())
        );
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 정확히 서로 다른 숫자 6개여야 합니다.");
        }
    }

    public static LottoTicket createByString(String lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers.split(","))
                                     .map(num -> new LottoNumber(Integer.parseInt(num.trim())))
                                     .collect(Collectors.toList())
        );
    }

    public static LottoTicket createAuto() {
        List<LottoNumber> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                                             .mapToObj(LottoNumber::new)
                                             .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new LottoTicket(numbers.subList(0, LOTTO_SIZE));
    }

    public Winning calculateWinningResult(LottoWinningNumbers lottoWinningNumbers) {
        int matchCount = lottoWinningNumbers.matchCount(this);
        boolean matchBonus = lottoWinningNumbers.hasBonus(this);
        return Winning.fromMatchCount(matchCount, matchBonus);
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
