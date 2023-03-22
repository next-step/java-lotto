package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final Set<LottoNumber> lottoNumbers;
    private static final int LOTTO_TICKET_SIZE = 6;

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
        if (lottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 정합성 에러");
        }
    }

    private static Set<LottoNumber> getRandomLottoNum() {
        List<LottoNumber> lottoNumbers = LottoNumber.getAllLottoNumbers();

        Collections.shuffle(lottoNumbers);

        int startIndex = 0;

        return lottoNumbers.subList(startIndex, LOTTO_TICKET_SIZE).stream()
                .sorted(Comparator.comparingInt(LottoNumber::getLottoNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static Set<LottoNumber> initStringNumToSet(String lottoNumbers) {
        lottoNumbers = lottoNumbers.replace(" ", "");

        Set<LottoNumber> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt).map(LottoNumber::getLottoNumber)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

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
