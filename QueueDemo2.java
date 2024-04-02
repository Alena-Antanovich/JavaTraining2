/*
   A class that implements a queue for storing integers
 */

class Queue2 {
    int q[];            //  массив для хранения элементов очереди
    int putloc, getloc; //  индексы для вставки и извлечения
                        //  элементов очереди

    Queue2(int size) {
        q = new int[size]; //  выделение памяти для очереди
        putloc = getloc = 0;
    }

    //  Помещение целого числа в очередь
    void put(int el) {
        if(putloc == q.length) {
            System.out.println(" - Очередь заполнена");
            return;
        }

        q[putloc++] = el;
    }

    //  Извлечение целого числа из очереди
    int get() {
        if(getloc == putloc) {
            System.out.println(" - Очередь пуста");
            return 0;
        }

        return q[getloc++];
    }
}

//  Демонстрация использования класса Queue2
class QueueDemo2 {
    public static void main(String args[]) {
        Queue2 bigQ = new Queue2(100);
        Queue2 smallQ = new Queue2(4);
        int el;
        int i;

        System.out.println("Использование очереди bigQ для" +
                           "сохранения порядка целых чисел");
        //  Помещение целых чисел в очередь bigQ
        for(i = 0; i < 25; i++)
            bigQ.put(i);

        //  Извлечение и отображение целых чисел из
        //  очереди bigQ
        System.out.print("Содержимое очереди bigQ: ");
        for(i = 0; i < 25; i++) {
            el = bigQ.get();
            if(el != 0) System.out.print(el + " ");
        }

        System.out.println("\n");

        System.out.println("Использование очереди smallQ " +
                           "для генерации ошибок");
        //  Использование очереди smallQ для генерации ошибок
        for(i = 0; i < 5; i++) {
            System.out.print("Попытка сохранения " + (25 - i));

            smallQ.put(25 - i);

            System.out.println();
        }
        System.out.println();

        //  Дополнительные ошибки при обращении к очереди smallQ
        System.out.print("Содержимое очереди smallQ: ");
        for(i = 0; i < 5; i++) {
            el = smallQ.get();

            if(el != 0) System.out.print(el + " ");
        }
    }
}