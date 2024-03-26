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
        validateLottoNumber(manualNumbers);

        this.lottoBalls = new ArrayList<>();
        manualNumbers.forEach(number -> this.lottoBalls.add(LottoBall.selectLottoBall(number)));
    }

    public LottoWinInfo countMatch(Lotto lottoBalls) {
        int resultCount = (int) this.lottoBalls.stream()
                .map(lottoBalls::containNumber)
                .filter(result -> result)
                .count();

        return LottoWinInfo.valueOf(resultCount, false);
    }

    public boolean containNumber(LottoBall number) {
        return this.lottoBalls.stream()
                .anyMatch(lotto -> lotto.equals(number));
    }

    @Override
    public String toString() {
        return this.lottoBalls.toString();
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

    private void validateLottoNumber(List<Integer> manualLottoNumbers) {
        if (manualLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개여야 합니다.");
        }

        int distinctCount = (int) manualLottoNumbers.stream().distinct().count();
        if (distinctCount < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복해서 입력할 수 없습니다.");
        }
    }
}
