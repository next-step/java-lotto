package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AutoLottoStrategyTest {

    private LottoStrategy lottoStrategy;

    /*
    * Q. 궁금한점 질문 드립니다.
    * 이전 자동차경주에서 '테스트하기 힘든 코드를 테스트 가능한 구조'로 만들기 영상에서
    * 다음과 같은 전략패턴으로 랜덤 생성을 빼내었는데요.
    * Lotto 전략을 적용한 로또 생성은 테스트할 수 있었지만,
    * 전략이 올바른가?에 대한 테스트는 하지 못했던것 같읏빈다.
    * 지금 상황에서도 마찬가지로 자동 로또 생성 전략이 올바른지 '테스트'할 수 있는 방법은 없을까요?
    * https://softwareengineering.stackexchange.com/questions/356456/testing-a-function-that-uses-random-number-generator
    * 위 링크의 수준의 테스트 정도만 가능한지 궁금합니다.
    * */
    @Test
    void makeLottoTest() {
        lottoStrategy = new AutoLottoStrategy();
        List<Integer> numbers = lottoStrategy.makeLotto();
        System.out.println(numbers);
    }
}
