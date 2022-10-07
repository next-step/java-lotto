package lotto.services;

import lotto.strategy.PickNumberStrategy;

import java.util.Set;

public class PickNumberService {
    public Set<Integer> pickNumbers(PickNumberStrategy strategy) {
        return strategy.getNumbers();
    }
}
