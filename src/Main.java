import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        int [] num = {19,21,20,4,8,48,35};
        int [] num2 = {20,4,78,23,5,8};

        int numLength = num.length;
        int num2Length = num2.length;

        task1(Arrays.copyOf(num, numLength));
        task2(Arrays.copyOf(num, numLength));
        System.out.println(" ");
        task3(5);
        task4(Arrays.copyOf(num, numLength));
        task5(8);
        task6("Привіт світ");
        task7(Arrays.copyOf(num, numLength));
        System.out.println("Найменший спільний дільник чисел: " + task8(11,3));
        task9(5,4);
        System.out.println(" ");
        task10(Arrays.copyOf(num, numLength));
        System.out.println(" ");
        task11("Hello olleH");

        if (task12("Table", "bleta"))
            System.out.println("Так це анаграми");
        else
            System.out.println("Ні це не анаграми");

        task13(Arrays.copyOf(num, numLength));
        System.out.println(" ");
        task14(Arrays.copyOf(num, numLength));
        task15(Arrays.copyOf(num, numLength));
        System.out.println(" ");
        task16(Arrays.copyOf(num, numLength), Arrays.copyOf(num2, num2Length));

    }

    public static void task1(int [] list){
        int minNumber = list[0];
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i + 1] < minNumber){
                minNumber = list[i + 1];
            }
        }
        System.out.println("Найменше число: " +  minNumber);
    }

    public static void task2(int [] list){
        for (int repeat = 0; repeat < list.length; repeat++) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i + 1] < list[i]){
                    int tmp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = tmp;
                }
            }
        }
        System.out.print("Посортований масив: ");

        for (int num : list)
            System.out.print(num + " ");
    }

    public static void task3(int num){
        if (num == 0 || num == 1)
            System.out.println(1);
        else{
            int res = 1;
            for (int i = 2; i <= num; i++) {
                res *= i;
            }
            System.out.println("Факторіал заданого числа: " + res);
        }
    }

    public static void task4(int [] list){
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0){
                sum += list[i];
            }
        }
        System.out.println("Сума всіх парних чисел у масиві: " + sum);
    }

    public static void task5(int num){
        int counter = 0;
        if (num == 1)
            System.out.println("Не просте");
        else{
            for (int i = 1; i < num; i++) {
                if (num % i == 0)
                    counter ++;
            }

            if (counter > 2)
                System.out.println("Це не просте число");
            else
                System.out.println("Це просте число");
        }
    }

    public static void task6(String str){
        char [] letters = {'а', 'о', 'у', 'е', 'и', 'і'};
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (str.charAt(i) == letters[j]){
                    counter++;
                }
            }
        }
        System.out.println("Кількість голосних літер у данному рядку: " + counter);
    }

    public static void task7(int [] list){
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }

        int result = sum / list.length;
        System.out.println("Середнє аривметичне: " + result);
    }

    public static int task8(int num1, int num2){
        if (num1 == num2)
            return num1;
        else{
            int maxNum;
            if (num1>num2)
                maxNum = num1;
            else
                maxNum = num2;

            int num = maxNum;
            while (num % num1 != 0 || num % num2 != 0){
                num += maxNum;
            }

            return num;
        }
    }

    public static void task9(int countOfRepeats, int firstNum){
        System.out.print("Числа Фібоначі: ");

        int secondNum = firstNum + 1;
        int sum;

        System.out.print(firstNum + " ");
        System.out.print(secondNum + " ");

        for (int i = 0; i < countOfRepeats - 1; i++) {
            sum = firstNum + secondNum;
            System.out.print(sum + " ");
            firstNum = secondNum;
            secondNum = sum;
        }
    }

    public static void task10(int [] list){
        System.out.print("Пропущені цифри у масиві: ");

        int minNum = 0;
        int maxNum = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] > maxNum)
                maxNum = list[i];

            if (list[i] < minNum)
                minNum = list[i];
        }

        for (int num = minNum + 1; num < maxNum; num++) {
            boolean isFind = false;
            for (int i = 0; i < list.length; i++) {
                if (num == list[i]){
                    isFind = true;
                    break;
                }
            }
            if (!isFind)
                System.out.print(num + " ");
        }
    }

    public static void task11(String userStr){
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < userStr.length(); i++) {
            str1.append(userStr.charAt(i));
            str2.append(userStr.charAt(userStr.length() - 1 - i));
        }

        if (str1.compareTo(str2) == 0)
            System.out.println("Цей рядок є паліндромом");
        else
            System.out.println("Цей рядок не є паліндромом");
    }

    public static boolean task12(String userStr1, String userStr2){
        userStr1 = userStr1.replaceAll(" ","").toLowerCase();
        userStr2 = userStr2.replaceAll(" ", "").toLowerCase();

        if (userStr1.length() != userStr2.length())
            return false;

        char [] Str1 = userStr1.toCharArray();
        char [] Str2 = userStr2.toCharArray();
        Arrays.sort(Str1);
        Arrays.sort(Str2);

        return Arrays.equals(Str1, Str2);
    }

    public static void task13(int [] userList){
        ArrayList <Integer> list = new ArrayList<>();
        ArrayList <Integer> longestList = new ArrayList<>();

        list.add(userList[0]);

        for (int i = 1; i < userList.length; i++) {
            if (userList[i] > userList[i - 1])
                list.add(userList[i]);
            else{
                if (list.size() > longestList.size()){
                    longestList.clear();
                    longestList.addAll(list);
                }

                list.clear();
                list.add(userList[i]);
            }
        }
        System.out.print("Найбільша зростаюча послідовність: ");
        for (int i = 0; i < longestList.size(); i++) {
            System.out.print(longestList.get(i) + " ");
        }
    }

    public static void task14(int [] list){
        int different;
        int maxDifferent = 0;

        for (int i = 0; i < list.length - 1; i++) {
            different = Math.abs(list[i] - list[i + 1]);

            if (different > maxDifferent)
                maxDifferent = different;
        }
        System.out.println("Найбільша різниця чисел: " + maxDifferent);
    }

    public static void task15(int [] list){
        System.out.print("Піки у заданих масивах: ");

        int maxNum;

        if(list.length == 1){
            System.out.print(list[0]);
            return;
        }

        for (int i = 0; i < list.length - 2; i+=3) {
            maxNum = Math.max(Math.max(list[i], list[i + 1]), list[i + 2]);
            System.out.print(maxNum + " ");
        }

        if (list.length % 3 == 1)
            System.out.print(list[list.length - 1]);
        else if (list.length % 3 == 2){
            maxNum = Math.max(list[list.length - 1], list[list.length - 2]);
            System.out.print(maxNum);
        }
    }

    public static void task16(int [] firstList, int [] secondList){
        boolean isFind = false;

        System.out.print("Спільні числа: ");
        for (int i : firstList) {
            for (int j : secondList) {
                if (i == j) {
                    System.out.print(i + " ");
                    isFind = true;
                }

            }
        }
        if (!isFind)
            System.out.println("Спільних чисел не знайдено");
    }
}