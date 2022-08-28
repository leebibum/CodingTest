package level1

class LottoHighestLowest {
    class Solution4 {
        fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
            val no0lottos = lottos.filter { it != 0 }

            val lowestCount = no0lottos.filter { win_nums.contains(it) }.size
            val highestCount = lottos.size - no0lottos.size + lowestCount

            return intArrayOf(getRanks(highestCount), getRanks(lowestCount))
        }

        private fun getRanks(lowestCount: Int): Int {
            return when (lowestCount) {
                6 -> 1
                5 -> 2
                4 -> 3
                3 -> 4
                2 -> 5
                else -> 6
            }
        }
    }
}