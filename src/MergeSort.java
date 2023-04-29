public class MergeSort {

    public static void main(String[] args){
        String[] arr = {"apple","pineapple","banana","orange","berry"};
        String[] result = mergeSort(arr);
        outputResult(result);
    }

    private static String[] mergeSort(String [] arr) {
        int inputLength = arr.length;
        if(inputLength > 2){
            int middle = inputLength / 2;
            String [] leftHalf = new String[middle];
            String[] rightHalf = new String[inputLength-middle];

            for (int i = 0; i < middle; i++) {
                leftHalf[i] = arr[i];
            }

            for (int i = middle; i < inputLength; i++) {
                rightHalf[i-middle] = arr[i];
            }

            mergeSort(leftHalf);
            mergeSort(rightHalf);
            merge(arr, leftHalf, rightHalf);
        }

        return arr;
    }

    private static void merge(String[] arr, String[] leftHalf, String[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i<leftSize && j <rightSize){
            if(leftHalf[i].compareTo(rightHalf[j]) <= 0){
                arr[k] = leftHalf[i];
                i++;
            }else{
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i<leftSize){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j<rightSize){
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }


    static void outputResult(String[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
