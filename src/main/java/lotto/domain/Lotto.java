package lotto.domain;

import lotto.dto.WinningInfoDTO;
import lotto.dto.WinningLottoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1_000;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private List<LottoNumber> numbers;

    public Lotto() {
        List<LottoNumber> numbersRange = new ArrayList<>();
        for (int number = START_NUMBER; number <= END_NUMBER; number++) {
            numbersRange.add(LottoNumber.of(number));
        }
        Collections.shuffle(numbersRange);
        this.numbers = new ArrayList<>(purchasing(numbersRange));

    }

    public Lotto(String value) {
        List<LottoNumber> numbers = new ArrayList<>(Parser.numbersParsing(value));
        duplicationCheck(numbers);
        this.numbers = numbers;
    }

    public int correctCount(List<LottoNumber> values) {
        return values.stream()
                .filter(value -> this.numbers.contains(value))
                .collect(Collectors.toList())
                .size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    private List<LottoNumber> purchasing(List<LottoNumber> numbersRange) {
        List<LottoNumber> game = numbersRange.subList(0, 6);
        Collections.sort(game);
        return game;
    }

    public WinningInfoDTO winningInfo(WinningLottoDTO winningLottoDTO) {
        Lotto winningLotto = winningLottoDTO.getWinningLotto();
        LottoNumber bonusNumber = winningLottoDTO.getBonus();
        int correctCount = winningLotto.correctCount(numbers);
        boolean bonusCorrect = this.numbers.contains(bonusNumber);
        return new WinningInfoDTO(correctCount, bonusCorrect, Winning.winningAmount(correctCount, bonusCorrect));
    }

    private void duplicationCheck(List<LottoNumber> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException("번호에 중복이 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
