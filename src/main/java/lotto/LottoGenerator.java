package lotto;

public interface LottoGenerator {
    int BASE_INDEX = 0;
    int MINIMUM_NUMBER = 1;
    int MAXIMUM_NUMBER = 45;

    Lotto generateLotto();
}
