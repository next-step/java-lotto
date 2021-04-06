package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int MIN_LOTTO_COUNT = 1;

    private final List<Lotto> lottoList;
    private final LottoTicketType lottoTicketType;

    public LottoTicket(int count) {
        validate(count);
        this.lottoList = generateLottoList(count);
        this.lottoTicketType = LottoTicketType.AUTO;
    }

    public LottoTicket(List<String> lottoNumberList) {
        validate(lottoNumberList);
        this.lottoList = generateLottoList(lottoNumberList);
        this.lottoTicketType = LottoTicketType.COMPLEX;
    }

    public LottoTicket(List<String> lottoNumberList, LottoTicketType lottoTicketType) {
        validate(lottoNumberList);
        this.lottoList = generateLottoList(lottoNumberList);
        this.lottoTicketType = lottoTicketType;
    }

    private void validate(int count) {
        if (count < MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException("최소 " + MIN_LOTTO_COUNT + "개 이상의 구매수량을 입력해 주세요");
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
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().limit(LottoConstant.MAX_LOTTO_COUNT).mapToInt(Integer::intValue).toArray();
    }

    private int[] generateLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(LottoConstant.NUMBER_DELIMITER)).mapToInt(value -> Integer.parseInt(value.trim())).toArray();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public LottoTicketType getLottoTicketType() {
        return lottoTicketType;
    }

    public int getCount() {
        return this.lottoList.size();
    }

    public LottoRanks inquiryRankList(int[] winNumbers, int bonusNumber) {
        Lotto.validateLottoNumbers(winNumbers);
        List<LottoRank> lottoRankList = this.lottoList.stream().map(lotto -> lotto.inquiryRank(winNumbers, bonusNumber)).collect(Collectors.toList());
        return new LottoRanks(lottoRankList);
    }

}
