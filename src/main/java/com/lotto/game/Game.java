package com.lotto.game;

import com.lotto.model.LottoResult;
import com.lotto.model.Lottos;
import com.lotto.model.WinningNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static final int LOTTO_PRICE = 1000;

    //구입하다.
    public static Lottos purchase(int money) {
        return new Lottos(money / LOTTO_PRICE);
    }

    //당첨번호 입력받다.
    public static WinningNumbers makeWinningNumbers(List<Integer> numbers, int bonusNumber) {
        Set<Integer> numberSet = new HashSet<>();

        numbers.forEach((number) -> {
            if (numberSet.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다. 숫자들 목록 " + numbers);
            }

            numberSet.add(number);
        });

        return new WinningNumbers(numberSet, bonusNumber);
    }

    public static LottoResult check(WinningNumbers winningNumbers, Lottos lottos) {
        return new LottoResult(winningNumbers, lottos);
    }
}
