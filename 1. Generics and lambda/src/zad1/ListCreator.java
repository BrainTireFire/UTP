/**
 *
 *  @author Kawęcki Maciej S20202
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator <T> {// Uwaga: klasa musi być sparametrtyzowana
    private List<T> listGenerics;

    public ListCreator(List<T> listGenerics)
    {
        this.listGenerics = listGenerics;
    }

    public static <T> ListCreator<T> collectFrom(List<T> lista)
    {
        return new ListCreator<T>(lista);
    }

    public ListCreator<T> when(Selector<T> sel)
    {
        List<T> arrayListHelper = new ArrayList<T>();

        for (T listElement : this.listGenerics)
        {
            if (sel.select(listElement)==true)
            {
                arrayListHelper.add(listElement);
            }
        }

        this.listGenerics = arrayListHelper;

        return this;
    }

    public <M> List<M> mapEvery(Mapper<M,T> map)
    {
        List<M> arrayListHelper = new ArrayList<M>();

        for (T listElement : this.listGenerics)
        {
            arrayListHelper.add(map.map(listElement));
        }

        return arrayListHelper;
    }
}
