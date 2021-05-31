package docNumbers;

import java.io.*;
import java.util.*;

/**
 * Программа считывает пути к файлам с номерами документов (файлы-источники) и к файлу для финального отчета.
 * Номера в файлах валидируются и добавляются в отчет с комментарием.
 */

public class Runner {

    public static void main(String[] args) {

        // Для хранения пути к файл-отчету
        String pathToDocReport;

        // коллекция для хранения путей к файлам
        List<String> listOfFilesWithDocs = new ArrayList<>();

        // коллекция для хранения всех номеров из файлов в коллекции
        Set<String> listOfNumbersFromFiles = new HashSet<>();

        // коллекция для хранения всех номеров с комментариями для финального репорта
        Map<String, String> hashMapDataDocuments = new HashMap<>();

        // Считывание путей к файлам
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите пути к файлам с номерами документов: ");
            while (sc.hasNext()) {
                if (sc.hasNextInt() && sc.nextInt() == 0) {
                    sc.close();
                    break;
                } else {
                    listOfFilesWithDocs.add(sc.nextLine());
                }
            }

            // Путь к отчет-репорту
            System.out.println("Введите путь для файла с финальным отчетом: ");
            pathToDocReport = sc.nextLine(); // "D:\\!Lera\\!Учеба\\Java\\Java. TeachMeSkills\\12\\testData\\docReport.txt"
        }

        // Чтение из файлов и добавление в коллекцию для хранения в listOfNumbersFromFiles (HashSet)
        try {
            String currentLine;
            for (String pathToFileFromCollection : listOfFilesWithDocs) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFileFromCollection));
                while ((currentLine = bufferedReader.readLine()) != null) {
                    listOfNumbersFromFiles.add(currentLine);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        // Проверка номеров, затем номера и комментарии помещаются в HashMap
        for (String elementInCollection : listOfNumbersFromFiles) {
            if (DocNumberValidation.isPrefixOfNumberValid(elementInCollection)) {
                if (DocNumberValidation.isNumberLengthValid(elementInCollection)) {
                    hashMapDataDocuments.put(elementInCollection, " valid");
                } else {
                    hashMapDataDocuments.put(elementInCollection, " invalid (длина номера не соответствует требованиям");
                }
            } else {
                hashMapDataDocuments.put(elementInCollection, " invalid (префикс номера не соответствует требованиям)");
            }
        }

        // запись в файл данных из HashMap данных
        try (BufferedWriter bufferedWriterReport = new BufferedWriter(new FileWriter(pathToDocReport))) {
            for (Map.Entry setInFinalCollection : hashMapDataDocuments.entrySet()) {
                bufferedWriterReport.write(setInFinalCollection.getKey() + " " + setInFinalCollection.getValue());
                bufferedWriterReport.write('\n');
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
