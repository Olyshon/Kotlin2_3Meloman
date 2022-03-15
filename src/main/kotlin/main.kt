import kotlin.math.roundToInt

fun main() {
    println("Заполним данные пользователя:")
    print("Покупатель наш постоянный клиент-меломан? Введите 1, если да:")
    val melomanFlStr: String = readLine() ?: return
    val melomanFl: Boolean = melomanFlStr == "1"
    print("Введите сумму всех предыдущих покупок (руб):")
    val lastSumString: String = readLine() ?: return
    val lastSum = lastSumString.toDouble()
    print("Введите сумму вашей сегодняшней покупки для расчета скидки (руб):")
    val curSumString: String = readLine() ?: return
    val curSum = curSumString.toDouble()

    val sumAfterSale1: Double = when {
        lastSum >= 10_001 -> curSum * 0.95
        lastSum >= 1_001 -> curSum - 100.0
        else -> curSum
    }
    val totalSum: Double = if (melomanFl) sumAfterSale1 * 0.99 else sumAfterSale1
    println()
    val kopPrint: Int = ((totalSum*100).roundToInt())%100
    if (kopPrint == 0) {
        println("Сумма к оплате: ${totalSum.toInt()} руб 00 коп")
        println("Скидка покупателя составит: ${(curSum - totalSum).toInt()} руб 00 коп")
    }
    else
    {
        println("Сумма к оплате: ${totalSum.toInt()} руб $kopPrint коп")
        println("Скидка покупателя составит: ${(curSum - totalSum).toInt()} руб ${100 - kopPrint} коп")
    }
}
