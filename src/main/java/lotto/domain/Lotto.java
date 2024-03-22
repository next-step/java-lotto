package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.ConstUtils.*;

public class Lotto {

    private final List<LottoBall> lottoBalls;

    public Lotto() {
        this.lottoBalls = getAutoLottoBalls();
    }

    public Lotto(List<Integer> manualNumbers) {
        validateLottoNumbersCount(manualNumbers);

        this.lottoBalls = new ArrayList<>();
        manualNumbers.forEach(number -> this.lottoBalls.add(LottoBall.selectLottoBall(number)));
    }

    public LottoWinInfo countMatchWithWinningLottoNumbers(Lotto winningLottoNumbers) {
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

    private List<LottoBall> getAutoLottoBalls() {
        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_RANGE; i <= MAXIMUM_LOTTO_RANGE; i++) {
            randomLottoNumbers.add(i);
        }
        Collections.shuffle(randomLottoNumbers);
        randomLottoNumbers = randomLottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(randomLottoNumbers);

        return randomLottoNumbers.stream()
                .map(LottoBall::selectLottoBall)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbersCount(List<Integer> manualLottoNumbers) {
        if (manualLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수는 6개여야 합니다.");
        }
    }
}
