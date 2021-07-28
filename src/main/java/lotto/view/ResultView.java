package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public interface ResultView {
    void printLottoList(List<Lotto> lottoList);

    void printException(Exception e);
}
