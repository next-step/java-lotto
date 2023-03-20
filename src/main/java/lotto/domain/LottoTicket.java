package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final Set<LottoNumber> lottoNumbers;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private LottoRank lottoRank;

    // 자동생성
    public LottoTicket() {
        this(getRandomLottoNum());
    }

    // 문자열 생성
    public LottoTicket(String numbers) {
        this(initStringNumToSet(numbers));
    }

    // 수동생성
    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        vaildLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void vaildLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 정합성 에러");
        }
    }

    private static Set<LottoNumber> getRandomLottoNum() {
        List<Integer> lottoNumbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .boxed().collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        int startIndex = 0;
        return lottoNumbers.subList(startIndex, LOTTO_NUMBER_LENGTH)
                .stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toSet());
    }

    private static Set<LottoNumber> initStringNumToSet(String lottoNumbers) {
        lottoNumbers = lottoNumbers.replace(" ", "");

        Set<LottoNumber> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt).map(LottoNumber::getLottoNumber)
                .collect(Collectors.toSet());

        return numbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public void setLottoRank(LottoRank lottoRank) {
        this.lottoRank = lottoRank;
    }
}
