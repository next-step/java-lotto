# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2단계 - 로또(자동) Todo-List 🎯
- Domain
  - [X] 로또공 클래스(LottoBall) 생성
    - [X] 1 ~ 45 이외의 값 예외 처리 기능 추가
  - [X] 로또공 일급콜렉션(LottoBalls) 생성
    - [X] int배열 입력에 대한 데이터 생성 기능 추가
    - [X] 우승 번호 생성 기능 추가
    - [X] 입력값에 대한 우승 번호 포함 개수 기능 추가
  - [X] 매칭된 로또복권수를 인자로하는 당첨금 열거형 클래스(PrizeMoney) 생성
    - [X] 매칭개수에 따른 당첨금 계산 기능 추가
- View
  - [X] 입력 클래스 생성(InputView)
    - [X] 구매금액 입력 기능 추가
    - [X] 당첨번호 입력 기능 추가
  - [X] 출력 클래스 생성(ResultView)
    - [X] 구매수 로또 만큼 출력 기능 추가
    - [X] 당첨 통계 출력 기능 추가
- Controller
  - [X] 로또 도메인과 입출력 기능을 제어하는 클래스(LottoController) 생성
    - [X] 구매금액 입력
    - [X] 구매수 만큼 로또 출력
    - [X] 당첨번호 입력
    - [X] 당첨 통계 출력
- Util
  - [X] 로또 번호 통계 관련 함수 유틸 클래스(LottoUtil) 생성
    - [X] 로또 번호 매칭 개수 통계 기능 작성
    - [X] 당첨금 합계 계산 기능 작성
    - [X] 수익률 계산 기능 작성

## 1단계 - 문자열 덧셈 계산기 Todo-List 🎯
- [X] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 구분하는 기능(splitWithCommaOrColon) 구현
- [X] 커스텀 구분자로 문자열을 구분하는 기능(splitWithCustomDelimiter)의 구현
- [X] 유효성 체크 기능의 구현
  - [X] 분리된 문자열이 자연수인지 확인 기능(isNaturalNumber)의 구현
  - [X] 분리된 문자열이 빈문자열 또는 null 확인 기능(isNullOrEmpty)의 구현
  - [X] 분리된 문자열 배열의 자연수를 포함여부 확인 기능(containsNaturalNumber)의 구현
- [X] 쉼표(,)나 콜론(:) 또는 커스텀 구분자로 문자열을 구분 후 이를 더하는 기능(splitAndSum)의 구현
  - [X] 숫자 이외의 값 또는 음수가 전달되면 RuntimeException 예외를 throw하도록 구현