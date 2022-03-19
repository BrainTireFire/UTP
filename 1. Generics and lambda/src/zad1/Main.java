/**
 *
 *  @author Kawęcki Maciej S20202
 *
 */

package zad1;

import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12); /*<-- tu dopisać inicjację elementów listy */
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );/*<-- tu dopisać inicjację elementów listy */
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Selector<Integer> sel = new Selector<Integer>() {
      @Override
      public boolean select(Integer arg) {
        boolean result = false;

        if (arg < 10)
        {
          result = true;
        }
        else
        {
          result = false;
        }
        return result;
      }
    };

    /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
      @Override
      public Integer map(Integer arg) {
        return arg + 10;
      }
    };

    /*<-- zwrot wyniku \n uzyskanego przez wywołanie statycznej metody klasy ListCreator: */
    return  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Selector<String> sel = new Selector<String>() {
      @Override
      public boolean select(String arg) {
        boolean result = false;

        if (arg.length() > 3)
        {
          result = true;
        }
        else
        {
          result = false;
        }
        return result;
      }
    };

    /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    Mapper<Integer, String> map = new Mapper<Integer, String>() {
      @Override
      public Integer map(String arg) {
        return arg.length() + 10;
      }
    };

    /*<-- zwrot wyniku \n uzyskanego przez wywołanie statycznej metody klasy ListCreator: */
    return  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
