## 설계

    view
    입력 -> LottoInput
    출력 -> LottoOutput
    DTO -> LottosDTO

    controller
    흐름 제어 -> LottoMain

    model
    로또 번호 관리 -> Lotto
    일급 컬렉션 -> Lottos

    LottoMain -> Lottos -> Lotto -> LottoNumbers -> LottoNumber

## 질문

    
    DTO에서 생성자를 통해 도메인 객체를 전달받아 값을 구성한다면, 도메인에서 view를 의존하지 않는 것인지 궁금합니다.
    그 반대로 도메인에서 DTO를 직접 만들어 반환하는 것은 도메인에서 view를 의존하는 것인지 궁금합니다.

    1. 기능명세 질문
    2. LottoNumbers 말고 Lotto가 바로 일급 컬렉션이 된다는 것인지
    3. static final 상수들의 이름이 ZERO 가 더 명확한 것인지
    4. 삼항 연산자 없애는게 어려워서, 함수로 빼려니 매개변수가 많아지고 stream으로 해결했는데 어떻게 생각하시는지
    

## 피드백 명세

    1. 생성자는 생성자들끼리 ㅇ
    2. 사용자 정의 예외 ㅇ
    3. LottoNumbers가 Lotto가 되어도 될 것 같다
    4. 로또번호 만들기 sublist ㅇ
    5. 로또 상금 enum 꽝도 추가해보기 ㅇ
    6. enum에서 stream 활용하여 winnings 처리하기 ㅇ
    7. Lottos에서 Map을 불변 객체로 바꿔보기
    8. 삼항 연산자 없애보기 ㅇ
    9. static class들의 인스턴스화 막기
    10. 테스트를 경계값으로
