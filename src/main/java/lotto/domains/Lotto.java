package lotto.domains;

import java.util.Arrays;

public class Lotto {

    private static final int NO_MATCH = 0;
    private final LottoNumbers lottoNumbers;

    public Lotto(){
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    //TODO 피드백 : 디미터의 법칙 공부해서 리팩토링
    //당첨번호 매칭의 역할을 로또번호에 부여 ?!?!?!
    /*
        이미 LottoNumbers 라는 훌륭한 일급컬렉션을 설계하고 구현해주셨습니다 😄
        LottoNumbers 에서 값을 꺼내서 비교하지 말고 LottoNumbers 에게 당첨번호를
        주며 알려달라고 해보시는건 어떨까요?? 😄
        그럼 들여쓰기도 1단계로만 유지 할 수 있을 것 같습니다 😄
        (참고로 1단계란 의미는{ }의 블럭 단위를 의미합니다 만약 if { if {} } 인 경우엔 2단계 입니다 😅 )
        이 부분 개선 검토 부탁 드립니다 🙇
        참고하실만한 내용 공유 드립니다 🙇
        디미터법칙
        https://dundung.tistory.com/203
     */
    public int matchingNumberCount(LottoNumbers winningNumber) {
        int matchingNumberCount = NO_MATCH;
        for (int lottoNumber : lottoNumbers.lottoNumbers()) {
            if (winningNumber.contains(lottoNumber)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }
    //TODO 피드백 : 불변객체로 변환뒤 출력을 담당하는 객체에서 어떤형식으로 출력할지 정하게 하라.
    public String lottoNumbers() {
        return Arrays.toString(lottoNumbers.lottoNumbers().toArray());
    }
}
