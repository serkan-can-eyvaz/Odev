import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            int[] array =new int[10];
            Random rd = new Random();
            Scanner sc=new Scanner(System.in);
            long startTime = System.currentTimeMillis();
           // quickSort(array, 0, array.length - 1, Integer.parseInt("first"));
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;



            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextInt(10);
            }
            System.out.println("\n ilk dizi: ");


            for (int i=0;i< array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
            System.out.println("\n");


            int[] operationCounts = new int[10];
            for (int i = 0; i < 10; i++) {
                int pivotIndex = (int) (array.length * (i + 1) / 10.0);
                pivotIndex=Math.max(pivotIndex,0);
                pivotIndex=Math.min(pivotIndex,array.length-1);
                int[] copy=array.clone();
                operationCounts[i] = quickSort(copy, 0, copy.length - 1, pivotIndex);
                System.out.println("Pivot %" + (i + 1) * 10 + " % islem sayisi: " + operationCounts[i]);
            }


            int minIndex = 0;
            for (int i = 1; i < operationCounts.length; i++) {
                if (operationCounts[i] < operationCounts[minIndex]) {

                    minIndex = i;
                }
            }
        }

        public static int quickSort(int[] array, int start, int end, int pivotIndex) {
            if (start >= end-1) {
                return 0;
            }
            pivotIndex=Math.min(pivotIndex,array.length-1);
            end=Math.min(end,array.length-1);
            int pivot = array[pivotIndex];
            array[pivotIndex] = array[end];
            array[end] = pivot;
            int storeIndex = start;
            for (int i = start; i <= end; i++) {
                if (array[i] < pivot) {
                    int temp = array[storeIndex];
                    array[storeIndex] = array[i];
                    array[i] = temp;
                    storeIndex++;
                }
            }

            array[end] = array[storeIndex];
            array[storeIndex] = pivot;

            int leftOperations = quickSort(array, start, storeIndex - 1, pivotIndex);
            int rightOperations = quickSort(array, storeIndex + 1, end, pivotIndex);
            return 1 + leftOperations + rightOperations;
        }
    }
