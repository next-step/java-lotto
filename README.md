# 로또

# Step1 문자열 덧셈 계산기

## 기능 구현 목록

1. 문자열 계산기 테스트
    1. 문자열 계산기 생성
    2. 문자열 구분자를 기준으로 문자열 수 리스트 생성
    3. 문자열 수 리스트 덧셈
2. 문자열 입력 테스트
    1. 문자열 입력 벨리데이션 테스트
    2. 문자열 입력 예외처리 테스트

## 기능 요구사항

* 쉼표`,` 또는 콜론`:` 을 구분자로 가지는 문자열을 전달
    + 구분자를 기준으로 분리한 숫자의 합 반환 `ex): "1,2:3" => 6`
    + 빈 문자열 또는 null 값을 입력할 경우 0 반환 `ex): "" or null => 0`
    + 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
    + 숫자 이외에 값 또는 음수를 전달할 경우 `RuntimeException`
* 앞의 기본 구분자(쉼표, 클론) 외에 커스텀 구분자를 지정 가능
    + 커스텀 구분자는 문자열 앞부분에 `//` 와 `\n` 사이에 위치하는 문자를 커스텀 구분자로 사용 `ex): "//;\n1;2;3" => 6`
    

# 프로그래밍 요구사항

* Indent depth 1까지 허용
* 메소드 크기가 최대 10라인을 넘지 않도록 구현
* else 사용 불가


## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
