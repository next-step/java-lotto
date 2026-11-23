# 로또 TODO

## domain.Lotto — 로또 한 장 (List<Integer>)

- [x] Collections.shuffle()로 중복 없는 6개 번호를 오름차순으로 자동 생성한다
- [x] 번호에 1 미만의 숫자가 포함되면 IllegalArgumentException 발생 ([0,2,3,4,5,6] -> 예외)
- [x] 번호에 45 초과 숫자가 포함되면 IllegalArgumentException 발생 ([1,2,3,4,5,46] -> 예외)
- [x] 번호가 6개 미만이면 IllegalArgumentException 발생 ([1,2,3,4,5] -> 예외)
- [x] 번호가 6개를 초과하면 IllegalArgumentException 발생 ([1,2,3,4,5,6,7] -> 예외)
- [x] 번호에 중복이 있으면 IllegalArgumentException 발생 ([1,1,2,3,4,5] -> 예외)
- [x] 받은 번호를 그대로 보관한다 (getNumbers)
- [x] 당첨 번호와 비교해 일치하는 개수를 반환한다 (match)

## domain.Lottos — 로또 묶음 (List<Lotto>)

- [x] 구입 금액 1000원 단위로 로또 개수가 생성된다 (14000원 -> 14개)
- [x] 전체 로또의 당첨 번호 일치 개수 목록을 반환한다 (checkResult)
- [x] 금액이 1000원 미만일 경우 IllegalArgumentException 발생 (800원 -> 예외 발생)

## domain.WinningNumber — 지난 주 당첨 번호

- [x] 문자열("1, 2, 3, 4, 5, 6")을 콤마로 분리해 숫자 목록으로 변환한다
- [x] 콤마(,) 사이가 공백이거나 비어 있으면 IllegalArgumentException 발생 ("4, ,5" -> 예외)
  - 단 콤마(,)와 숫자 사이의 공백은 편의상 제거해준다 (요구사항에 없어서 내가 정한 규칙)
- [x] 특정 번호 포함 여부를 반환한다 (contains)
- [x] 콤마(,) 사이가 숫자가 아닐 경우 IllegalArgumentException 발생 ("?,/,1" -> 예외)
- [x] 번호가 1부터 45 사이가 아니면 IllegalArgumentException 발생 ("0,2,3,4,5,6" -> 예외)
- [x] 번호가 6개가 아니거나 중복이 있으면 IllegalArgumentException 발생 ("1,1,2,3,4,5" -> 예외)

## domain.WinningStatistics — 당첨 통계

- [x] 로또별 일치 개수 목록을 등수별 집계 Map으로 변환한다 (부생성자)
- [x] 일치 개수별 당첨 장수를 반환한다 (countOf)
- [x] 일치 개수별 상금을 반환한다 (prizeOf: 3개 5000원, 4개 5만원, 5개 150만원, 6개 20억원)
- [x] 총 수익률을 계산한다 (총 상금 / 구입 금액)
