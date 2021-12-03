package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_START_INDEX = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final List<LottoNumber> CACHED_LOTTO_NUMBERS;

    static {
        CACHED_LOTTO_NUMBERS = IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX + 1)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("lottoNumbers.size() 가 " + LOTTO_NUMBERS_SIZE + "이 아닙니다");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket randomLottoTicket() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(CACHED_LOTTO_NUMBERS);
        Collections.shuffle(lottoNumbers);
        return customLottoTicket(lottoNumbers.subList(LOTTO_NUMBERS_START_INDEX, LOTTO_NUMBERS_SIZE));
    }

    public static LottoTicket customLottoTicket(int... numbers) {
        return customLottoTicket(Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static LottoTicket customLottoTicket(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(copiedLottoNumbers);
        return new LottoTicket(copiedLottoNumbers);
    }
}
