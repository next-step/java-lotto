package lotto.domain;

import java.util.*;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class LottoRaffle {

    private Set<Integer> raffleNumbers;

    public LottoRaffle() {
        this.raffleNumbers = new TreeSet<>();
    }

    public Set<Integer> getRaffleNumber() {
        System.out.println("지금부터 로또 추첨을 시작하겠습니다!");
        pop(new ArrayList<>(shuffleNumbers()));

        return Collections.unmodifiableSet(raffleNumbers);
    }

    private void pop(List<Integer> lottoNumbers) {
        if (raffleNumbers.size() == 6) {
            return;
        }
        raffleNumbers.add(lottoNumbers.remove(lottoNumbers.size() - 1));
        System.out.println(raffleNumbers.toString() + "..");
        pop(lottoNumbers);
    }
}
