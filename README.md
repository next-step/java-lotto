# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step 3, 로또(자동)

### 기능 요구사항

1. 로또
    - 로또는 6개의 숫자를 이용하여 생성한다.
    - 각 숫자는 중복되지 않으며 1 ~ 45 사이의 수로 구성되어 있다.
    - 로또 번호 표기 시 오름차순으로 정렬한다.

2. 로또 구매
    - 천 원당 1장의 로또를 구매할 수 있다.
    - 총 구입 금액은 외부에서 입력되며, 여러 개의 로또를 한 번에 구매할 수 있다.
    - 구매한 로또의 개수를 계산한다.

3. 로또 생성
    - 로또를 구매하면 로또가 생성된다.
    - 로또 번호는 무작위로 생성된다.

4. 당첨 번호 생성
    - 당첨 번호는 외부에서 입력된다.
    - 입력되는 당첨 번호 또한 일반적인 로또 규칙을 따라야 한다.
        - 규칙에 어긋나면 오류가 발생한다.

5. 당첨 통계
    - 당첨 번호와 로또 번호가 3개 이상 일치하면 당첨으로 간주한다.
    - 당첨금 기준은 아래와 같다.
        ```text
        3개 일치 - 5,000원
        4개 일치 - 50,000원
        5개 일치 - 1,500,000원
        6개 일치 - 2,000,000,000원
        ```
    - 당첨 로또가 몇 개인지 경우별로 출력한다. (3개 일치 - 1, 4개 일치 - 0, ...)
    - 총 수익률을 집계해야 한다.
        - 총 수익률은 당첨금 합을 구매액으로 나눈 결과이다.
