package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

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
        if(count < 1) {
            throw new IllegalArgumentException("최소 1개 이상의 구매수량을 입력해 주세요");
        }
    }

    private void validate(List<String> lottoNumberList) {
        if(lottoNumberList==null || lottoNumberList.size()==0) {
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
        Random random = new Random();
        Set<Integer> lottoNumberSet = new HashSet<>();
        while (lottoNumberSet.size() < LottoConstant.MAX_LOTTO_COUNT) {
            lottoNumberSet.add(random.nextInt(LottoConstant.MAX_LOTTO_NUMBER-1) + LottoConstant.MIN_LOTTO_NUMBER);
        }
        return lottoNumberSet.stream().mapToInt(a->a).toArray();
    }

    private int[] generateLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(NUMBER_DELIMITER)).mapToInt(Integer::new).toArray();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public int getCount() {
        return this.lottoList.size();
    }

    public LottoRanks inquiryRankList(int[] winNumbers) {
        return new LottoRanks(this.lottoList.stream().map(lotto -> lotto.inquiryRank(winNumbers)).collect(Collectors.toList()));
    }
}
