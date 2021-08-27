# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 문자열 덧셈 계산기

### 요구 사항

- [x] 커스텀 구분자를 추출한다. 커스텀 구분자가 없을 경우 기본 구분자를 사용한다.
- [x] 구분자를 통해서 숫자들을 추출한다.
- [x] 숫자들을 더해서 합을 구한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.



## 로또(자동)

### 요구 사항

- [x] 로또 번호는 1 ~ 45까지는 숫자이다.
- [x] 로또는 총 6개의 숫자로 구성되어 있다. 6개의 숫자는 서로 다른 숫자로 구성되어야 한다.
- [x] 로또 한장의 가격은 1000원이다.
- [x] 로또 당첨 결과를 구한다.
- [x] 6개 일치, 5개 일치, 4개 일치, 3개 일치 총 4개의 당첨 케이스가 있다. 6개일때 2000000000원, 5개일때 1500000원, 4개일때 50000원, 3개일때 5000원을 받는다.
- [x] 사용 비용과 얻은 비용은 통해서 총 수익률을 구한다.

