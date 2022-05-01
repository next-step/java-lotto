package Lotto;

import java.util.*;

public class MyLottoList {

    private List<Lotto> list = new ArrayList<>();

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_LAST_NUMBER = 6;

    public MyLottoList() {
    }

    public void createLottoNumbers(int lottoCount) {
        List<Integer> tmpNumbers = new ArrayList<>();
        createAllNumbers(tmpNumbers);

        for (int i = 0; i < lottoCount; ++i) {
            pickLottoNumbers(tmpNumbers);
        }
    }

    private void createAllNumbers(List<Integer> tmpNumbers) {
        for (int i = 0; i < LOTTO_MAX_NUMBER; ++i) {
            tmpNumbers.add(i+1);
        }
    }

    private void pickLottoNumbers(List<Integer> tmpNumbers) {
        int[] lottoNumbers = new int[LOTTO_LAST_NUMBER];

        Collections.shuffle(tmpNumbers);
        for (int j = 0; j < LOTTO_LAST_NUMBER; ++j) {
            lottoNumbers[j] = tmpNumbers.get(j);
        }

        Arrays.sort(lottoNumbers);

        list.add(new Lotto(lottoNumbers));
    }

    public Lotto getLotto(int idx) {
        return list.get(idx);
    }

    public int getLottoCnt() {
        return list.size();
    }

    public Map<Integer,Integer> checkWinningLotto(int[] winningNumbers) {
        Map<Integer,Integer> winningLottoMap = new HashMap<>();

        for(Lotto lotto : list) {
            int winningCount = lotto.checkWinningLottoNumbers(winningNumbers);
            int rank = 7 - winningCount;

            int cnt;
            if (winningLottoMap.containsKey(rank)) {
                cnt = winningLottoMap.get(rank);
                cnt += 1;
            } else {
                cnt = 1;
            }
            winningLottoMap.put(rank, cnt);
        }

        return winningLottoMap;
    }
}
