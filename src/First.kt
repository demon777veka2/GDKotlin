fun main(args: Array<String>) {

    println("Введите текст")
    // если через параметр ничего не пришло, передаем новые значения через ReadLine
    var list: Array<String> = if (args.isEmpty()) {
        readLine().toString().split(" ").toTypedArray()
    } else {
        args
    }

    //Проверка  на содержание в тексте 1 слова "echo"
    if ("echo" == list[0]) {
        //удаление кавычек(") из слов
        list[1] = list[1].replace("\"", "", true)
        list[list.size - 3] = list[list.size - 3].replace("\"", "", true)

        //Уменьшаем массиву длину массива убирая 1 элемент и 2 последних элемента
        list = list.sliceArray(1..list.size - 3)
    } else {
        list = list.sliceArray(1..list.size - 1)
    }

    println()
    println("Задание 1")
    println("Результат:")

    //Вывод значений массива
    list.forEach(::println)

    println()
    println("Задание 2")
    println("Результат:")

    //Переменная массива для сортировки массива list
    list.sorted().forEach(::println)

    println()
    println("Задание 3")
    println("Результат:")

    //Вывод уникальных значений элементов
    list.sorted().distinct().forEach(::println)

    println()
    println("Задание 4")
    println("Результат:")

    val mapCollection = list.sorted().groupingBy { it }.eachCount()

    for (i in mapCollection) {
        println(i.key + " " + i.value)
    }

    println()
    println("Задание 5")
    println("Результат:")
    //Сортировка коллекции по количеству повторений на уменьшение и алфавиту
    val result = mapCollection.toList().sortedByDescending { (_, value) -> value }.toMap()

    for (i in result) {
        println(i.key + " " + i.value)
    }

}

