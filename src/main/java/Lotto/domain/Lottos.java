package Lotto.domain;

import Lotto.view.InputView;

import java.util.*;

public class Lottos {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<MyLotto> list = new ArrayList<>();

    private static int passiveLottoCnt;

    public Lottos(MyLotto[] myLottos) {
        for (MyLotto myLotto : myLottos) {
            list.add(myLotto);
        }
    }


    public static Lottos createLottosWithPassive(int allLottoCnt, List<MyLotto> passiveMyLottos) {
        initLottoCount(passiveMyLottos.size());

        List<Integer> allNumbers = createAllNumbers();

        List<MyLotto> myMyLottoList = addPassiveLottos(passiveMyLottos);

        int automaticLottoCnt = allLottoCnt - passiveMyLottos.size();
        for (int i = 0; i < automaticLottoCnt; ++i) {
            myMyLottoList = pickLottoNumbers(myMyLottoList, allNumbers);
        }

        return new Lottos(myMyLottoList.toArray(new MyLotto[myMyLottoList.size()]));
    }

    private static void initLottoCount(int passiveLottoCount) {
        passiveLottoCnt = passiveLottoCount;
    }

    private static List<MyLotto> addPassiveLottos(List<MyLotto> passiveMyLottos) {
        List<MyLotto> list = new ArrayList<>();

        list.addAll(passiveMyLottos);

        return list;
    }

    private static List<Integer> createAllNumbers() {
        List<Integer> tmpNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_MAX_NUMBER; ++i) {
            tmpNumbers.add(i+1);
        }

        return tmpNumbers;
    }

    private static List<MyLotto> pickLottoNumbers(List<MyLotto> myMyLottoList, List<Integer> allNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        Collections.shuffle(allNumbers);
        for (int j = 0; j < LOTTO_NUMBER_SIZE; ++j) {
            lottoNumbers.add(allNumbers.get(j));
        }
        Collections.sort(lottoNumbers);

        myMyLottoList.add(new MyLotto(lottoNumbers));

        return myMyLottoList;
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

    public static List<MyLotto> createPassiveLotto(int passiveLottoCnt) {
        List<MyLotto> passiveMyLottos = new ArrayList<>();
        for (int i = 0; i < passiveLottoCnt; ++i) {
            passiveMyLottos.add(new MyLotto(InputView.inputPassiveLotto()));
        }
        return passiveMyLottos;
    }

    public Map<EqualLottoCntInfo, Integer> findWinningLotto(WinningLotto winningNumbers) {
        Map<EqualLottoCntInfo, Integer> winningLottoRankMap = new HashMap<>();

        for (MyLotto myLotto : list) {
            int equalCount = myLotto.findWinningLottoCnt(winningNumbers);
            boolean isBonus = myLotto.isBonusNumber(winningNumbers);

            EqualLottoCntInfo equalLottoCntInfo = EqualLottoCntInfo.findEqualLottoInfo(equalCount, isBonus);

            int cnt = getSameRankCnt(winningLottoRankMap, equalLottoCntInfo);
            winningLottoRankMap.put(equalLottoCntInfo, cnt);
        }

        return winningLottoRankMap;
    }


    public MyLotto getLotto(int idx) {
        return list.get(idx);
    }

    public int getPassiveLottoCnt() {
        return this.passiveLottoCnt;
    }

    public int getAllLottoCnt() {
        return list.size();
    }
}
