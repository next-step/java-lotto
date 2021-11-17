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
    제가 짠 코드 중, LottoNumber도 일급 컬렉션이라고 부를 수 있는지 궁금합니다.