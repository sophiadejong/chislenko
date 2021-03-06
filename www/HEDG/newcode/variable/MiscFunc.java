import java.io.*;

/* MiscFunc.java

   Sasha Chislenko, Madan Ramakrishnan

  06/05/98 - Sasha
    - updated increment formulas
  06/01/98 - Sasha
    - added CAPITAL_FACTOR parameter
  05/30/98 - Madan
    - now reads in parameter values
  05/25/98 - Sasha
    - Added increment functions
  05/12/98 - Sasha
   Added selectTopN function. selectTopNdiag prints some debugging data.
   It makes the models run about twice as fast as they do with quickSort.

*/

public class MiscFunc{
  public static double  GLOBAL_CLICK_RATE;
  public static long    MAX_RANDOM;
  public static boolean ADAPTIVE_INVENTORY;

  public static int    PRECISION;
  public static long   PREC_FACTOR;
  public static int    TIME_STEP;
  public static long   NUM_ACCESSES;
  public static double PERC_SITES_BORN;
  public static double PERC_SITES_DEAD;
  public static int    NUM_SITES_BORN;
  public static int    NUM_SITES_DEAD;

  public static int    NUM_BANNERS;
  public static int    MAX_START_BANNERS;
  public static int    MIN_START_BANNERS;
  public static double MIN_BAN_VS_CAT_BIAS;
  public static double MAX_BAN_VS_CAT_BIAS;
  public static double MIN_BAN_VS_SITE_BIAS;
  public static double MAX_BAN_VS_SITE_BIAS;
  public static double MAX_BAN_BIAS;
  public static double MIN_BAN_BIAS;

  public static double MAX_SITE_BIAS;
  public static double MIN_SITE_BIAS;
  public static int    NUM_SITES;
  public static double MIN_SITE_VS_CAT_BIAS;
  public static double MAX_SITE_VS_CAT_BIAS;

  public static int    MAX_CAT_PER_AGENT;
  public static int    MIN_CAT_PER_AGENT;
  public static double MIN_BIAS_PERIOD;
  public static double MAX_BIAS_PERIOD;
  public static double MIN_BIAS_SHIFT;
  public static double MAX_BIAS_SHIFT;
  public static double MIN_BIAS_AMP;
  public static double MAX_BIAS_AMP;

  public static int    NUM_CATEGORIES;
  public static double MIN_CAT_BIAS;
  public static double MAX_CAT_BIAS;
  public static double MIN_CAT_AMPLITUDE;
  public static double MAX_CAT_AMPLITUDE;
  public static double MIN_CAT_PERIOD;
  public static double MAX_CAT_PERIOD;
  public static double MIN_CAT_SHIFT;
  public static double MAX_CAT_SHIFT;

  public static double CAPITAL_FACTOR;  //  share of site capital to use for increments

  public MiscFunc() {
    String thisLine;

    try {
      FileInputStream fin =  new FileInputStream("GENERATOR.PAR");
      DataInputStream paramFile = new DataInputStream(fin);
      thisLine = paramFile.readLine();
      thisLine = paramFile.readLine();
      NUM_ACCESSES = Long.valueOf(paramFile.readLine()).longValue();
      thisLine = paramFile.readLine();
      TIME_STEP = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      PERC_SITES_BORN = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      PERC_SITES_DEAD = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      PRECISION = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      GLOBAL_CLICK_RATE = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_RANDOM = Long.valueOf(paramFile.readLine()).longValue();
      thisLine = paramFile.readLine();
      ADAPTIVE_INVENTORY = Boolean.valueOf(paramFile.readLine()).booleanValue();
      thisLine = paramFile.readLine();
      NUM_BANNERS = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MIN_START_BANNERS = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MAX_START_BANNERS = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MIN_BAN_VS_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BAN_VS_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_BAN_VS_SITE_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BAN_VS_SITE_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_BAN_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BAN_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_SITE_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_SITE_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      NUM_SITES = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MIN_SITE_VS_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_SITE_VS_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_CAT_PER_AGENT = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MAX_CAT_PER_AGENT = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MIN_BIAS_PERIOD = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BIAS_PERIOD = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_BIAS_SHIFT = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BIAS_SHIFT = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_BIAS_AMP = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_BIAS_AMP = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      NUM_CATEGORIES = Integer.valueOf(paramFile.readLine()).intValue();
      thisLine = paramFile.readLine();
      MIN_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_CAT_BIAS = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_CAT_AMPLITUDE = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_CAT_AMPLITUDE = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_CAT_PERIOD = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_CAT_PERIOD = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MIN_CAT_SHIFT = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      MAX_CAT_SHIFT = Double.valueOf(paramFile.readLine()).doubleValue();
      thisLine = paramFile.readLine();
      CAPITAL_FACTOR = Double.valueOf(paramFile.readLine()).doubleValue();

      PREC_FACTOR = (long) Math.pow(10,PRECISION);
      NUM_SITES_BORN = (int) (PERC_SITES_BORN * MiscFunc.NUM_SITES);
      NUM_SITES_DEAD = (int) (PERC_SITES_DEAD * MiscFunc.NUM_SITES);
    }
    catch (IOException e) {
      System.out.println("Error opening file: GENERATOR.PAR");
      System.exit(1);
    }
  }

  public double incrementImpressions (double Impressions) {
    if (Impressions * GLOBAL_CLICK_RATE >= 10.0)
       return Impressions;
    else
       return Impressions + 1.0;
  }

