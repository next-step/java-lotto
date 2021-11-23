## step1 기능 명세

    문자열 덧셈 계산기

    1. 문자열을 (, :) 기준으로 분리하기
    2. 분리된 문자를 숫자로 바꾸어, 그 합을 반환하기
    3. 숫자가 아니거나, 음수를 전달할 경우 RuntimeException을 throw 하기
    4. custom 구분자를 지정하여, 1 2 번을 구현하기

## 설계

    입력, 출력 (view)
    문자열 덧셈 계산기 (controller)
    숫자 (domain)

## 피드백 명세

    1. 이름이 조금 길어지더라도 줄이지 말고 명확하게
    2. validation check는 메서드 이름에서 의도를 나타내자
    3. chaining시 한 줄에 점은 하나만 찍자
    4. 매직넘버 사용을 절대 지양
    5. equals 재정의 할거면 hashcode도 재정의
    6. 계산 책임을 numbers에게 맡기는 것은 어떤지
    7. 인스턴스 생성 테스트여도 적절한 검증 필요

## 질문

    Expression의 Regex Matcher에서 한줄에 한점찍기를 어떻게 구상해야할지 어렵다.