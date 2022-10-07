package lotto.services;

import lotto.strategy.PickNumberStrategy;

import java.util.List;

public class PickNumberService {
    public List<Integer> pickNumbers(PickNumberStrategy strategy) {
        return strategy.getNumbers();
    }
}
