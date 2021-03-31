package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final String NUMBER_DELIMITER = ",";

    private final List<Lotto> lottoList;

    public LottoTicket(int count) {
        validate(count);
        this.lottoList = generateLottoList(count);
    }

    public LottoTicket(List<String> lottoNumberList) {
        validate(lottoNumberList);
        this.lottoList = generateLottoList(lottoNumberList);
    }

    private void validate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("최소 1개 이상의 구매수량을 입력해 주세요");
        }
    }

    private void validate(List<String> lottoNumberList) {
        if (lottoNumberList == null || lottoNumberList.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> generateLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(generateLottoNumbers()));
        }
        return lottoList;
    }

    private List<Lotto> generateLottoList(List<String> lottoNumberList) {
        List<Lotto> lottoList = new ArrayList<>();
        for (String lottoNumbers : lottoNumberList) {
            lottoList.add(new Lotto(generateLottoNumbers(lottoNumbers)));
        }
        return lottoList;
    }

    private int[] generateLottoNumbers() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER ).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().limit(LottoConstant.MAX_LOTTO_COUNT).mapToInt(Integer::intValue).toArray();
    }

    private int[] generateLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(NUMBER_DELIMITER)).mapToInt(value -> Integer.parseInt(value.trim())).toArray();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public int getCount() {
        return this.lottoList.size();
    }

    public LottoRanks inquiryRankList(int[] winNumbers, int bonusNumber) {
        Lotto.validateLottoNumbers(winNumbers);
        return new LottoRanks(this.lottoList.stream().map(lotto -> lotto.inquiryRank(winNumbers, bonusNumber)).collect(Collectors.toList()));
    }

}
