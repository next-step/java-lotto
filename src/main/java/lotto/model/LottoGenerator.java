package lotto.model;


import java.util.List;

public interface LottoGenerator {

    int START_NUM = 1;
    int LAST_NUM = 45;

    List<LottoNumber> generateLotto();
}
