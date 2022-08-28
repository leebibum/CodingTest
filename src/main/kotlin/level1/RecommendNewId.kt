package level1

//https://school.programmers.co.kr/learn/courses/30/lessons/72410
class RecommendNewId {
    class Solution5 {
        fun solution(new_id: String): String {
            return new_id.lowercase()
                .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
                .replace(Regex("\\.{2,}"), ".")
                .removePrefix(".").removeSuffix(".")
                .let { it.ifBlank { "a" } }
                .let { if (it.length >= 16) it.substring(0..14) else it }.removeSuffix(".")
                .let {
                    when (it.length) {
                        1 -> it + it.last() + it.last()
                        2 -> it + it.last()
                        else -> it
                    }
                }
        }
    }
}