package Lotto.domain;

import java.util.*;

public class Lottos {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Lotto> list = new ArrayList<>();

    private static int passiveLottoCnt;
    private static int automaticLottoCnt;

    public Lottos(Lotto [] lottos) {
        for (Lotto lotto : lottos) {
            list.add(lotto);
        }
    }

    public static Lottos createLottosWithPassive(int automaticLottoCnt, List<Lotto> passiveLottos) {
        initLottoCount(automaticLottoCnt, passiveLottos.size());

        List<Integer> allNumbers = createAllNumbers();

        List<Lotto> myLottoList = addPassiveLottos(passiveLottos);

        for (int i = 0; i < automaticLottoCnt; ++i) {
            myLottoList = pickLottoNumbers(myLottoList, allNumbers);
        }

        return new Lottos(myLottoList.toArray(new Lotto[myLottoList.size()]));
    }

    private static void initLottoCount(int automaticLottosCount, int passiveLottoCount) {
        automaticLottoCnt = automaticLottosCount;
        passiveLottoCnt = passiveLottoCount;
    }

    private static List<Lotto> addPassiveLottos(List<Lotto> passiveLottos) {
        List<Lotto> list = new ArrayList<>();

        list.addAll(passiveLottos);

        return list;
    }

    private static List<Integer> createAllNumbers() {
        List<Integer> tmpNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_MAX_NUMBER; ++i) {
            tmpNumbers.add(i+1);
        }

        return tmpNumbers;
    }

    private static List<Lotto> pickLottoNumbers(List<Lotto> myLottoList, List<Integer> allNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        Collections.shuffle(allNumbers);
        for (int j = 0; j < LOTTO_NUMBER_SIZE; ++j) {
            lottoNumbers.add(allNumbers.get(j));
        }
        Collections.sort(lottoNumbers);

        myLottoList.add(new Lotto(lottoNumbers));

        return myLottoList;
    }

    private static int getSameRankCnt(Map<EqualLottoCntInfo, Integer> winningLottoMap, EqualLottoCntInfo equalLottoCntInfo) {
        int cnt;
        if (winningLottoMap.containsKey(equalLottoCntInfo)) {
            cnt = winningLottoMap.get(equalLottoCntInfo);
            cnt += 1;
        } else {
            cnt = 1;
        }
        return cnt;
    }

    public Map<EqualLottoCntInfo, Integer> findWinningLotto(Lotto winningNumbers) {
        Map<EqualLottoCntInfo, Integer> winningLottoRankMap = new HashMap<>();

        for (Lotto lotto : list) {
            int equalCount = lotto.findWinningLottoCnt(winningNumbers);
            boolean isBonus = lotto.isBonusNumber(winningNumbers);

            EqualLottoCntInfo equalLottoCntInfo = EqualLottoCntInfo.findEqualLottoInfo(equalCount, isBonus);

            int cnt = getSameRankCnt(winningLottoRankMap, equalLottoCntInfo);
            winningLottoRankMap.put(equalLottoCntInfo, cnt);
        }

        return winningLottoRankMap;
    }


    public Lotto getLotto(int idx) {
        return list.get(idx);
    }

    public int getPassiveLottoCnt() {
        return this.passiveLottoCnt;
    }

    public int getAutomaticLottoCnt() {
        return this.automaticLottoCnt;
    }


}
