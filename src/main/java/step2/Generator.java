package step2;

import java.util.List;

public interface Generator {
    // 테스트 코드에서 로또 번호 통제를 위해 생성
    void setNumber(String inputNumber);

    List<Integer> getLottoNumbers();
}
