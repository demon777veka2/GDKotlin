import java.util.*

fun main() {

    //работа с текстом(задание 6)

    var words: Array<String> = readLine().toString().split(" ").toTypedArray()

    if ("echo" == words[0]) {
        words[1] = words[1].substring(1)

        var hgf: String = words[words.size - 1]
        words[words.size - 1] = hgf.substring(0, hgf.length - 1)
    }

    println()
    println("Задание 1")
    println("Результат:")

    for (i in 1..words.size - 1) {
        println(words[i])
    }


    println()
    println("Задание 2")
    println("Результат:")

    var mass: Array<String> = emptyArray<String>()
    for (i in 1..words.size - 1) {
        mass += words[i]
    }

    mass.sort()
    for (f in 0..mass.size - 1) {
        println(mass[f])
    }

    System.out.println()
    System.out.println("Задание 3")
    System.out.println("Результат:")
    mass = emptyArray<String>()

    for (i in 1..words.size - 1) {
        mass += words[i]
    }

    mass.sort()

    for (f in 0..mass.size - 1) {
        for (g in f + 1..mass.size - 1) {
            if (mass[f] == mass[g]) {
                mass[g] = ""
            }
        }
    }

    for (h in 0..mass.size - 1) {
        if (mass[h] != "") {
            println(mass[h])
        }
    }

    println()
    println("Задание 4")
    println("Результат:")
    mass = emptyArray<String>()

    for (i in 1..words.size - 1) {
        mass += words[i] + " 1"
    }

    mass.sort()

    for (f in 0..mass.size - 1) {
        var koll: Int = 1
        for (g in f + 1..mass.size - 1) {
            if (mass[f] == mass[g]) {
                mass[g] = ""
                koll++
            }
        }
        if (mass[f] != "") {
            mass[f] = mass[f].substring(0, mass[f].length - 1) + koll;
        }
    }

    for (h in 0..mass.size - 1) {
        if (mass[h] != "") {
            println(mass[h])
        }
    }

    println()
    println("Задание 5")
    println("Результат:")

    var max_koll = 1

    for (i in 1 until words.size) {
        mass[i - 1] = words[i] + " 1"
    }

    Arrays.sort(mass)

    for (f in mass.indices) {
        val t1 = mass[f].toCharArray()
        var koll = 1

        for (g in f + 1 until mass.size) {
            val t2 = mass[g].toCharArray()

            if (t1.size == t2.size) {
                var qer = 0
                for (ss in t1.indices) {
                    if (t1[ss] == t2[ss]) {
                        qer++
                    }
                }

                if (qer == t1.size) {
                    mass[g] = ""
                    koll++

                    if (max_koll < koll) {
                        max_koll = koll
                    }
                }
            }
        }

        if (mass[f] !== "") {
            mass[f] = mass[f].substring(0, mass[f].length - 1) + koll
        }
    }

    for (k in max_koll downTo 1) {
        val list = ArrayList<String>()
        list.clear()

        var cifr = 0

        for (l in mass.indices) {
            val inf = mass[l].split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (inf.size != 0 && inf[inf.size - 1] !== "") {

                val ad1 = Integer.valueOf(k)
                val ad = Integer.valueOf(inf[inf.size - 1])

                if (ad1 === ad) {
                    cifr++
                    list.add(mass[l])
                }
            }
        }

        if (cifr > 1) {
            Collections.sort(list)
            for (word in list) {
                println(word)
            }

        } else if (cifr == 1) {
            for (word in list) {
                println(word)
            }
        }
    }

}


