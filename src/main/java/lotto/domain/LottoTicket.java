package lotto.domain;

import java.util.*;

public class LottoTicket {

    private final List<Lotto> lottoList;

    public LottoTicket(int count) {
        this.lottoList = generateLottoList(count);
    }

    private List<Lotto> generateLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(generateLottoNumbers()));
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

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getCount() {
        return this.lottoList.size();
    }
}
