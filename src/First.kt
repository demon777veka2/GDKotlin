fun main() {
    println("Введите текст")
    //Текстом который вы вводите(задание 6)
    val text: Array<String> = readLine().toString().split(" ").toTypedArray()
    //Переменная для работы с текстом
    var text_mass: Array<String> = emptyArray<String>()

    //Проверка  на содержание в тексте 1 слова "echo"
    if ("echo" == text[0]) {
        //удаление лишних символов из слов массива
        text[1] = text[1].substring(1)
        val simvol: String = text[text.size - 3]
        text[text.size - 3] = simvol.substring(0, simvol.length - 1)
        //Присваивание массиву значения другого массива без 2 последних элементов
        for (i in 0..text.size - 3) {
            text_mass += text[i]
        }
    }else {
        text_mass = text
    }

    println()
    println("Задание 1")
    println("Результат:")

    //Вывод значений массива
    for (i in 1..text_mass.size - 1) {
        println(text_mass[i])
    }

    println()
    println("Задание 2")
    println("Результат:")

    //Пустая переменная массива для редактирования
    var time_mass_word: Array<String> = emptyArray<String>()
    //Заполнение массива time_mass_word из массива text_mass с 1 элемента
    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i]
    }
    //Сортировка массива
    time_mass_word.sort()
    //Вывод значений массива
    for (f in 0..time_mass_word.size - 1) {
        println(time_mass_word[f])
    }

    println()
    println("Задание 3")
    println("Результат:")

    //Пустая переменная массива для редактирования
    time_mass_word = emptyArray<String>()
    //Заполнение массива time_mass_word из массива text_mass с 1 элемента
    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i]
    }
    //Сортировка массива
    time_mass_word.sort()
    //Перебор элементов 1 массива для создания уникальности массива
    for (f in 0..time_mass_word.size - 1) {
        for (g in f + 1..time_mass_word.size - 1) {
            if (time_mass_word[f] == time_mass_word[g]) {
                time_mass_word[g] = ""
            }
        }
    }
    //Вывод значений массива
    for (h in 0..time_mass_word.size - 1) {
        if (time_mass_word[h] != "") {
            println(time_mass_word[h])
        }
    }

    println()
    println("Задание 4")
    println("Результат:")

    //Пустая переменная массива для редактирования
    time_mass_word = emptyArray<String>()
    //Заполнение массива time_mass_word из массива text_mass с 1 элемента
    for (i in 1..text_mass.size - 1) {
        time_mass_word += text_mass[i] + " 1"
    }
    //Сортировка массива
    time_mass_word.sort()
    //Перебор элементов 1 массива для создания уникальности массива и подсчета количества повторпений
    for (f in 0..time_mass_word.size - 1) {
        //Переменная колличества повторений
        var koll_coincidence: Int = 1
        for (g in f + 1..time_mass_word.size - 1) {
            //проверка на совпадение с подсчетом количества совпадений
            if (time_mass_word[f] == time_mass_word[g]) {
                time_mass_word[g] = ""
                koll_coincidence++
            }
        }
        //Присвоение элементу массива колл. совпадений, если он не пустой
        if (time_mass_word[f] != "") {
            time_mass_word[f] = time_mass_word[f].substring(0, time_mass_word[f].length - 1) + koll_coincidence;
        }
    }
    //Вывод значений массива
    for (h in 0..time_mass_word.size - 1) {
        if (time_mass_word[h] != "") {
            println(time_mass_word[h])
        }
    }

    println()
    println("Задание 5")
    println("Результат:")

    //Переменная максимального значения совпадений
    var max_koll_coincidence = 1
    //Заполнение массива time_mass_word из массива text_mass с 1 элемента
    for (i in 1 until text_mass.size) {
        time_mass_word[i - 1] = text_mass[i] + " 1"
    }
    //Сортировка массива
    time_mass_word.sort()
    //Перебор элементов 1 массива для создания уникальности массива и подсчета количества повторпений
    for (f in time_mass_word.indices) {
        //Цифра повторения слова в массиве
        val length_word = time_mass_word[f].toCharArray()
        var koll_coincidence = 1
        for (g in f + 1 until time_mass_word.size) {
            //Цифра повторения слова в массиве
            val length_word2 = time_mass_word[g].toCharArray()
            //Проверка длины
            if (length_word.size == length_word2.size) {
                //переменная количества элементов совпадающих с другим элементом слова
                var koll_element = 0
                //Цыкл совпадений элементов
                for (ss in length_word.indices) {
                    if (length_word[ss] == length_word2[ss]) {
                        koll_element++
                    }
                }
                //Проверка на совпадения колличества одинаковых элементов в разных переменных
                if (koll_element == length_word.size) {
                    time_mass_word[g] = ""
                    koll_coincidence++
                        //Проверка на самое большое число повторений слова в массиве
                    if (max_koll_coincidence < koll_coincidence) {
                        max_koll_coincidence = koll_coincidence
                    }
                }
            }
        }
        //Присвоение элементу массива колл. совпадений, если он не пустой
        if (time_mass_word[f] !== "") {
            time_mass_word[f] = time_mass_word[f].substring(0, time_mass_word[f].length - 1) + koll_coincidence
        }
    }
        //Цикл с максисального значения совпадений до 1, с сортировкой по цифре и алфавиту
    for (k in max_koll_coincidence downTo 1) {
        //Временный массив с элементами
        val list_sort_word = ArrayList<String>()
        list_sort_word.clear()
        var koll_coincidence = 0
        //Перебор элементов для нахождения нужного элемента конечное значение, которого равно значению цикла с переменной k
        for (l in time_mass_word.indices) {
            val time_word = time_mass_word[l].split("".toRegex()).dropLastWhile { it.isEmpty() }
            //Проверка на пустоту элемента
            if (time_word.size != 0 && time_word[time_word.size - 1] !== "") {
                val cifr_reapet = Integer.valueOf(time_word[time_word.size - 1])
                //проверка на совпадения колличеста совпадений слова со значением переменной k
                if (k === cifr_reapet) {
                    koll_coincidence++
                    list_sort_word.add(time_mass_word[l])
                }
            }
        }
        //Проверка на колличества элементов попавшие под условия "k === cifr_reapet"
        if (koll_coincidence > 1) {
            //Сортировка и вывод элементов
            list_sort_word.sort()
            for (word in list_sort_word) {
                println(word)
            }
        } else if (koll_coincidence == 1) {
            //Вывод элементов
            for (word in list_sort_word) {
                println(word)
            }
        }
    }
}

