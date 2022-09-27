package lotto.service;


import java.util.List;

public interface LottoNumberPicker {

    int LOTTO_LENGTH = 6;
    List<Integer> pick();
}