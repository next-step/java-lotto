package lotto.step1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGen {
    private final List<Integer> numbers = new ArrayList<>(); // 뽑은 로또 번호를 저장할 리스트 변수

    //로또 번호 생성 함수
    public LottoGen() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    //로또 번호 무작위 추출 함수
    public Lotto generate() {
        Collections.shuffle(numbers);
        List<Integer> generatedLotto = numbers.subList(0, 6);
        LottoResultView.printLottoNumber(generatedLotto);
        return new Lotto(generatedLotto);
    }
}
