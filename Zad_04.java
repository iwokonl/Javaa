import java.io.*;
import java.util.Scanner;

public class Main {
    public static int countChar(String str, char c) {
        int ilosc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                ilosc++;
            }
        }
        return ilosc;
    }

    public static int countSubStr(String str, String subStr) {
        int ilosc = 0;
        String temp = new String();
        for (int i = 0; i < str.length(); i++) {
            for (int z = 0; z < subStr.length(); z++) {
                if (z + i < str.length()) {
                    temp += str.charAt(i + z);
                }
            }
            if (temp.equals(subStr)) {
                ilosc++;
            }
            temp = new String();
        }
        return ilosc;
    }

    public static String middle(String str) {
        String strr = new String();
        if (str.length() % 2 == 0) {
            strr += str.charAt(str.length() / 2 - 1);
            strr += str.charAt(str.length() / 2);
            return strr;
        } else {
            strr += str.charAt((str.length() + 1) / 2 - 1);
            return strr;
        }
    }

    public static String repeat(String str, int n) {
        String strr = new String();
        for (int i = 0; i < n; i++) {
            strr += str;
        }
        return strr;
    }

    public static int[] where(String str, String subStr) {
        int[] tab = new int[countSubStr(str, subStr)];
        int x = 0;
        String temp = new String();
        for (int i = 0; i < str.length(); i++) {
            for (int z = 0; z < subStr.length(); z++) {
                if (z + i < str.length()) {
                    temp += str.charAt(i + z);
                }
            }
            if (temp.equals(subStr)) {
                tab[x] = i;
                x++;
            }
            temp = new String();
        }
        return tab;
    }

    static public String change(String str) {
        StringBuffer strr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                strr.append(Character.toUpperCase(str.charAt(i)));
            } else {
                strr.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return strr.toString();
    }

    static public String nice(String str) {
        int x = 0;
        StringBuffer strr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            strr.append(str.charAt(str.length() - i - 1));
            if (x % 3 == 2 && x < str.length() - 1) {
                strr.append('"');
            }
            x++;
        }
        return strr.reverse().toString();
    }

    static public String nice(String str, int n) {
        int x = 0;
        StringBuffer strr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            strr.append(str.charAt(str.length() - i - 1));
            if (x % n == n - 1 && x < str.length() - 1) {
                strr.append('"');
            }
            x++;
        }
        return strr.reverse().toString();
    }

    public static int plik(char znak) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("\nPodaj zapis do pliku\n");
            String str = scan.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader(("output.txt")));
            String line;

            while ((line = read.readLine()) != null)
                str += line;
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countChar(str, znak);
    }

    public static int plik(String znak) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("\nPodaj zapis do pliku\n");
            String str = scan.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader(("output.txt")));
            String line;

            while ((line = read.readLine()) != null)
                str += line;
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countSubStr(str, znak);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Zescanuj String pdst: ");
        String str1 = scan.nextLine();
        System.out.print("\nZescanuj String do porównania: ");
        String str2 = scan.nextLine();
        System.out.print("\nZescanuj char: ");
        char literka = scan.nextLine().charAt(0);
        System.out.print("\nZescanuj int: ");
        int liczba = scan.nextInt();
        System.out.print("\n");
        System.out.print("countChar: " + countChar(str1, literka) + "\n");
        System.out.print("countSubStr: " + countSubStr(str1, str2) + "\n");
        System.out.print("middle: " + middle(str1) + "\n");
        System.out.print("repeat: " + repeat(str1, liczba) + "\n");
        System.out.print("where: " + where(str1, str2) + "\n");
        System.out.print("change: " + change(str1) + "\n");
        System.out.print("nice: " + nice(str1) + "\n");
        System.out.print("nice2: " + nice(str1, liczba) + "\n");
        System.out.print("plik: " + plik(literka) + "\n");
        System.out.print("plik2: " + plik(str2) + "\n");
    }
}
