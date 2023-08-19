/* класс, читающий файлы в задаваемом директории (например, на GitHub) с использованием threads
 (выдает наименования файлов и кол-во строк
*/
package logic;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//класс по чтению файлов из заданной директории с использованием threads
public class ReadFilesThreads {
    public void readFiles() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // Считываем исходный каталог для поиска файлов.
            System.out.print("Enter the source directory to search for files:");
            final String directoryPath = reader.readLine();
            reader.close();

            File directory = new File(directoryPath);
            // Убедимся, что директория найдена и это реально директория, а не файл.
            if (directory.exists() && directory.isDirectory()) {
                processDirectory(directory);
            } else {
                System.out.println("Could not find directory at specified path.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(File directory) {
        // Получаем список доступных файлов в указанной директории.
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files available for processing.");
            return;
        } else {
            System.out.println("Number of files to process: " + files.length);
        }
        // Непосредственно многопоточная обработка файлов.
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (final File f : files) {
            if (!f.isFile()) {
                continue;
            }
            service.execute(() -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    int lines = 0;
                    while (reader.readLine() != null) {
                        ++lines;
                    }
                    System.out.println("Thread: " + Thread.currentThread().getName() + ". File: " + f.getName() + ". Number of strings: " + lines);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        // Новые задачи более не принимаем, выполняем только оставшиеся.
        service.shutdown();
        // задаем время ожидания завершения выполнения потоков
//        try { service.awaitTermination(5, TimeUnit.SECONDS); } catch (InterruptedException e) {e.printStackTrace();}
    }
}
