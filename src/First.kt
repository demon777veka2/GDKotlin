fun main(args: Array<String>){

    println("Введите текст")
    // если через параметр ничего не пришло, передаем новые значения через ReadLine
    var list: Array<String> =  if(args.isEmpty()) {
     readLine().toString().split(" ").toTypedArray()
    }else {
        args
    }

    //Проверка  на содержание в тексте 1 слова "echo"
    if ("echo" == list[0]) {
        //удаление кавычек(") из слов
        list[1] = list[1].substring(1)
        list[list.size - 3] = list[list.size - 3].substring(0, list[list.size - 3].length - 1)

        //Уменьшаем массиву длину массива убирая 1 элемент и 2 последних элемента
        list = list.sliceArray(1..list.size-3)
    }else {
        list = list.sliceArray(1..list.size-1)
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
    val listSort = list.sorted()
    listSort.forEach(::println)

    println()
    println("Задание 3")
    println("Результат:")

    //Массив для уникальных значений элементов
    val listUnique: MutableList<String> = mutableListOf()
    var check1: Boolean = true

    //Проверка на уникальность переменных с добавление в массив listUnique
    for (element in listSort) {
        check1 = !listUnique.contains(element)
        if (check1) {
            listUnique.add(element)
        }
    }
    listUnique.forEach(::println)

    println()
    println("Задание 4")
    println("Результат:")

    var mapCollection: MutableMap<String, Int> = mutableMapOf()
    var countRepeat: Int = 0
    //Берем элемент с массива уникальных
    for (element in listUnique) {
        countRepeat = 0

        //Считаем количество совпадений с массива listSort
        for (element1 in listSort) {
            if (element == element1) {
                countRepeat++
            }
        }
        //Добавляем элемент с количесвтом его повторений в map-коллекцию
        mapCollection.put(element, countRepeat)
    }
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

