# 🚀 3단계 - 로또(자동)
## 기능 목록

>### I/O (input, output)
>  - InputView: Scanner를 활용하여 console을 통해 사용자 입력을 받음.
>  - OutputView: System.out을 활용하여 console에 출력.

>### Money (금액)
>  - 금액 Wrapping class

>### HitCount (일치 갯수) 
>  - 일치 갯수 Wrapping class

>### User (유저)
> - 금액을 가지고 LottoStore에게 티켓 목록을 구매.
> - winningNumber와 비교하여 lottoTicket 목록의 당첨갯수를 체크.
> - 투자금 대비 수익금 비율을 계산.

>### LottoStore (로또 가게)
> - 로또 티켓 가격을 가지고 받은 금액에 맞는 자동 로또 티켓 목록 발급.
> - 투자금을 계산.

>### LottoTicket (로또 티켓)
>  - 로또번호 일급 컬렉션을 가짐.
>  - 일치 갯수를 가짐.
  
>### LottoNumbers (로또 번호 일급 컬렉션)
>  - 6개의 로또번호 목록으로 이루어진 일급 컬렉션
>  - 자동 로또번호 생성

>### LottoNumber (로또 번호)
>  - 1~45사이의 정수

>### LottoStatement (로또 통계)  
>   - 당첨된 로또 갯수를 가짐.
>   - 수익금을 계산.

>### LottoRule(로또 규칙) 
>   - 일치 갯수별 당첨 금액을 가지는 enum 클래스


---
## 기능요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
````
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
````

### 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: AngularJS Commit Message Conventions
  
### AngularJS Commit Message Conventions 중
- commit message 종류를 다음과 같이 구분
````
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
````