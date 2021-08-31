package lotto.domain;

import java.util.*;

public class AutoGenerateNumsStrategy implements GenerateNumStrategy {
    private final List<Integer> selectableNums;

    public AutoGenerateNumsStrategy() {
        List<Integer> numList = new ArrayList<>(LottoMachine.LOTTO_MAX_NUM);

        for (int i = 1; i <= LottoMachine.LOTTO_MAX_NUM; i++) {
            numList.add(i);
        }

        selectableNums = numList;
    }

    public Lottos generate(int totalLottosNum, int numsPerLotto) {
        List<Lotto> lottoList = new ArrayList<>(totalLottosNum);
        for (int i = 0; i < totalLottosNum; i++) {
            Collections.shuffle(selectableNums);
            lottoList.add(generateEachLotto(numsPerLotto));
        }

        return new Lottos(lottoList);
    }

    Lotto generateEachLotto(int numsPerLotto) {
        Integer[] lottoArray = new Integer[numsPerLotto];

        Collections.shuffle(selectableNums);
        for (int i = 0; i < numsPerLotto; i++) {
            lottoArray[i] = selectableNums.get(i);
        }

        return new Lotto(Arrays.asList(lottoArray));
    }
}
