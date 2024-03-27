package lotto.domain;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static List<LottoNumber> createLotto(List<Integer> shuffledNumbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        checkShuffledNumbersSize(shuffledNumbers);

        IntStream.range(0, Constant.LOTTO_SIZE)
                .forEach((number) -> lotto.add(new LottoNumber(shuffledNumbers.get(number))));

        return lotto;
    }

    public static List<Integer> shuffleNumbers() {
        List<Integer> lottoNumbers = LottoNumbers.setLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, Constant.LOTTO_SIZE);
    }

    private static void checkShuffledNumbersSize(List<Integer> shuffledNumbers) {
        if (shuffledNumbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public static Lottos lotteryTickets(int count) {
        List<Lotto> lottoList = new ArrayList<>();


        IntStream.range(0, count)
                .forEach((index) -> lottoList.add(new Lotto(shuffleNumbers())));

        return new Lottos(lottoList);
    }

}
