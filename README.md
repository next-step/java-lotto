# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 기능 목록

- 문자열 입력 기능
- 입력된 문자열을 쉼표,콜론으로 나누는 기능
- 나누어진 문자열을 숫자로 변환하는 기능
  - 숫자가 빈값(null or "") 일때 0으로 변환하는 기능
  - 숫자가 음수일때 예외처리 하는 기능
- 덧셈 기능
- 덧셈 결과 출력 기능
- 커스텀 구분자 검증 기능

# step2 - 로또  기능 목록

- 금액 입력 기능 (O)
- 입력한 금액으로 살 수 있는 로또 개수 계산 기능 (O)
- 로또 공 객체 생성 기능 (O)
  - 로또번호는 1~45 까지 생성 가능
  - 로또 객체는 한번만 생성해서 재사용하는 식으로 구현
- 로또 게임 기능 (O)
  - 로또 게임 한번에 6개의 서로 다른 로또 객체가 만들어져야 함
  - 한 게임에 뽑는 공들을 저장해 놔야함
- 뽑은 공들을 출력하는 기능 (O)
- 당첨 번호 입력 기능 (O)
- 당첨 통계 계산 기능 (O)
  - 당첨 번호와 일치하는 공의 개수 구하기
  - 수익률 계산(소수점 둘째자리?)
- 통계 출력 기능 (O)

# step3 - 로또 기능 목록

- 보너스 볼 입력 기능
- 2등 계산 기능 (아래 둘 중 하나)
  - 입력받은 6개의 볼 계산 후에 5개의 공이 일치하는 것만 추가로 보너스볼을 비교하는 방식
  - 입력받은 볼6개와 보너스 볼을 한번에 계산하는 기능
- 2등 보너스 통계 출력 기능

# step4 - 로또 기능 목록

- 수동으로 구매할 로또 수 입력
- 수동으로 구매할 로또 수를 제외한 자동 로또 수 계산기능
- 수동으로 구매할 로또번호 입력
- 수동으로 구매한 로또번호 리스트와 자동으로 구매한 리스트를 합치는 기능