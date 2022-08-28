package level1

//https://school.programmers.co.kr/learn/courses/30/lessons/118666
class PersonalityTypeTest {
    class Solution {
        fun solution(survey: Array<String>, choices: IntArray): String {

            val resultMap = hashMapOf<Char, Int>()
            //    index, "AB"
            for ((index, typeString) in survey.withIndex()) {
                val choiceNumber = choices[index]

                if (choiceNumber == 4) continue
                //   점수, 타입
                val (point, char) = getPointAndChar(choiceNumber, typeString)
                //타입에 점수 추가
                resultMap[char] = resultMap.getOrDefault(char, 0) + point
            }

            return getResult(resultMap)
        }

        private fun getPointAndChar(choiceNumber: Int, typeString: String): Pair<Int, Char> {
            return when (choiceNumber) {
                //비동의 점수, A타입
                1, 2, 3 -> Pair(4 - choiceNumber, typeString[0])
                //동의 점수, B타입
                else -> Pair(choiceNumber - 4, typeString[1])
            }
        }

        private fun getResult(result: HashMap<Char, Int>): String {
            val typeArray = arrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')

            return buildString {
                for (i in typeArray.indices step 2) {
                    val typeFirstPoint = result.getOrDefault(typeArray[i], 0)
                    val typeSecondPoint = result.getOrDefault(typeArray[i + 1], 0)
                    //앞 타입이 크거나 둘이 같다면 앞 타입 추가, 아니라면 뒤 타잎 추가
                    if (typeFirstPoint > typeSecondPoint || typeFirstPoint == typeSecondPoint) append(typeArray[i])
                    else append(typeArray[i + 1])
                }
            }
        }
    }
}