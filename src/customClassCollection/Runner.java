package customClassCollection;

import java.util.Scanner;

/**
 * Программар работает с поьзовательской коллекцией.
 * В коллекцию записывается массив данных с уканным типом.
 * В пользовательской коллекции предусмотрену:
 * - добавление элемента;
 * - удаление элемента;
 * - проверку есть ли заданный элемент в коллекции;
 * - получение размера коллекции;
 * - получение элемента по индексу;
 * - очистка колллекции;
 * - расширение коллекции.
 *
 */

public class Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer arrayInt[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomCollection<Integer> obj = new CustomCollection<Integer>(arrayInt.length);

        try {
            System.out.println();
            System.out.println("Добавления элементов в коллекцию");
            for (int i = 0; i < arrayInt.length; i++) {
                obj.add(arrayInt[i]);
                System.out.print(obj.getElementByIndex(i) + " ");
            }
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Размер коллекции: " + obj.size());

        System.out.println("Добавление заданного элемента");
        System.out.println("Введите число (int), чтобы добавить в коллекцию: ");
        int numberAddToCollection = sc.nextInt();
        obj.add(numberAddToCollection);

        try {
            System.out.println("Текущее элементы коллекции");
            for (int i = 0; i < obj.size(); i++) {
                System.out.print(obj.getElementByIndex(i) + " ");
            }
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Текущий размер коллекции: " + obj.size());

        try {
            System.out.println("Вывести элемент по индексу (12):" + obj.getElementByIndex(-1));
            System.out.println("Вывести элемент по индексу (10):" + obj.getElementByIndex(10));
            System.out.println("Вывести элемент по индексу (9):" + obj.getElementByIndex(9));
            System.out.println("Вывести элемент по индексу (3):" + obj.getElementByIndex(3));
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        try {
            System.out.println();
            System.out.println("Текущие элементы коллекции");
            for (int i = 0; i < obj.size(); i++) {
                System.out.print(obj.getElementByIndex(i) + " ");
            }
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Проверка есть ли заданный элемент в коллекции: ");
        System.out.println("Введите число (int), чтобы проверить его наличие в коллекции (например \"3\"):");
        int isNumberExist = sc.nextInt();
        if (obj.isElementExist(isNumberExist)) {
            System.out.println(isNumberExist + " элемент находится в коллекции.");
        } else {
            System.out.println(isNumberExist + " элемент не находится в коллекции.");
        }
        System.out.println();
        System.out.println("Удаление элемента по индексу (3)");
        obj.deleteElementByIndex(3);

        try {
            System.out.println("Вывести элемент по индексу (3) после УДАЛЕНИЯ:" + obj.getElementByIndex(3));

        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Проверим есть ли элемент \"101\" в коллекции");
        if (obj.isElementExist(101)) {
            System.out.println("Элемент находится в коллекции.");
        } else {
            System.out.println("Элемент не находится в коллекции.");
        }

        try {
            System.out.println("Текущие элементы коллекции после УДАЛЕНИЯ");
            for (int i = 0; i < obj.size(); i++) {
                System.out.print(obj.getElementByIndex(i) + " ");
            }
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Размер коллекции после УДАЛЕНИЯ: " + obj.size());

        System.out.println("<Запуск очистки>");
        obj.clearCollection();

        try {
            System.out.println("Коллекция после очистки");
            for (int i = 0; i < obj.size(); i++) {
                System.out.print(obj.getElementByIndex(i) + " ");
            }
        } catch (CustomCollectionExceptions e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("Размер коллекции: " + obj.size());

        sc.close();
    }
}
