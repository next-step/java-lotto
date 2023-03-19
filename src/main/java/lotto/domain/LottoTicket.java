package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final Set<LottoNumber> lottoNumbers;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_LENGTH = 6;

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

    // 정합성 체크
    private void vaildLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 정합성 에러");
        }
    }

    // 랜덤번호뽑기
    public static Set<LottoNumber> getRandomLottoNum() {
        List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
                .boxed().collect(Collectors.toList());

        // 섞고
        Collections.shuffle(lottoNumbers);

        int startIndex = 0;
        return lottoNumbers.subList(startIndex, LOTTO_LENGTH)
                .stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toSet());
    }

    public static Set<LottoNumber> initStringNumToSet(String lottoNumbers) {
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
