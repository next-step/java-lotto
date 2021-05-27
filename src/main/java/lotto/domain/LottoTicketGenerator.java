package lotto.domain;

import lotto.common.ErrorCode;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicketGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS_CACHE;
    private static final String LOTTO_NUMBERS_TEXT_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    static {
        LOTTO_NUMBERS_CACHE = new ArrayList<>();

        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS_CACHE.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS_CACHE);
        List<LottoNumber> lottoNumbers = new ArrayList<>(LOTTO_NUMBERS_CACHE.subList(0, LOTTO_NUMBERS_LENGTH));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<LottoNumber> generate(String lottoNumbersText) {
        List<LottoNumber> resultLottoNumbers = Arrays.stream(lottoNumbersText.split(LOTTO_NUMBERS_TEXT_SPLIT_REGEX))
                                                    .map(Integer::parseInt)
                                                    .sorted()
                                                    .map(LottoNumber::new)
                                                    .collect(Collectors.toList());

        throwInvalidLottoNumbers(resultLottoNumbers);
        return resultLottoNumbers;
    }

    private void throwInvalidLottoNumbers(List<LottoNumber> inputNumbers) {
        //로또 넘버 길이 체크
        if (inputNumbers.size() != LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
        }

        //로또 넘버 중복 체크
        if (new HashSet<LottoNumber>(inputNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
