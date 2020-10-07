import java.util.*

fun main() {
    //работа с текстом(задание 6)
    val text_mass: Array<String> = readLine().toString().split(" ").toTypedArray()

    if ("echo" == text_mass[0]) {
        text_mass[1] = text_mass[1].substring(1)

        val simvol: String = text_mass[text_mass.size - 1]
        text_mass[text_mass.size - 1] = simvol.substring(0, simvol.length - 1)
    }

    println()
    println("Задание 1")
    println("Результат:")

    for (i in 1..text_mass.size - 1) {
        println(text_mass[i])
    }


    println()
    println("Задание 2")
    println("Результат:")

    var time_mass_word: Array<String> = emptyArray<String>()
    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i]
    }

    time_mass_word.sort()
    for (f in 0..time_mass_word.size - 1) {
        println(time_mass_word[f])
    }

    println()
    println("Задание 3")
    println("Результат:")
    time_mass_word = emptyArray<String>()

    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i]
    }

    time_mass_word.sort()

    for (f in 0..time_mass_word.size - 1) {
        for (g in f + 1..time_mass_word.size - 1) {
            if (time_mass_word[f] == time_mass_word[g]) {
                time_mass_word[g] = ""
            }
        }
    }

    for (h in 0..time_mass_word.size - 1) {
        if (time_mass_word[h] != "") {
            println(time_mass_word[h])
        }
    }

    println()
    println("Задание 4")
    println("Результат:")
    time_mass_word = emptyArray<String>()

    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i] + " 1"
    }

    time_mass_word.sort()

    for (f in 0..time_mass_word.size - 1) {
        var koll_coincidence: Int = 1
        for (g in f + 1..time_mass_word.size - 1) {
            if (time_mass_word[f] == time_mass_word[g]) {
                time_mass_word[g] = ""
                koll_coincidence++
            }
        }
        if (time_mass_word[f] != "") {
            time_mass_word[f] = time_mass_word[f].substring(0, time_mass_word[f].length - 1) + koll_coincidence;
        }
    }

    for (h in 0..time_mass_word.size - 1) {
        if (time_mass_word[h] != "") {
            println(time_mass_word[h])
        }
    }

    println()
    println("Задание 5")
    println("Результат:")

    var max_koll_coincidence = 1

    for (i in 1 until text_mass.size) {
        time_mass_word[i - 1] = text_mass[i] + " 1"
    }

    Arrays.sort(time_mass_word)

    for (f in time_mass_word.indices) {
        val t1 = time_mass_word[f].toCharArray()
        var koll_coincidence = 1

        for (g in f + 1 until time_mass_word.size) {
            val t2 = time_mass_word[g].toCharArray()

            if (t1.size == t2.size) {
                var qer = 0
                for (ss in t1.indices) {
                    if (t1[ss] == t2[ss]) {
                        qer++
                    }
                }

                if (qer == t1.size) {
                    time_mass_word[g] = ""
                    koll_coincidence++

                    if (max_koll_coincidence < koll_coincidence) {
                        max_koll_coincidence = koll_coincidence
                    }
                }
            }
        }

        if (time_mass_word[f] !== "") {
            time_mass_word[f] = time_mass_word[f].substring(0, time_mass_word[f].length - 1) + koll_coincidence
        }
    }

    for (k in max_koll_coincidence downTo 1) {
        val list_sort_word = ArrayList<String>()
        list_sort_word.clear()
        var koll_coincidence = 0

        for (l in time_mass_word.indices) {
            val time_word = time_mass_word[l].split("".toRegex()).dropLastWhile { it.isEmpty() }

            if (time_word.size != 0 && time_word[time_word.size - 1] !== "") {
                val cifr_reapet = Integer.valueOf(time_word[time_word.size - 1])

                if (k === cifr_reapet) {
                    koll_coincidence++
                    list_sort_word.add(time_mass_word[l])
                }
            }
        }

        if (koll_coincidence > 1) {
            Collections.sort(list_sort_word)
            for (word in list_sort_word) {
                println(word)
            }

        } else if (koll_coincidence == 1) {
            for (word in list_sort_word) {
                println(word)
            }
        }
    }
}
