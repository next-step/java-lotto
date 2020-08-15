package com.hskim.lotto.model;

import java.util.List;

public interface NumberMaker {

    List<String> makeNumbers(int lowBound, int upperBound, int size);
}
