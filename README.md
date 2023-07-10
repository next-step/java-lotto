# 로또 미션

## 요구사항

[페어 컨벤션](https://seeunchoi.notion.site/Pair-Convention-d4bb194e74704642b6937b3266c8de99?pvs=4)

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항

- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.

## 1차 기능 구현

- 로또 구입 금액을 입력한다.
- 구입 금액에 해당하는 로또를 발급한다.
- 로또 1장의 가격은 1000원이다.
- 지난 주 당첨 번호를 입력한다.
- 보너스 볼을 입력한다.
- 발급된 로또를 통해 당첨 통계를 낸다.
- 총 수익률을 계산한다.
