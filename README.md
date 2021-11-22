# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구사항

* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

```
구입금액을 입력해 주세요.
5000
5개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개일치, 보너스 볼 일치 (30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 힌트

* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항

* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* java enum을 적용해 프로그래밍을 구현한다.
* 규칙 8: 일급 콜렉션을 쓴다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.

## 힌트

* 일급 콜렉션을 쓴다.
    * 6개의 숫자 값을 가지는 java collection을 감싸는 객체를 추가해 구현해 본다.
* 하드코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum을 활용해 상수 값을 제거한다. 즉, enum을 활용해 일치하는 수를 로또 등수로 변경해 본다.

```
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
		
    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return null;
    }
}
```

## 기능 목록 및 commit 로그 요구사항

* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

--------

## TODO-LIST

- [X] 로또 구입 금액을 입력받는다.
- [X] 구입 금액은 아라비아 숫자만 입력 가능하다.
- [X] 로또 1장당 1000원 으로 10300원 입력하면 로또가 10장 이 구매 된다.
- [X] 나머지 300원은 절삭한다.
- [X] 금액만큼 로또를 구매한다.
- [X] 로또번호를 자동으로 생성한다.
- [X] 로또 1장의 번호는 6개 이다.
- [X] 로또 1장의 6개 번호는 중복번호가 없다.
- [X] 구입한 로또 개수만큼 번호를 생성한다.
- [X] 지난 주 당첨번호를 입력받는다.
- [X] 당첨번호는 6개 이며 중복번호가 없다.
- [X] 보너스 볼 번호를 입력받는다.
- [X] 당첨번호와 로또 번호를 비교해 당첨 개수를 확인한다.
- [X] 로또 번호가 5개 당첨시 보너스 볼 당첨여부를 확인한다.
- [X] 등수별로 당첨금액을 구한다. (로또별로 당첨금액을 확인한다.)
- [X] 당첨 개수에 따라 금액이 달라진다.
- [X] 당첨번호 개수별 당첨금, 당첨 개수를 출력한다.
- [X] 총 당첨금액을 구한다.
- [X] 구매금액 기준을 1로 할때 당첨금액 / 구매금액 의 결과를 출력한다.
