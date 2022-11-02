package com.nextlevel.kky.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>(numbers);
        checkNumbersValidation(treeSet);
        this.numbers = new ArrayList<>(treeSet);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkNumbersValidation(TreeSet<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num > 45 || num < 0)) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다!");
        }
    }
}
