package com.hskim.lotto.model;

import java.util.List;

@FunctionalInterface
public interface NumberMaker {

    List<Integer> makeNumbers(List<Integer> numberPool, int size);
}
