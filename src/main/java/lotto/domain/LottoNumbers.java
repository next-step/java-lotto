package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.ConstUtils.*;

public class LottoNumbers {

    private final List<LottoBall> lottoBalls;

    public LottoNumbers() {
        this.lottoBalls = getAutoLottoNumbers();
    }

    public LottoNumbers(List<Integer> manualNumbers) {
        this.lottoBalls = new ArrayList<>();

        manualNumbers.forEach(number -> this.lottoBalls.add(LottoBall.selectLottoBall(number)));
    }

    public List<LottoBall> getPurchasedLottoNumber() {
        return List.copyOf(this.lottoBalls);
    }

    public LottoWinInfo countMatchWithWinningLottoNumbers(LottoNumbers winningLottoNumbers) {
        int resultCount = (int) this.lottoBalls.stream()
                .map(winningLottoNumbers::containNumbers)
                .filter(result -> result)
                .count();

        return LottoWinInfo.valueOf(resultCount, false);
    }

    @Override
    public String toString() {
        return this.lottoBalls.toString();
    }

    public boolean containNumbers(LottoBall number) {
        return this.lottoBalls.stream()
                .anyMatch(lotto -> lotto.equals(number));
    }

    private List<LottoBall> getAutoLottoNumbers() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_RANGE; i <= MAXIMUM_LOTTO_RANGE; i++) {
            lotto.add(i);
        }
        Collections.shuffle(lotto);
        lotto = lotto.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lotto);

        List<LottoBall> selectedLotto = new ArrayList<>();
        lotto.forEach(number -> selectedLotto.add(LottoBall.selectLottoBall(number)));

        return selectedLotto;
    }
}
