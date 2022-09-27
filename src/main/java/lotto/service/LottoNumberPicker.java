package lotto.service;


import java.util.List;

public interface LottoNumberPicker {

    int LOTTO_LENGTH = 6;

    int MAX_BOUND_NUM = 100;

    List<Integer> pick();
}
