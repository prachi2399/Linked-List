import java.util.ArrayList;
import java.util.Collections;

public class question {

  public static int findRhomicSum(int[][] matrix, int radius, int r, int c) {
    int sum = 0;
    sum +=
      matrix[r][c - radius] +
      matrix[r + radius][c] +
      matrix[r][c + radius] +
      matrix[r - radius][c];
    return sum;
  }

  public static ArrayList<Integer> bestRhombicAreaFrame(
    int[][] matrix,
    int radius
  ) {
    if (
      radius == 0 ||
      (2 * radius) + 1 > matrix.length ||
      (2 * radius) + 1 > matrix[0].length
    ) return new ArrayList<>();
    int n = matrix.length;
    int m = matrix[0].length;
    int sc = radius;
    int sr = radius;
    int ec = m - radius - 1;
    int er = n - radius - 1;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int r = sr; r <= er; r++) {
      for (int c = sc; c <= ec; c++) {
        ans.add(findRhomicSum(matrix, radius, r, c));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      { 4, 5, 2, 1, 6 },
      { 3, 5, 2, 1, 4 },
      { 4, 1, 4, 5, 3 },
      { 6, 2, 7, 2, 1 },
      { 10, 0, 4, 2, 7 },
    };
    int radius = 2;
    //ArrayList<Integer> ans = bestRhombicAreaFrame(matrix, radius - 1);
    String res="descognail";
    int[] sizes={3,2,3,1,1};
    String[] ans=concatSwaps(res,sizes);
    for(String ele:ans){
    System.out.print(ele);
  }
  }

  public static String[] concatSwaps(String s, int[] sizes) {
    int n = sizes.length;
    String[] ans = new String[n];
    int i = 0, j = 0;
    for (int ele : sizes) {
      ans[i] = s.substring(j, j + ele);
      j = j + ele;
      //System.out.println(ans[i]);
      i++;
    }
    for (int k = 0; k < ans.length - 2; k = k + 2) {
      swap(ans,k,k + 1);
    }
    return ans;
  }

  public static void swap(String[] ans,int i, int j) {
    String t=ans[i];
    ans[i]=ans[j];
    ans[j]=t;
  }
}
