# 로또 TODO

## domain.LottoNumber — 로또 번호 하나 (1~45)

- [x] 1 미만이면 IllegalArgumentException 발생 (0 -> 예외)
- [x] 45 초과면 IllegalArgumentException 발생 (46 -> 예외)
- [x] 문자열이 비어 있거나 숫자가 아니면 IllegalArgumentException 발생 ("", " ", "?" -> 예외)
  - 단 숫자 양옆의 공백은 편의상 제거해준다 (" 7 " -> 7)
- [x] 값이 같으면 동등하다 (equals/hashCode)

## domain.Lotto — 로또 한 장 (List<LottoNumber>)

- [x] 중복 없는 6개 번호를 오름차순으로 자동 생성한다
- [x] 자동 생성된 번호는 모두 1부터 45 사이다
- [x] 번호가 6개가 아니면 IllegalArgumentException 발생 ([1,2,3,4,5], [1..7] -> 예외)
- [x] 번호에 중복이 있으면 IllegalArgumentException 발생 ([1,1,2,3,4,5] -> 예외)
- [x] 문자열("1, 2, 3, 4, 5, 6")을 콤마로 분리해 생성한다
- [x] 받은 번호를 그대로 보관한다 (getNumbers)
- [x] 특정 번호 포함 여부를 반환한다 (contains)
- [x] 다른 로또(당첨 번호)와 일치하는 개수를 반환한다 (match)

## domain.PurchaseAmount — 구입 금액

- [x] 1000원 미만이면 IllegalArgumentException 발생 (800원 -> 예외)
- [x] 1000원 단위로 구매 가능한 로또 개수를 반환한다 (14000원 -> 14개)

## domain.Lottos — 로또 묶음 (List<Lotto>)

- [x] 구입 금액만큼 로또를 생성한다 (14000원 -> 14장)
- [x] 전체 로또의 당첨 번호 일치 개수 목록을 반환한다 (checkResult)

## domain.WinningStatistics — 당첨 통계

- [x] 로또별 일치 개수 목록을 등수별 집계 Map으로 변환한다 (부생성자)
- [x] 일치 개수별 당첨 장수를 반환한다 (countOf)
- [x] 일치 개수별 상금을 반환한다 (prizeOf: 3개 5000원, 4개 5만원, 5개 150만원, 6개 20억원)
- [x] 총 수익률을 계산한다 (총 상금 / 구입 금액)

