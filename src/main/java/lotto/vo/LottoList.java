package lotto.vo;

import aterilio.common.utils.StringUtils;
import lotto.domain.LottoGenerator;
import lotto.domain.object.Lotto;

import java.util.*;

public class LottoList {

    private static final String TO_STRING_TOKEN = "\n";

    private final List<Lotto> lottoList;

    public LottoList(final int purchaseCount) {
        final LottoGenerator generator = new LottoGenerator();
        final Lotto[] lottos = new Lotto[purchaseCount];
        for (int i = 0; i < purchaseCount; ++i) {
            lottos[i] = new Lotto(generator.create());
        }
        lottoList = new ArrayList<>(Arrays.asList(lottos));
    }

    public LottoList(final int[][] lottoLists) {
        lottoList = new ArrayList<>();
        for (int[] lotto : lottoLists) {
            lottoList.add(new Lotto(lotto));
        }
    }

    public int getCount() {
        return lottoList.size();
    }

    public LottoResultCount getResultWithGrade(final Lotto luckyNumbers, final LottoGrade grade) {
        LottoResult result = getResult(luckyNumbers);
        return result.getCountWithGrade(grade);
    }

    public LottoResult getResult(final Lotto luckyNumbers) {

        Map<LottoGrade, LottoResultCount> result = new HashMap<>();

        for (Lotto lotto : lottoList) {
            final LottoGrade grade = LottoGrade.fromMatchCount(lotto.countMatch(luckyNumbers));
            final LottoResultCount count = new LottoResultCount(result.getOrDefault(grade, new LottoResultCount()).increase());
            result.put(grade, count);
        }

        return new LottoResult(result);
    }

    @Override
    public String toString() {
        return StringUtils.serialize(lottoList.toArray(), TO_STRING_TOKEN);
    }
}
