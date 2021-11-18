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

    tdd를 통해 구현한다면, private method는 포함되지 않는다고 생각하는데 맞는지 궁금합니다.
    Lotto의 역할이 단순히 LottoNumber를 호출해서 값을 반환할 뿐인데 존재 의미가 있는지 궁금합니다.
    DTO에서 생성자를 통해 도메인 객체를 전달받아 값을 구성한다면, 도메인에서 view를 의존하지 않는 것인지 궁금합니다.
    그 반대로 도메인에서 DTO를 직접 만들어 반환하는 것은 도메인에서 view를 의존하는 것인지 궁금합니다.
