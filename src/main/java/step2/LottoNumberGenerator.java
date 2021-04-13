package step2;

import java.util.List;

public interface LottoNumberGenerator {
    int lottoMaxNumber = 45;
    int lottoMinNumber = 1;
    int lottoNumberCount = 6;
    List<Integer> generateNumbers();
}
