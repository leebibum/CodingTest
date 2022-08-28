package level1

import java.util.*

//https://school.programmers.co.kr/learn/courses/30/lessons/92334
class GetReportResults {
    class Solution2 {
        fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
            val reporters = report.distinct()
                .groupBy { it.split(' ')[1] }
                .filter { it.value.size >= k }
                .values.flatten()
                .map { it.split(' ').first() }
                .sorted()

            val mailCount = id_list.map { id -> reporters.count { it == id } }

            return mailCount.toIntArray()
        }
    }
}