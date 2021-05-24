package lotto.domains;

import java.util.Arrays;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(){
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchingNumberCount(LottoNumbers winningNumber) {
        return this.lottoNumbers.matchingNumberCount(winningNumber);
    }
    //TODO 피드백 : 불변객체로 변환뒤 출력을 담당하는 객체에서 어떤형식으로 출력할지 정하게 하라.
    /*
        출력을 위한 용도로 만드신 부분 같습니다 😄
        불변객체로 반환하시고 출력을 담당하는 객체에서 어떻게 할 지 위임해보시는건 어떨까요?? 🤔
        지금이야 콘솔 출력이긴 하지만 나중에 만약 json형식이나 html 형식으로 변경 될 경우
        이 부분은 도메인 영역임에도 불구 하고 핵심로직 때문이 아닌
        출력 형식 때문에 계속 수정이 발생할 수 있습니다
        물론 이번 요구사항은 아니지만 한번 검토해주시면 감사하겠습니다 😄

        Collections.unmodifiableList
     */
    public String lottoNumbers() {
        return Arrays.toString(lottoNumbers.lottoNumbers().toArray());
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
