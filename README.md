# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 로또 3단계 피드백
* Lotto의 isContainsUserLottoNumber 리턴 타입 boolean으로 수정 (Done. 삼항연산자 활용)
* LottoNumber에 final 키워드 활용 (Done)
* LottoRevenue가 static이어야하는지 고민 (Done)
* LottoMatchTest에서 MethodSource 활용하기 (Done)

## TO-DO : 로또 4단계
* 수동 구매할 로또 수 입력 -> InputView (총 구매 수보다 많으면 예외)
* 수동 구매 번호 입력 -> InputView
* StringUtils 이용해서 String 리스트로 만들고 LottoNumber에 문자열 생성자 추가해서 Lotto 객체 만들기
* Lotto에 String 배열을 인자로 가지는 생성자 추가
* 수동 구매 수와 자동 구매 수 계산 -> LottoShop
* 수동 로또 리스트와 자동 로또 리스트 생성 과정 분리 -> LottoGenerator
* 수동 구매 수와 자동 구매 수 출력 -> ResultView