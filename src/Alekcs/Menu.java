package Alekcs;
import java.io.*;
import java.util.Scanner;
import java.lang.String;
public class Menu {

    private static Matrix matrix;
    private static Line line;

    public static void start() {
        mainMenu();
    }

    //Сохранение и открытие через Бинарный файл
    private static void arrToFile(int[][] matrix, String str) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(str))) {
            dos.writeInt(matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    dos.writeInt(matrix[i][j]);
                }
            }
            System.out.println("Файл успешно сохранен " + str);
        } catch (FileNotFoundException e) {
            System.out.println("Неудачное название файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }


    private static int[][] arrFromFile(String str) throws FileNotFoundException ,IOException{
        int[][] mat = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(str))) {
            int size = dis.readInt();
            mat = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = dis.readInt();
                }
            }
            System.out.println("Файл успешно открыт");
        }
        catch (RuntimeException ex)
        {
            System.out.println("Ошибка");
        }
        return mat;
    }

    //Сохранение и открытие через текстовый файл
    private static void arrToTXTFile(String line, String str) {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(str)))) {
            writer.write(line);
        } catch (IOException e) {
            System.out.println("Ошибка записи ");
        }
        System.out.println("Файл успешно сохранен " + str);
    }

    private static String arrFromTXTFile(String str) {
        String line = null;
        try (BufferedReader reader = new BufferedReader((new FileReader(str)))) {
            line = reader.readLine();
            System.out.println("Файл успешно открыт");
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
        catch (NullPointerException e)
        {
            System.out.println("Файл пуст");
        }

        return line;
    }

    //Проверка на ввод значений меню
    public static int readChoise() {
        Scanner scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.next());
        } catch (NumberFormatException ex) {
            System.out.println("Введите только значения пунктов меню");
            readed = readChoise();
        }
        return readed;
    }

    //Проверка на ввод значений строки слов
    public static String LineRead() {
        Scanner scanner = new Scanner(System.in);
        String line;
        line = scanner.nextLine();
        return line;
    }

    //Проверка на ввод значений матрицы
    public static int[][] MatrixRead(int size) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[size][size];
        System.out.println("Введите элементы матрицы");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try
                {
                    matrix[i][j] = Integer.parseInt(scanner.next());
                }catch (NumberFormatException c)
                {
                    System.out.println("Вводите только числа");
                    matrix[i][j] = Integer.parseInt(scanner.next());
                }
            }
        }
        return matrix;
    }


    public static void Matrixx(int Number) {
        try
        {
            switch (Number)
            {
                case 2: matrix.Change();
                    break;
                case 3:matrix.Conclusion();
                    break;
                case 4:matrix.Sum();
                    break;
                case 5:matrix.PositiveArray();
                    break;
                case 6:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите будующее название файла");
                    String str = scanner.nextLine();
                    arrToFile(matrix.getMatrix(), str);
                    break;
            }
        } catch (NullPointerException ex)
        {
            if (Number == 6)
            {
                System.out.println("Нечего сохранять");
            }
            else
            {
                System.out.println("Ошибка!! Сначало задайте матрицу");
            }
        }
    }
    public static void Linee(int Number)
    {
        try
        {
            switch (Number)
            {
                case 2:line.Remove();
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите будующее название файла");
                    String str = scanner.nextLine();
                    arrToTXTFile(line.getLine(), str);
                    break;
            }
        }
        catch (NullPointerException ex)
        {
            if (Number == 3)
            {
                System.out.println("Нечего сохранять");
            }
            else
            {
                System.out.println("Ошибка!! Сначало задайте строку слов");
            }
        }
    }
    //Главное меню
    private static void mainMenu() {
        int choise = -1;
        do {
            System.out.println("Главное меню");
            System.out.println("1 - Квадратная матрица");
            System.out.println("2 - Строка слов");
            System.out.println("0 - Выход");
            choise = readChoise();

            switch (choise) {
                case 1:
                    imputMenu1();
                    break;
                case 2:
                    imputMenu2();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
        while (choise != 0);
    }

    //Подменю выбора способа взаимодествия с матрицей
    private static void imputMenu1() {
        int choise = -1;
        do {
            System.out.println("Квадратная матрица");
            System.out.println("1 - Создать матрицу");
            System.out.println("2 - Преобразовать матрицу в квадрутную");
            System.out.println("3 - Вывести матрицу");
            System.out.println("4 - Найти сумму элементов квадратной матрицы");
            System.out.println("5 - Вывести положительные элементы квадртаной матрицы");
            System.out.println("6 - Сохранить файл");
            System.out.println("0 - Выход");
            choise = readChoise();

            switch (choise) {
                case 1:
                    imputMenu3();
                    break;
                case 2:
                    Matrixx(choise);
                    break;
                case 3:
                    Matrixx(choise);
                    break;
                case 4:
                    Matrixx(choise);
                    break;
                case 5:
                    Matrixx(choise);
                    break;
                case 6:
                    Matrixx(choise);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
        while (choise != 0);
    }

    //Подменю выбора способа заполения матрицы
    private static void imputMenu3() {
        int choise = -1;
        do {
            System.out.println("Создание массива");
            System.out.println("1 - Заполенение случайными числами");
            System.out.println("2 - Считывание с файла ");
            System.out.println("3 - Задание вручную");
            System.out.println("0 - Выход");
            choise = readChoise();
            switch (choise) {
                case 1:
                    matrix = new Matrix(3);
                    choise = 0;
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла который хотите открыть");
                    String str = scanner.nextLine();

                    try
                    {
                        int[][] mat = arrFromFile(str);
                        matrix = new Matrix(mat);
                    }catch (NullPointerException ex)
                    {
                        System.out.println("Ошибка файл пуст или не существует");
                    }
                    catch (FileNotFoundException ex)
                    {
                        System.out.println("Такого файла нет");
                    }
                    catch (IOException ex)
                    {
                        System.out.println("Ошибка записи");
                    }
                    choise = 0;
                    break;
                case 3:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("размерность матрицы");
                    int size = scanner1.nextInt();
                    matrix = new Matrix(MatrixRead(size));
                    choise = 0;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
        while (choise != 0);
    }

    //Подменю выбора способа взаимодествия со стракой
    private static void imputMenu2() {
        int choise = -1;
        do {
            System.out.println("Строка слов");
            System.out.println("1 - Задать строку слов");
            System.out.println("2 - Удалить каждое третье слово");
            System.out.println("3 - Сохранить в текстовый файл");
            System.out.println("0 - Выход");
            choise = readChoise();
            switch (choise) {
                case 1:
                    imputMenu4();
                    break;
                case 2:
                    Linee(choise);
                    break;
                case 3:
                    Linee(choise);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
        while (choise != 0);
    }

    //Подменю выбора способа заполнения строки
    private static void imputMenu4() {
        int choise = -1;
        do {
            System.out.println("Строки слов");
            System.out.println("1 - Заполенение вручную");
            System.out.println("2 - Считывание с файла ");
            System.out.println("0 - Выход");
            choise = readChoise();
            switch (choise) {
                case 1:
                    line = new Line(LineRead());
                    choise = 0;
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите название файла который хотите открыть");
                    String str = scanner.nextLine();
                    String lines = arrFromTXTFile(str);
                    line = new Line(lines);
                    choise = 0;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
        while (choise != 0);
    }
}
