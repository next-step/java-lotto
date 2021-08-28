package lotto.domain;

import java.util.*;

public class AutoGenerateStrategy implements GenerateNumStrategy {
    public final static int NUMS_PER_LOTTO = 6;
    private final List<Integer> selectableNums;

    public AutoGenerateStrategy() {
        List<Integer> numList = new ArrayList<>(LottoMachine.LOTTO_MAX_NUM);

        for (int i = 1; i <= LottoMachine.LOTTO_MAX_NUM; i++) {
            numList.add(i);
        }

        selectableNums = numList;
    }

    public Lottos generate(int totalLottosNum, int numsPerLotto) {
        Integer[][] lottoArray = new Integer[totalLottosNum][numsPerLotto];

        for (int i = 0; i < totalLottosNum; i++) {
            Collections.shuffle(selectableNums);
            for (int j = 0; j < NUMS_PER_LOTTO; j++) {
                lottoArray[i][j] = selectableNums.get(j);
            }
        }

        List<Lotto> lottoList = new ArrayList<>(totalLottosNum);
        for (int i = 0; i < totalLottosNum; i++) {
            lottoList.add(new Lotto(Arrays.asList(lottoArray[i])));
        }

        return new Lottos(lottoList);
    }
}
