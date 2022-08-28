package level1

//https://school.programmers.co.kr/learn/courses/30/lessons/86491
class AtLeaseRectangle {
    class Solution3 {
        fun solution(sizes: Array<IntArray>): Int {
            //가로가 세로보다 작을 경우 변경
            val newSizes = sizes.map { if (it[0] < it[1]) it.sortedArrayDescending() else it }

            val size1s = newSizes.map { it[0] }
            val size2s = newSizes.map { it[1] }

            return size1s.maxOrNull()!! * size2s.maxOrNull()!!
        }
    }
}