  public double incrementClicks (double Impressions, double Clicks, double ClicksToAdd) {
    if (Impressions * GLOBAL_CLICK_RATE < 10.0)
      return Clicks + ClicksToAdd;
    else
      return Clicks * (1.0 - 0.1 * GLOBAL_CLICK_RATE) + ClicksToAdd;
  }

  public static long RandomVal(long minVal, long maxVal) {
    long tempVal;

    tempVal = (int) Math.floor(Math.random() * (maxVal - minVal)) + minVal;
    if (tempVal > maxVal) tempVal = maxVal - 1;
    if (tempVal < minVal) tempVal = minVal;
    return tempVal;
  }

  public static int RandomVal(int minVal, int maxVal) {
    int tempVal;

    tempVal = (int) Math.floor(Math.random() * (maxVal - minVal)) + minVal;
    if (tempVal > maxVal) tempVal = maxVal - 1;
    if (tempVal < minVal) tempVal = minVal;
    return tempVal;
  }

  public static double RandomVal(double minVal, double maxVal) {
    double tempVal;

    tempVal = (double)
          (Math.floor(PREC_FACTOR * Math.random() * (maxVal - minVal))
               + PREC_FACTOR * minVal) / PREC_FACTOR;
    if (tempVal < minVal) tempVal = minVal;
    if (tempVal > maxVal) tempVal = maxVal;
    return tempVal;
  }

  static double[][] quickSort (double data[][],int left,int right) {
    double mid,tmp;
    int original_left=left;
    int original_right=right;
    mid=data[(left+right)/2][0];
    // System.out.println("New left boundary"+left);
    // System.out.println("New right boundary"+right);
    // System.out.println("New center = "+(left+right)/2+" "+mid);
    do {
      while(data[left][0] > mid) {
        left++;
      }
      while (mid > data[right][0]) {
        right--;
      }
      if (left<=right) {
        // System.out.println("Swapping ...");
        // System.out.println("Left  " + left+ " " + data[left]);
        // System.out.println("Right "     + right+" " + data[right]);
        tmp=data[left][0];
        data[left][0]=data[right][0];
        data[right][0]=tmp;
        tmp=data[left][1];
        data[left][1]=data[right][1];
        data[right][1]=tmp;
        tmp=data[left][2];
        data[left][2]=data[right][2];
        data[right][2]=tmp;

        left++;
        right--;
      }
    } while (left<=right);
    if (original_left<right) data=quickSort(data,original_left,right);
    if (left<original_right) data=quickSort(data,left,original_right);

    return data;
  }
/*
  This function puts the highest values in an 3-d array at the beginning,
  leaving others intact.
*/
 static int selectTopN (double data[][], int n) {
    double best, tmp;
    int topN, i, first=99, last=99;

    // find highest value:

    best = data[0][0] - 1.0;

    for (i=0; i < n; i++) {
      if (data[i][0] > best) {
        best = data [i][0];
        first=i;
        last=i;
      }
      else {
        if (data[i][0] == best)
          last = i;
      }
    }

    // put best on top:

    topN=0;

    if (first > last || data[first][0] != best || data[first][0] != best )
         System.out.println("Error: first: " + first +
                     " data: " + data[first][0] + " last: " + last +
                     " data: " + data[last][0] + " best: " + best);

    for (i=first; i <= last; i++) {
      if (data[i][0] == best ) {
        if (i != topN) {
          tmp = data[i][0];
          data[i][0] = data[topN][0];
          data[topN][0] = tmp;
          tmp = data[i][1];
          data[i][1] = data[topN][1];
          data[topN][1] = tmp;
          tmp = data[i][2];
          data[i][2] = data[topN][2];
          data[topN][2] = tmp;
        }
        topN++;
      }
    }

    return topN;
  }

 static int selectTopNdiag (double data[][], int n) {
    double best, tmp;
    int topN, i, first=0, last=0;

    // find highest value:

    best = data[0][0] - 1.0;

    for (i=0; i < n; i++) {
      if (data[i][0] > best) {
        best = data [i][0];
        first=i;
        last=i;

        if ((n == 6) && (best > 0.5))
               System.out.println("New Best: i:\t" + i + " value:\t" + best);
      }
      else {
        if (data[i][0] == best)
          last = i;
      }
    }

    if ((n == 6) && (best > 0.5)) {
        for (i=0; i < n; i++) {
          System.out.println("Unsorted data: " + i + "\t" + data[i][0]
                 + "\t" + data[i][1] + "\t" + data[i][2]);
        }
    }

    if ((n == 6) && (best > 0.5))
       System.out.println("Best: " +  "\t" + best + "   first:  " + first +  "  last: " + last);

    // put best on top:

    topN=0;

    for (i=first; i <= last; i++) {
      if (data[i][0] == best ) {
        if ((n == 6) && (best > 0.5))
          System.out.println("Put element " + i + " into place " + topN + " data:" +
          data[i][0] + " " + data[i][1] + " " + data[i][2]);
        if (i != topN) {
          tmp = data[i][0];
          data[i][0] = data[topN][0];
      data[topN][0] = tmp;
          tmp = data[i][1];
          data[i][1] = data[topN][1];
      data[topN][1] = tmp;
          tmp = data[i][2];
          data[i][2] = data[topN][2];
      data[topN][2] = tmp;
        }
        topN++;
      }
    }

        if ((n == 6) && (best > 0.5)) {
        for (i=0; i < n; i++) {
          System.out.println("Sorted data: " + i + "\t" + data[i][0]
             + "\t" + data[i][1] + "\t" + data[i][2]);
        }
     System.out.println("topN: " +  "\t" + topN);
         }

    return topN;
  }
}
