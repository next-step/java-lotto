package lottogame.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoNumber {
    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int WINNER_EXIST = 1;

    private ArrayList<Integer> lottoElement = new ArrayList<>();

    public LottoNumber(List<Integer> input) {
        LottoUtil.checkLottoNumber(input);

        IntStream.range(0, ONE_UNIT_OF_LOTTO)
                .forEach(i -> lottoElement.add(input.get(i)));
        LottoUtil.checkLottoNumber(lottoElement);
    }

    public ArrayList<Integer> getElement() {
        return lottoElement;
    }

    WinnerGroup compareWinningNumber(int[] winningLottoNumber, int bonusball) {
        int wingingCount = 0;
        for (int value : winningLottoNumber) {
            wingingCount = lottoElement.contains(value) ? wingingCount + 1 : wingingCount;
        }
        return new WinnerGroup(LottoRankData.match(wingingCount, lottoElement.contains(bonusball)), WINNER_EXIST);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LottoNumber other = (LottoNumber) obj;
        if (lottoElement == null) {
            if (other.lottoElement != null)
                return false;
        } else if (!lottoElement.equals(other.lottoElement))
            return false;
        return true;
    }
}
