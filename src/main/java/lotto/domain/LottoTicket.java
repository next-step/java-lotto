package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public static LottoTicket createByString(String lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers.split(", "))
                                     .map(num -> new LottoNumber(Integer.parseInt(num)))
                                     .collect(Collectors.toList())
        );
    }

    public static LottoTicket createRandom() {
        List<LottoNumber> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                                             .mapToObj(LottoNumber::new)
                                             .collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<LottoNumber> selectedNumbers = numbers.subList(0, LOTTO_SIZE);
        Collections.sort(selectedNumbers);
        return new LottoTicket(selectedNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 정확히 6개여야 합니다.");
        }
    }

    public int matchCount(LottoTicket winningNumbers) {
        return (int) lottoNumbers.stream()
                                 .filter(winningNumbers::contains)
                                 .count();
    }

    private boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
