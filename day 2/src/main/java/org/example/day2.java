package org.example;

import java.util.Scanner;

public class day2 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        String t1;
        int temp;
        System.out.println("Select Option for String 1  for int 2 for array int  3  array String 4");
        int option = sc.nextInt();
        System.out.println(option);

        switch (option) {
            case 1:

                t1 = sc.next();
                char[] tChar = t1.toCharArray();
                StringBuilder st = new StringBuilder();
                for (int i = tChar.length - 1; i >= 0; i--) {
                    st.append(tChar[i]);
                }
                System.out.println(st);
                sc.close();
                break;
            case 2:

                temp = sc.nextInt();
                String sTemp = "" + temp;
                StringBuilder stringBuilder = new StringBuilder(sTemp);
                stringBuilder.reverse();

                System.out.println(stringBuilder);

                break;
            case 3:
                System.out.println("Please provide size of Array");
                int size = sc.nextInt();
                int[] arr = new int[size];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = sc.nextInt();

                }
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i]);
                }
            case 4:
                System.out.println("Please provide size of Array");
                int _size = sc.nextInt();
                StringBuilder[] stringBuilders = new StringBuilder[_size];
                for (int i = 0; i < stringBuilders.length; i++) {
                    stringBuilders[i] = new StringBuilder(sc.next());
                }

                for (int i = stringBuilders.length-1; i >=0 ; i--) {
                    System.out.println(stringBuilders[i].reverse());
                }

        }
    }
}
