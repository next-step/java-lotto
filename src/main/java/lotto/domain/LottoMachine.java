package lotto.domain;

import lotto.dto.LottoStatistics;
import lotto.vo.LottoMatchCount;
import lotto.vo.LottoNo;
import lotto.vo.LottoWinningNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    private static LottoMachine lottoMachine;

    private static Map<Integer, LottoNo> lottoNoInstanceMap = new HashMap<>();

    private LottoMachine() {
    }

    public LottoNo getLottoNoInstance(int number) throws IllegalArgumentException {
        if (lottoNoInstanceMap.get(number) != null) {
            return lottoNoInstanceMap.get(number);
        }

        lottoNoInstanceMap.put(number, new LottoNo(number));

        return lottoNoInstanceMap.get(number);
    }

    /**
     * 당첨번호로 통계 dto 생성
     *
     * @param lottos             구매한 로또들
     * @param lottoWinningNumber 당첨번호들
     * @param lottoProfit        수익율 dto
     * @return 당첨통계 dto
     */
    public LottoStatistics getLottoStatistics(List<Lotto> lottos,
                                              LottoWinningNumber lottoWinningNumber, LottoProfit lottoProfit) {

        lottoWinningNumber.checkWinningNumber(lottos);
        lottoWinningNumber.checkBonus(lottos);

        //노출 통계자료 생성
        return checkWinningLotto(lottos, lottoProfit);
    }

    /**
     * 구매한 로또들에 저장한 값들로
     * 당첨통계 dto 생성
     *
     * @param lottos 구매한 로또들
     * @return 로또 통계 dto
     */
    public LottoStatistics checkWinningLotto(List<Lotto> lottos, LottoProfit lottoProfit) {
        LottoMatchCount lottoMatchCount = new LottoMatchCount();

        LottoStatistics lottoStatistics = new LottoStatistics(lottoProfit, lottoMatchCount);

        //등수별 개수
        for (Lotto lotto : lottos) {
            lottoMatchCount = lottoStatistics.incrementPrizeCnt(LottoPrize.getEnumNameByIntValue(lotto.getMatchCount(), lotto.isMatchBonus()));
        }

        //수익율
        lottoProfit.calculateProfit(lottoMatchCount);

        return lottoStatistics;
    }

    public List<LottoNo> makeDuplicateNumbers(String[] winningNumbers) {
        Set<Integer> duplicateNumbers = Stream.of(winningNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        List<LottoNo> numbers = new ArrayList<>();
        duplicateNumbers.forEach(number -> numbers.add(getLottoNoInstance(number)));

        return numbers;
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }
}
